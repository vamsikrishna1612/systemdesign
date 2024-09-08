package cache.storage;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> storage;
    int capacity;

    public HashMapBasedStorage(int capacity){
        storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) throws StorageFullException{
        if(storage.size()>=capacity) throw new StorageFullException("Capacity Full");
        storage.put(key, value);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw new NotFoundException("Not available in the cache");
        return storage.get(key);
    }

    @Override
    public void remove(Key key ) throws NotFoundException{
        if(!storage.containsKey(key)) throw new NotFoundException(("Not available in the cache"));
        storage.remove(key);
    }


}
