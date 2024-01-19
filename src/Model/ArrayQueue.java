package Model;

/**
 * Implements by using array
 *
 * @author phamm
 */
public class ArrayQueue<T> {

    protected Node<T>[] a;
    protected int max, first, last; // First is for dequeue, last is for enqueue

    public ArrayQueue(int max) {
        this.max = max;
        a = new Node[max];
//        Dat con tro dau va cuoi o vi tri -1 (Chua nam trong array)
        first = last = -1;
    }

    public ArrayQueue() {
        this(10);
    }

    /**
     *
     * @return boolean True or False
     */
    public boolean isEmpty() {
        return first == -1;
    }
    
//    first o vi tri dau -> Sau khi chay het 1 vong
//    last o vi tri cuoi - 1 -> Sau last o cuoi array
    public boolean isFull() {
        return (first == 0 && last == max - 1 || first == last + 1);
    }

    private boolean grow() {
        int i, j;
        int max1 = max + max / 2;
        Node[] a1 = new Node[max1];
        if (last >= first) {
            for (i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i < max; i++) {
                a1[i - first] = a[i];
            }
            i = max - first;
            for (j = 0; j <= last; j++) {
                a1[i + j] = a[j];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return (true);
    }

    public void enqueue(Node x) {
//        If array queue is empty, grow 
        if (isFull() && !grow()) {
            return;
        }
//        Last o cuoi (Luc nay cho no quay ve dau hoac chua khoi tao)
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
//            First khoi tao chua, neu chua thi cho no len 0
            if (first == -1) {
                first = 0;
            }
//            tang pointer last va gan = x
        } else {
            a[++last] = x;
        }
    }

    /**
     * Tra ve phan tu o dau va ko xoa
     *
     * @return Node<T>
     */
    public Node<T> front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (a[first]);
    }

    /**
     * Tra ve va xoa phan tu o dau
     *
     * @return Node<T>
     */
    public Node<T> dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Node<T> x = a[first];
        if (first == last) // only one element, get em and reset
        {
            first = last = -1;
        } else if (first == max - 1) {
//           Dang o cuoi array, quay ve dau
            first = 0;
        } else {
//            Lay phan tu o dau ok, advance
            first++;
        }
        return (x);
    }

    public void display() {
        int count = 0;
        for (Node<T> node : a) {
            if (node != null) {
                System.out.print("[" + node.getNodeData() + "] ");
                count++;
            }
        }

        if (isEmpty()) {
            System.out.print("[Empty]");
        }

        System.out.println("\nTotal: " + count);
        System.out.println("First: " + first + ", Last: " + last);
    }

}
