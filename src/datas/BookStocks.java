package datas;

import exception.BookNotFound;
import exception.SearchBySerialNumber;
import methods.Methods;
import object.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStocks {

    public static List<Book> book = new ArrayList<>();

    public static String stock() throws SearchBySerialNumber, BookNotFound {
        String[] title = {"1984", "MOCKBIRD", "BIGQETSBI", "QURURVEQEREZ"};
        String[] author = {"Corc Oruellin", "Harper Li", "F. Scott Fitzgerald", "Jane Austenin"};
        int[] serialNumber = {10169, 10168, 10167, 10166};
        int[] price = {65, 54, 32, 41};
        int[] stockQuantity = {10, 12, 20, 7};
        Book book1 = new Book(title[0], author[0], serialNumber[0], price[0], stockQuantity[0]);
        Book book2 = new Book(title[1], author[1], serialNumber[1], price[1], stockQuantity[1]);
        Book book3 = new Book(title[2], author[2], serialNumber[2], price[2], stockQuantity[2]);
        Book book4 = new Book(title[3], author[3], serialNumber[3], price[3], stockQuantity[3]);
        book.add(book1);
        book.add(book2);
        book.add(book3);
        book.add(book4);
        return Methods.addMethods();
    }
}
