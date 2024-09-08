package cache.storage;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;

public interface Storage<Key,Value> {
    public void put(Key key, Value value) throws StorageFullException ;

    Value get(Key key) throws NotFoundException;

    void remove(Key key) throws NotFoundException;
}
