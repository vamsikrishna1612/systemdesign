import cache.Cache;
import cache.policies.EvictionPolicy;
import cache.policies.LRUEvictionPolicy;
import cache.storage.HashMapBasedStorage;
import cache.storage.Storage;

public class Main{
    public static void main(String[] args) throws Exception {
        Storage<String, String > storage = new HashMapBasedStorage<>(2);
        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();
        Cache<String, String> cache = new Cache<>(storage, evictionPolicy);
        cache.put("1","Vamsi");
        cache.put("2", "krishna");
        cache.get("1");
        cache.put("7", "harsha");
        cache.get("7");
        cache.get("2");
    }
}