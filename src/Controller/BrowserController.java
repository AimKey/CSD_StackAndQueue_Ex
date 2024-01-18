package Controller;

import Common.Library;
import Model.Browser;
import Model.Stack;
import View.Menu;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserController extends Menu<String> {

    // private Menu<String> parentMenu;
    private static String[] mc = {"Add page", "Back button", "Forward button", "History", "Navigate", "Return to menu"};
    private Stack<Browser> backStack;
    private Stack<Browser> forwardStack;
    private Browser currentBrowser;
    private Library library = new Library();

    public BrowserController(Menu<String> parentMenu) {
        super("FPT Browser", mc, parentMenu);
        this.parentMenu = parentMenu;
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentBrowser = new Browser("Home", "Welcome to the homepage.");
        forwardStack.push(new Browser("Facebook", "Is IT dead??"));
        forwardStack.push(new Browser("X", "Come and get me <33"));
        backStack.push(new Browser("Reddit", "Hey guys, do you know that in terms of..."));
        backStack.push(new Browser("Instagram", "Watch your friends flexing on you today!"));
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
                    navigate();
                } catch (Exception ex) {
                    Logger.getLogger(BrowserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case 6:
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
            backStack.push(newBrowser);
            currentBrowser = newBrowser;
            System.out.println("Added a new page: " + currentBrowser);
            String choice = library.getString("Continue (y/n)?: ");
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void goBack() {
        try {
            forwardStack.push(currentBrowser);
            currentBrowser = backStack.pop();
            System.out.println("Went back to: " + currentBrowser);
        } catch (Exception e) {
            System.out.println("Cannot go back. Stack is empty.");
        }
    }

    public void goForward() {
        try {
            backStack.push(currentBrowser);
            currentBrowser = forwardStack.pop();
            System.out.println("Went forward to: " + currentBrowser);
        } catch (Exception e) {
            System.out.println("Cannot go forward. Stack is empty.");
        }
    }

    public void navigate() throws Exception {
        int pageChoice = library.getInt("Enter page index to navigate: ");

        if (pageChoice >= 1 && pageChoice <= backStack.size()) {
            navigateBack(pageChoice);
        } else if (pageChoice >= 1 && pageChoice <= forwardStack.size()) {
            navigateForward(pageChoice);
        } else {
            System.out.println("Invalid page index.");
        }
    }

    private void navigateBack(int steps) throws Exception {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(currentBrowser);
            currentBrowser = backStack.pop();
            steps--;
        }
        System.out.println("Went back to: " + currentBrowser);
    }

    private void navigateForward(int steps) throws Exception {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(currentBrowser);
            currentBrowser = forwardStack.pop();
            steps--;
        }
        System.out.println("Went forward to: " + currentBrowser);
    }

    public Browser getCurrentBrowser() {
        return currentBrowser;
    }

    public void getHistory() {
        System.out.println("Browsing History:");
        System.out.println("Backward History:");
        printStack(backStack);

        System.out.println("Forward History:");
        printStack(forwardStack);
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
