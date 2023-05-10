package printMethods;

import java.util.Scanner;

public class ForPrint {
    public static String inputString(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextLine();
    }

    public static int inputInt(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextInt();
    }
}
