package Book;

public class Book {
    private String name;
    private String author;
    private int pages;
    private int yOp; // year of publication
    private boolean available = true;

    public Book(String name, String author, int pages, int yOp) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.yOp = yOp;
    }

    public Book(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getyOp() {
        return yOp;
    }

    public void setyOp(int yOp) {
        this.yOp = yOp;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    
}
