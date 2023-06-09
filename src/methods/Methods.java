package methods;

import exception.BookNotFound;
import exception.SearchBySerialNumber;
import menu.Menu;
import object.Book;
import printMethods.ForPrint;

import java.io.*;

import static datas.BookStocks.book;
import static datas.BookStocks.iterator;

public class Methods {
    public static String callMethod() throws BookNotFound, SearchBySerialNumber, IOException {

        String[] title1 = {"1984", "MOCKBIRD", "BIGQETSBI", "QURURVEQEREZ"};
        String[] author1 = {"Corc Oruellin", "Harper Li", "F. Scott Fitzgerald", "Jane Austenin"};
        int[] serialNumber1 = {10169, 10168, 10167, 10166};
        int[] price1 = {65, 54, 32, 41};
        int[] stockQuantity = {10, 12, 20, 7};
        book.add(new Book(title1[0], author1[0], serialNumber1[0], price1[0], stockQuantity[0]));
        book.add(new Book(title1[1], author1[1], serialNumber1[1], price1[1], stockQuantity[1]));
        book.add(new Book(title1[2], author1[2], serialNumber1[2], price1[2], stockQuantity[2]));
        book.add(new Book(title1[3], author1[3], serialNumber1[3], price1[3], stockQuantity[3]));

        boolean found = false;
        while (iterator.hasNext()) {
            Book information = iterator.next();
            String input = ForPrint.inputString("\n" + "Kitabinizin adini daxil edin : ");
            String callBook = input.trim().toUpperCase();
            if (information.getTitle().equals(callBook)) {
                System.out.println(information);
                found = true;
                return Menu.menu();
            }
            if (!found) {
                throw new BookNotFound("Bu adda kitab tapilmamisdir");
            }
        }
        return Menu.menu();
    }

    public static String addMethods() throws SearchBySerialNumber, BookNotFound, IOException {
        File file = new File("EMIL FILE");
        String input = ForPrint.inputString("Kitabiniz adini elave edin : ");
        String title = input.trim().toUpperCase();
        String input1 = ForPrint.inputString("Yazarin adini elave edin : ");
        String author = input1.trim().toUpperCase();
        int serialNumber = ForPrint.inputInt("Kitanim seriya nomresini daxil edin");
        int price = ForPrint.inputInt("Qiymetini daxil edin : ");
        int quantity = ForPrint.inputInt("Stoka elave edeceyiniz miqdar : ");
        Book book1 = new Book(title, author, serialNumber, price, quantity);
        book.add(book1);
        System.out.println("Kitabiniz elave edildi " + "\n" + "Kitab melumatlari : " + book);
        try {
            FileOutputStream file1 = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(file1);
            out.writeObject(book);
            out.close();
            file1.close();
            System.out.println(book1.toString() +  "File yazildi.");
        }catch (IOException e ){
            e.printStackTrace();
        }
        return Menu.menu();
    }

    public static String updateMethods() throws SearchBySerialNumber, BookNotFound, IOException {

        int search = ForPrint.inputInt("Kitabin seriya nomresini elave edin : ");
        boolean found = false;
        while (iterator.hasNext()) {
            Book information = iterator.next();
            System.out.println(information.getClass().getName());
            if (information.equals(search)) {
                System.out.println();
                int choose = ForPrint.inputInt(
                        "1 - Ad deyisikliyi ucun " + "\n" +
                                "2 - Yazar adi deyismek ucun : " + "\n" +
                                "3 - Seriya nomresini deyismek ucun : " + "\n" +
                                "4 - Qiymeti deyismek ucun : " + "\n" +
                                "5 - Stoktaki miqdari duzeltmek ucun : " + "\n"
                );
                switch (choose) {
                    case 1:
                        String title = ForPrint.inputString("Kitabin yenio adini daxil edin : ");
                        information.setTitle(title);
                        information.getInfo();
                        break;
                    case 2:
                        String author = ForPrint.inputString("Yazarin yeni adini daxil edin ");
                        information.setAuthor(author);
                        information.getInfo();
                        break;
                    case 3:
                        int serianlNumber = ForPrint.inputInt("Yeni seriya nomersini daxil edin : ");
                        information.setSeriaNumber(serianlNumber);
                        information.getInfo();
                        break;
                    case 4:
                        int price = ForPrint.inputInt("Yeni qiymetini daxil edin : ");
                        information.setPrice(price);
                        information.getInfo();
                        break;
                    case 5:
                        int stock = ForPrint.inputInt("Yeni stok miqdari : ");
                        information.setQuantity(stock);
                        information.getInfo();
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;
                }
                found = true;
            }
            if (!found) {
                throw new SearchBySerialNumber("Bu seriya nomreli kitab tapilmamistir");
            }
        }
        return Menu.menu();
    }
}
