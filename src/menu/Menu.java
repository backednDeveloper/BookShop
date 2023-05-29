package menu;

import exception.BookNotFound;
import exception.SearchBySerialNumber;
import methods.Methods;
import printMethods.ForPrint;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu {
    public static String menu() throws SearchBySerialNumber, BookNotFound, IOException {
        int choose = ForPrint.inputInt(
                "1 - Kitab cagirmaq " + "\n" +
                "2 - Kitab elave etmek " + "\n" +
                "3 - Kitab melumatlari deyismek : " + "\n" +
                "Daxil edin : " + "\n"
        );
        switch (choose) {
            case 1 :
                System.out.println("---------- Kitab Cagirilmasi -----------" + "\n");
                Methods.callMethod();
                break;
            case 2:
               System.out.println(" ------- Kitab Elave Edilmesi ------- " + "\n");
                Methods.addMethods();
                break;
            case 3:
                System.out.println(" ------ Kitab Melumati Deyisdilirmesi ------ " + "\n");
                Methods.updateMethods();
                break;
            default:
                System.out.println("Something went wrong." );
                break;
        }
        return Menu.menu();
    }
}
