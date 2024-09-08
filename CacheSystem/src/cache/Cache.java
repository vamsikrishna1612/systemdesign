package cache;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;
import cache.policies.EvictionPolicy;
import cache.storage.Storage;

public class Cache<Key, Value> {

    Storage<Key, Value> storage;
    EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key) {
        try{
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            System.out.println("value of the provided key: " +key + " is " +value);
            return value;
        }catch(NotFoundException notFoundException){
            System.out.println("Tried to access non-existing value");
            return null;
        }
    }

    public void put(Key key, Value value){
        try{
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }catch(StorageFullException storageFullException){
            Key keyToRemove = evictionPolicy.evictKey();
            if(keyToRemove==null) throw new RuntimeException("Unexpected error");
            try {
                storage.remove(keyToRemove);
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
            put(key, value);
        }
    }


}
