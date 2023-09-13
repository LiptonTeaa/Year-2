public class Book {
    private String title;
    private String author;
    private long isbn;
    private int pages;
    private int copiesInCollection;
    private int copiesOnLoan;

    //1, complete this class with a constructor that has arguments for all the properties
    //and, getters and setters for each of them

    // Constructor for class
    public Book (String title, String author, long isbn, int pages, int copiesInCollection, int copiesOnLoan)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.copiesInCollection = copiesInCollection;
        this.copiesOnLoan = copiesOnLoan;
    }

    // Getters and Setters

    // Title ----
    public String getTitle () // Getter
    {
        return title;
    }

    public void setTitle (String newTitle) // Setter
    {
        this.title = newTitle;
    }

    // Author ----
    public String getAuthor () // Getter
    {
        return author;
    }

    public void setAuthor (String newAuthor) // Setter
    {
        this.author = newAuthor;
    }

    // ISBN ----
    public long getIsbn () // Getter
    {
        return isbn;
    }

    public void setIsbn (long newIsbn) // Setter
    {
        this.isbn = newIsbn;
    }

    // pages ----
    public int getPages () // Getter
    {
        return pages;
    }

    public void setPages (int newPages) // Setter
    {
        this.pages = newPages;
    }

    // CopiesInCollection ----
    public int getCopiesInCollection () // Getter
    {
        return copiesInCollection;
    }

    public void setCopiesInCollection (int newCopiesInCollection) // Setter
    {
        this.copiesInCollection = newCopiesInCollection;
    }

    // CopiesOnLoan ----
    public int getCopiesOnLoan () // Getter
    {
        return copiesOnLoan;
    }

    public void setCopiesOnLoan (int newCopiesOnLoan) // Setter
    {
        this.copiesOnLoan = newCopiesOnLoan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", copiesInCollection=" + copiesInCollection +
                ", copiesOnLoan=" + copiesOnLoan +
                '}';
    }
}
