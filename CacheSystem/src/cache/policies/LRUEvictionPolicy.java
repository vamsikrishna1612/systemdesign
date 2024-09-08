package cache.policies;

import cache.Algorithms.linkedlist.DoublyLinkedList;
import cache.Algorithms.linkedlist.DoublyLinkedListNode;

import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    DoublyLinkedList<Key> doublyLinkedList;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        doublyLinkedList = new DoublyLinkedList<>();
        mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            doublyLinkedList.detachNode(mapper.get(key));
            doublyLinkedList.addNodeAtLast(mapper.get(key));
        }else{
            DoublyLinkedListNode<Key> node = doublyLinkedList.addElementAtLast(key);
            mapper.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = doublyLinkedList.getFirstNode();
        if(first==null)
            return null;
        doublyLinkedList.detachNode(first);
        return first.getElement();
    }
}
