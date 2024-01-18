package Common;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner((System.in));
    public int getInt(String td) {
        System.out.print(td + ": ");
        return Integer.parseInt(sc.nextLine());
    }

    public int getInt(String td, String errorMsg) {
        System.out.print(td + ": ");
        String s = sc.nextLine();
        if (s.isEmpty()) return -1;
        while (!s.matches("[0-9]+")) {
            System.out.println("\u001B[31m" + errorMsg + "\u001B[0m");
            s = getString(td);
        }
        return Integer.parseInt(s);
    }

    public String getString(String td) {
        System.out.print(td + ": ");
        return sc.nextLine();
    }

    public String getString(String td, String errorMsg) {
        System.out.print(td + ": ");
        String s = sc.nextLine();
        if (s.isEmpty()) return "";
        while (!s.matches("[A-Za-z ]+")) {
            System.out.println("\u001B[31m" + errorMsg + "\u001B[0m");
            s = getString(td);
        }
        return s;
    }
    
    public <T> void display (ArrayList<T> arr) {
        for (T t : arr) {
            System.out.println(t);
        }
        System.out.println("Total: " + arr.size());
    }
}
