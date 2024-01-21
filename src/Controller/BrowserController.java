package Controller;

import Common.Library;
import Model.Browser;
import Model.Stack;
import View.Menu;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserController extends Menu<String> {

    private static String[] mc = {"Add page", "Back button", "Forward button", "History", "Navigate Back", "Navigate Forward", "Return to menu"};
    private Stack<Browser> backStack;
    private Stack<Browser> forwardStack;
    private Browser currentBrowser;
    private Library library = new Library();
    private Stack<Browser> history = new Stack<>();

    public BrowserController(Menu<String> parentMenu) {
        super("FPT Browser", mc, MainController.parentMenu);
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentBrowser = new Browser("Home", "Welcome to the homepage.");
        forwardStack.push(new Browser("Facebook", "Is IT dead??"));
        forwardStack.push(new Browser("X", "Come and get me <33"));
        forwardStack.push(new Browser("Reddit", "Hey guys, do you know that in terms of..."));
        forwardStack.push(new Browser("Instagram", "Watch your friends flexing on you today!"));
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAddPage();
                break;
            case 2:
                goBack();
                break;
            case 3:
                goForward();
                break;
            case 4:
                getHistory();
                break;
            case 5: {
                try {
                    navigateBack();
                } catch (Exception ex) {
                    System.out.println("Hehe chua fix");
                }
                break;
            }
            case 6: {
                try {
                    navigateForward();
                } catch (Exception ex) {
                    Logger.getLogger(BrowserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 7:
                System.out.println("Returning");
                returnToPMenu();
                break;
        }
    }

    public void doAddPage() {
        while (true) {
            String pageTitle = library.getString("Enter page name: ");
            String desc = library.getString("Enter page descriptions: ");
            Browser newBrowser = new Browser(pageTitle, desc);
            forwardStack.push(newBrowser);
//            currentBrowser = newBrowser;
            System.out.println("Added a new page: " + newBrowser);
            String choice = library.getString("Continue (y/n)?: ");
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    /**
     * pop the current backstack push current browser to forward stack current
     * browser point to the browser popped by the backstack
     */
    public void goBack() {
        try {
            Browser temp = backStack.pop();
            if (currentBrowser != null) {
                history.push(currentBrowser);
            }
            forwardStack.push(currentBrowser);
            currentBrowser = temp;
            System.out.println("Went back to: " + currentBrowser);
        } catch (Exception e) {
            System.out.println("Cannot go back. Stack is empty.");
        }
    }

    public void goForward() {
        try {
            Browser temp = forwardStack.pop();
            if (currentBrowser != null) {
                history.push(currentBrowser);
            }
            backStack.push(currentBrowser);
            currentBrowser = temp;
            System.out.println("Went forward to: " + currentBrowser);
        } catch (Exception e) {
            System.out.println("Cannot go forward. Stack is empty.");
        }
    }


    private void navigateBack() throws Exception {
        int pageChoice = library.getInt("How many page do you want to back: ");
        if (pageChoice >= 1 && pageChoice <= backStack.size()) {
            while (pageChoice > 0 && !backStack.isEmpty()) {
                Browser temp = backStack.pop();
                forwardStack.push(currentBrowser);
                currentBrowser = temp;
                pageChoice--;
            }
            System.out.println("Went back to: " + currentBrowser);
            if (currentBrowser != null) history.push(currentBrowser);
        } else {
            System.out.println("Cannot back further!");
        }
    }


    private void navigateForward() throws Exception {
        int steps = library.getInt("How many page do you want to go forward: ");
        if (steps >= 1 && steps <= forwardStack.size()) {
            while (steps > 0 && !forwardStack.isEmpty()) {
                Browser temp = forwardStack.pop();
                backStack.push(currentBrowser);
                currentBrowser = temp;
                steps--;
            }
            System.out.println("Went forward to: " + currentBrowser);
            if (currentBrowser != null) {
                history.push(currentBrowser);
            }
        } else {
            System.out.println("Cannot forward further");
        }
    }

    public void getHistory() {
        if (history.isEmpty()) {
            System.out.println("Browser is empty, go surfing :3");
        } else {
            System.out.println("Browsing History:");
            printStack(history);
            System.out.println("Total: " + history.size());
        }

    }

    private void printStack(Stack<Browser> stack) {
        List<Browser> elements = stack.getElements();

        if (elements.isEmpty()) {
            return;
        }

        for (Browser browser : elements) {
            System.out.println(browser);
        }
    }
}
