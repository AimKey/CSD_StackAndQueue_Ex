package Model;

public class PrintJob implements Comparable<PrintJob> {
    private String name;
    private int priority;

    public PrintJob(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PrintJob other) {
        // Higher priority should come first in the queue
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
