import exception.BookNotFound;
import exception.SearchBySerialNumber;
import menu.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws BookNotFound, SearchBySerialNumber, IOException {
        Menu.menu();
    }
}
