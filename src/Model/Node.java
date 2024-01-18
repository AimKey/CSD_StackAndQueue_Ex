package Model;

public class Node<T> {

    T dataOfNode;
    Node<T> next;
    Node<T> pre;

    public Node() {
    }

    public Node(T dataOfNode, Node next) {
        this.dataOfNode = dataOfNode;
        this.next = next;
    }

    public Node(T dataOfNode, Node next, Node pre) {
        this.dataOfNode = dataOfNode;
        this.next = next;
        this.pre = pre;
    }
    
    public T getNodeData() {
        return dataOfNode;
    }

    public void setNodeData(T dataOfNode) {
        this.dataOfNode = dataOfNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
