package Controller;

import View.Menu;

public class PrintController extends Menu<String> {

    private Menu parentMenu;

//    Enqueue, Dequeue, display queue, View current print item
    private static String[] mc = {"Add item", "Print item", "Display queue", "View current item", "Exit"};

    public PrintController(Menu parentMenu) {
        super("Print queue", mc, parentMenu);
        this.parentMenu = parentMenu;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                returnToPMenu();
                break;
        }
    }

}
