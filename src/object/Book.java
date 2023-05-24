package object;



import java.io.Serializable;

public class Book implements Serializable {
    private String title, author;
    private int seriaNumber, price, quantity;

    public Book(String title, String author, int seriaNumber, int price, int quantity) {
        this.title = title;
        this.author = author;
        this.seriaNumber = seriaNumber;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSeriaNumber() {
        return seriaNumber;
    }

    public void setSeriaNumber(int seriaNumber) {
        this.seriaNumber = seriaNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Kitab = (" +
                "Adı :'" + title + '\'' +
                ", Yazarı :'" + author + '\'' +
                ", Seriya nomresi :" + seriaNumber +
                ", Qiymeti :" + price +
                ", Stok miqdari :" + quantity +
                ')';
    }

    public void getInfo() {
        toString();
    }
}
