import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
    private String title;
    private String author;
    private int pages;
    private boolean available;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        setPages(pages);
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be positive, got " + pages);
        }
        this.pages = pages;
    }

    public String describe() {
        return "\"" + title + "\" by " + author + ", " + pages + " pages, "
                + (available ? "available" : "checked out");
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Clean Code", "Robert C. Martin", 464));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 352));
        books.add(new Book("Head First Java", "Kathy Sierra", 720));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exupery", 96));

        for (Book book : books) {
            System.out.println(book.describe());
        }

        int longBooks = 0;
        for (Book book : books) {
            if (book.getPages() > 300) {
                longBooks++;
            }
        }
        System.out.println("Books with more than 300 pages: " + longBooks);

        Map<String, Integer> stock = new HashMap<>();
        stock.put("Clean Code", 3);
        stock.put("The Pragmatic Programmer", 5);
        stock.put("Head First Java", 2);
        stock.put("The Little Prince", 7);

        System.out.println("Copies of Clean Code: " + stock.get("Clean Code"));

        int totalCopies = 0;
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            totalCopies += entry.getValue();
        }
        System.out.println("Total copies: " + totalCopies);

        try {
            books.get(0).setPages(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
