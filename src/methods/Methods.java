package methods;


import datas.BookStocks;
import exception.BookNotFound;
import exception.SearchBySerialNumber;
import menu.Menu;
import object.Book;
import printMethods.ForPrint;

public class Methods {
    public static void callMethod() throws BookNotFound, SearchBySerialNumber {
        for (Book information : BookStocks.book) {
            boolean found = false;
            information.getInfo();
            String input = ForPrint.inputString("Kitabinizin adini daxil edin : ");
            String callBook = input.trim().toUpperCase();
            if (information.getTitle().contains(callBook)) {
                information.getInfo();
                found = true;
            }
            if (!found) {
                throw new BookNotFound("Bu adda kitab tapilmamisdir");
            }
        }
        Menu.menu();
    }

    public static String addMethods() throws SearchBySerialNumber, BookNotFound {
        String input = ForPrint.inputString("Kitabiniz adini elave edin : ");
        String title = input.trim().toUpperCase();
        String input1 = ForPrint.inputString("Yazarin adini elave edin : ");
        String author = input1.trim().toUpperCase();
        int serialNumber = ForPrint.inputInt("Kitanim seriya nomresini daxil edin");
        int price = ForPrint.inputInt("Qiymetini daxil edin : ");
        int quantity = ForPrint.inputInt("Stoka elave edeceyiniz miqdar : ");
        Book book = new Book(title, author, serialNumber, price, quantity);
        BookStocks.book.add(book);
        //System.out.println("Kitabiniz elave edildi " + "\n" + "Kitab melumatlari " + "\n" + book.getInfo());
        return Menu.menu();
    }

    public static void updateMethods() throws SearchBySerialNumber, BookNotFound {
        int search = ForPrint.inputInt("Kitabin seriya nomresini elave edin : ");
        boolean found = false;
        for (Book information : BookStocks.book) {
            if (information.getSeriaNumber() == search) {
                information.getInfo();
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

        Menu.menu();
    }
}
