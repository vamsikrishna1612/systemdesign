package cache.Algorithms.linkedlist;

public class DoublyLinkedListNode<Element> {
    Element element;
    DoublyLinkedListNode<Element> prev, next;

    public Element getElement() {
        return element;
    }

    public DoublyLinkedListNode(Element element){
        this.element=element;
        prev = next = null;
    }
}
