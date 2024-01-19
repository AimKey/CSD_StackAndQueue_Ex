package Controller;

import Common.Library;
import Model.ArrayQueue;
import Model.Node;
import Model.PrintJob;
import View.Menu;

public class PrintController extends Menu<String> {
    private ArrayQueue<PrintJob> printQueue;
    private Library library;

    private static String[] mc = {"Add item", "Print item", "Display queue", "View current item", "Return"};

    public PrintController(Menu parentMenu) {
        super("Print queue", mc, MainController.parentMenu);
        printQueue = new ArrayQueue<>();
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addPrintJob();
                break;
            case 2:
                printNextJob();
                break;
            case 3:
                displayQueue();
                break;
            case 4:
                viewCurrentItem();
                break;
            case 5:
                returnToPMenu();
                break;
        }
    }

    private void addPrintJob() {
        String jobName = library.getString("Enter job name: ");
        int jobPriority = library.getInt("Enter job priority: ");
        PrintJob newJob = new PrintJob(jobName, jobPriority);
        printQueue.enqueue(new Node<>(newJob, null));
        System.out.println("Print job added: " + newJob);
    }

    private void printNextJob() {
        try {
            Node<PrintJob> nextJobNode = printQueue.dequeue();
            PrintJob nextJob = nextJobNode.getNodeData();
            System.out.println("Printing: " + nextJob);
        } catch (Exception e) {
            System.out.println("Print queue is empty.");
        }
    }

    private void displayQueue() {
        System.out.println("Print Queue:");
        printQueue.display();
    }

    private void viewCurrentItem() {
        try {
            Node<PrintJob> currentJobNode = printQueue.front();
            PrintJob currentJob = currentJobNode.getNodeData();
            System.out.println("Current item in the queue: " + currentJob);
        } catch (Exception e) {
            System.out.println("Print queue is empty.");
        }
    }
}
