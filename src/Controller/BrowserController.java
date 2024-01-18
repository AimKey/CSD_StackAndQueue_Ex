package Controller;

import Common.Library;
import Model.Browser;
import Model.Stack;
import View.Menu;

public class BrowserController extends Menu<String> {

    // private Menu<String> parentMenu;
    private static String[] mc = { "Add pages", "Back button", "Forward button", "History", "Return to menu" };
    private Stack<Browser> browserStack;
    private Library library = new Library();

    public BrowserController(Menu<String> parentMenu) {
        super("FPT Browser", mc, parentMenu);
        this.parentMenu = parentMenu;
        browserStack = new Stack<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAddPage();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Returning");
                returnToPMenu();
                break;
        }
    }

    public void doAddPage() {
        // do {
        // String title = library.getString("Enter page name");
        // String desc = library.getString("Enter page name");
        // browserStack.push(new Browser(title, desc));
        // } while (library.getString("Continue (y/n)?: ").equals("n"));
        browserStack.push(new Browser("Facebook", "Is IT dead??"));
        browserStack.push(new Browser("X", "Come and get me <33"));
        browserStack.push(new Browser("Reddit", "Hey guys, do you know that in terms of..."));
        browserStack.push(new Browser("Instagram", "Watch your friends flexing on you today!"));
    }

}
