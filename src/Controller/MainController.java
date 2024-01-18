package Controller;

import View.Menu;

public class MainController extends Menu<String> {

    protected static Menu<String> parentMenu;
    private static String[] mc = {"Browser", "Printer", "Exit"};

    public MainController(Menu<String> parentMenu) {
        super("Main program", mc, parentMenu);
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                new BrowserController(parentMenu).run();
                break;
            case 2:
                new PrintController(parentMenu).run();
                break;
            case 3:
                System.exit(0);

        }
    }

}
