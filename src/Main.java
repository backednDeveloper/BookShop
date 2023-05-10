import exception.BookNotFound;
import exception.SearchBySerialNumber;
import menu.Menu;

public class Main {
    public static void main(String[] args) throws BookNotFound, SearchBySerialNumber {
        Menu.menu();
    }
}
