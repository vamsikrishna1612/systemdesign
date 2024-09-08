package cache.Algorithms.linkedlist;

import cache.exceptions.InvalidElementException;

import java.util.NoSuchElementException;

public class DoublyLinkedList<Element> {

    DoublyLinkedListNode<Element> dummyHead, dummyTail;

    public DoublyLinkedList(){
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public DoublyLinkedListNode<Element> getFirstNode() throws NoSuchElementException {
        if(isItemPresent())
            return dummyHead.next;
        return null;
    }

    public DoublyLinkedListNode<Element> getLastNode() throws NoSuchElementException{
        if(isItemPresent()) return dummyTail.prev;
        return null;
    }

    private boolean isItemPresent(){
        return dummyHead.next != dummyTail;
    }

    public void detachNode(DoublyLinkedListNode<Element> node){
        if(node!=null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public DoublyLinkedListNode<Element> addElementAtLast(Element element){
        if(element==null) throw new InvalidElementException();
        DoublyLinkedListNode<Element> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public void addNodeAtLast(DoublyLinkedListNode<Element> node){
        DoublyLinkedListNode<Element> tailPrev = dummyTail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = dummyTail;
        dummyTail.prev=node;
    }
}
