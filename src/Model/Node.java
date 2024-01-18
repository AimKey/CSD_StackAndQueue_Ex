package Model;

public class Node<T> {

    T dataOfNode;
    Node<T> next;
    Node<T> pre;

    public Node() {
    }

    public Node(T dataOfNode, Node<T> next) {
        this.dataOfNode = dataOfNode;
        this.next = next;
    }

    public Node(T dataOfNode, Node<T> next, Node<T> pre) {
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

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
