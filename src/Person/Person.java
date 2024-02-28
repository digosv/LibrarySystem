package Person;

import java.util.ArrayList;
import Book.Book;

public class Person {
    private int id;
    private String name;
    ArrayList<Book> historyOfBooks = new ArrayList<>();
    ArrayList<Book> booksWith = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getHistoryOfBooks() {
        return historyOfBooks;
    }

    public void setHistoryOfBooks(ArrayList<Book> historyOfBooks) {
        this.historyOfBooks = historyOfBooks;
    }

    public ArrayList<Book> getBooksWith() {
        return booksWith;
    }

    public void setBooksWith(ArrayList<Book> booksWith) {
        this.booksWith = booksWith;
    }

    
}
