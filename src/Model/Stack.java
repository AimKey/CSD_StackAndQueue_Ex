package Model;

/**
 *
 * @author phamm
 */
public class Stack<T> {

    Node<T> head;

    public void push(T data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            head = new Node(data, head);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty stack");
        }
        T res = head.getNodeData();
        head = head.next;
        return res;
    }
    
    public T peek() throws Exception {
        if (isEmpty()) throw new Exception ("Stack is empty!");
        return head.getNodeData();
    }
    
    public void display() {
        Node n = head;
        while (n != null) {
            System.out.println(n.getNodeData());
            n = n.next;
        }
    }
}
