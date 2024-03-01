package Library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Book.Book;
import Person.Person;

public class Library {
    
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> booksAvailable = new ArrayList<>();
    ArrayList<Book> booksFinded = new ArrayList<>();
    ArrayList<Person> users = new ArrayList<>();
    private final String FILENAME = "books.csv";
    private final String FILENAMEUSER = "users.csv";
    boolean bookFound = false;
    Scanner sc = new Scanner(System.in);

   /*  public void test(){ // Teste para adicionar e colocar Livros
        addBook();
        addBook();
        showBooks();
        removeBook();
        removeBook();
        showBooks();
    } teste passou */
    
   /*  public void test(){ // Teste para salvar os dados no banco
        loadBooksFromCSV();
        showBooks();
        addBook();
        saveBooksToCSV();
    } */

    public void test(){
        loadBooksFromCSV();
        loadUsersToCSV();
        addUser();
        saveUsersToCSV();
    }

    public void addBook(){
        try{
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Pages: ");
            int pages = sc.nextInt();
            System.out.print("Year of Publication: ");
            int yOp = sc.nextInt();
            Book b = new Book(name, author, pages, yOp);
            books.add(b);
            booksAvailable.add(b);
            saveBooksToCSV();
        }catch (InputMismatchException e){
            System.out.println("Error: something that you write is wrong");
            sc.next();
        }
    }

    public void removeBook(){
        System.out.print("Write the name of the book: ");
        String name = sc.next();
        for(int i = 0; i < books.size(); i++){
            Book b = books.get(i);
            if(b.getName().toLowerCase().contains(name.toLowerCase())){
                books.remove(b);
                booksAvailable.remove(b);
                System.out.println("Book removed with success");
                bookFound = true;
                saveBooksToCSV();
            }
        }
        if(!bookFound){
            System.out.println("The System cannot find the book");
        }
    }

    public void showBooks(){
        System.out.println("Books at the System: ");
        for(int i = 0; i < books.size(); i ++){
            System.out.println("Name: " + books.get(i).getName() + ", Author: " + books.get(i).getAuthor() + ", Pages: " + books.get(i).getPages() + " ,Year of Publication: " + books.get(i).getyOp());
        }
    }

    public void showBooksAvailables(){
        System.out.println("Available Books: ");
        for(int i = 0; i < booksAvailable.size(); i ++){
            System.out.println("Name: " + booksAvailable.get(i).getName() + ", Author: " + booksAvailable.get(i).getAuthor() + ", Pages: " + booksAvailable.get(i).getPages() + " ,Year of Publication: " + booksAvailable.get(i).getyOp());
        }
    }

    private void saveBooksToCSV(){
        try{
            FileWriter fw = new FileWriter(FILENAME);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for(Book book: books){
                pw.println(book.getName() + "," + book.getAuthor() + "," + book.getPages() + "," + book.getyOp());
            }

            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadBooksFromCSV(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length >= 4){
                    String name = data[0];
                    String author = data[1];
                    int pages = Integer.parseInt(data[2]);
                    int yOp = Integer.parseInt(data[3]);
                    Book b = new Book(name, author, pages, yOp);
                    books.add(b);
                    booksAvailable.add(b);
                }else {
                    System.out.println("Error, the csv file doesn't have enough datas");
                }
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addUser() {
        try{
            System.out.println("Name: ");
            String name = sc.next();
            Person p = new Person(name, users.size()+1);
            p.setId(users.size()+1);
            users.add(p);
        }catch(Exception e){

        }
    }

    private void saveUsersToCSV(){
        try {
            FileWriter fw = new FileWriter(FILENAMEUSER);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for(Person p: users){
                pw.println(p.getName() + "," + p.getId());
            }

            pw.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private void loadUsersToCSV(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAMEUSER));
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length >= 2){
                    String name = data[0];
                    int id = Integer.parseInt(data[1]);
                    Person p = new Person(name, id);
                    users.add(p);
                }else{
                    System.out.println("Error, the csv file doesn't have enough datas");
                }

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
