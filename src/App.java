import java.util.Scanner;

import Library.Library;

public class App {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        library.test();
        sc.close();
    }
}
