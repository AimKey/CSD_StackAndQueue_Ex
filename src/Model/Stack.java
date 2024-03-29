package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * linkedList implement
 *
 * @author phamm
 * @param <T>
 */
public class Stack<T> {

    Node<T> head;
    int size = 0;
    public void push(T data) {
        if (head == null) {
            head = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
        size++;
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
        size--;
        return res;
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return head.getNodeData();
    }

    public void display() {
        Node<T> n = head;
        while (n != null) {
            System.out.println(n.getNodeData());
            n = n.next;
        }
    }

    public void clear() {
        this.head = null;
        size = 0;
    }

    public List<T> getElements() {
        List<T> elements = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            elements.add(current.getNodeData());
            current = current.next;
        }

        return elements;
    }

    public int size() {
        return size;
    }
}
