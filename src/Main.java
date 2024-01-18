
import Controller.MainController;
import View.Menu;


public class Main {
    public static void main(String[] args) {
        Menu<String> mainMenu = new MainController(null);
//        Entry point
        new MainController(mainMenu).run();
    }
}
