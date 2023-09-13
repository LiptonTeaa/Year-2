import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class BookCollection {
    private  ArrayList<Book> books= new ArrayList<Book>();

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path) {

        Scanner in;

        // Adding objects Book to array list book

            try {
                in = new Scanner(new File(path));
                in.nextLine();
                while(in.hasNext()){
                    String book = in.nextLine();
                    String[] booksTemp = book.split(","); // The regex returns the line as multiple split up
                    books.add(new Book(booksTemp[0],            // entities where it encounters a coma
                            booksTemp[1],
                            Long.parseLong(booksTemp[2]),
                            Integer.parseInt(booksTemp[3]),
                            Integer.parseInt(booksTemp[4]),
                            Integer.parseInt(booksTemp[5])));
                }
            }catch(Exception e){
                System.out.println(e);
            }
    }

    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors(){

        HashSet<String> temp = new HashSet<>();
        for (Book book : books) {
            temp.add(book.getAuthor());
        }
        return temp;
    }

    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){

        ArrayList<Book> temp= new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getPages() > 750) {
                temp.add(books.get(i));
            }
        }
        return temp;

    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){

        for (int i = 0; i < books.size(); i++) {
            if (Objects.equals(books.get(i).getTitle(), title)) {
                return books.get(i);
            }
        }
        return null;
    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){

        Book[] temp = new Book[10];
        int count = 0;
        // Sorting whole array of books by roll number of copies loaned
        Collections.sort(books, new SortbyLoan());

        // Picking out the top 10 most popular books from our sorted array
        for (int i = 90; i < books.size(); i++)
        {
            temp[count] = books.get(i);
            count++;
        }

        // This would give you the least popular books
//        for (int i = 0; i < 10; i++)
//        {
//            temp[count] = books.get(i);
//            count++;
//        }

        return temp;
    }
}

// Comparator class
class SortbyLoan implements Comparator<Book> {
    // Method in our class that will sort between two objects for us
    // Sorting in ascending order of number of copies Loaned
    public int compare(Book a, Book b)
    {
        //return a.getCopiesOnLoan() - b.getCopiesOnLoan(); // Also works
        return Integer.compare(a.getCopiesOnLoan(), b.getCopiesOnLoan());
    }
}
