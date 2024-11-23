import java.util.ArrayList;
import java.util.List;

public class Book {
    public String id;
    private String title;
    public boolean isIssued;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("B1", "Java programming");
        library.addBook("B2", "Python programming");
        library.addBook("B3", "Data Structure programming");
        library.userRegistation("U1");
        library.userRegistation("U2");
        library.bookIssue("B1", "U1");
        library.bookIssue("B4", "V1");
        library.bookIssue("B2", "U3");
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    List<String> users = new ArrayList<>();

    public void addBook(String id, String title) {
        for (Book book : books) {
            if (book.id.equals(id)) {
                System.out.println("Book with this ID is already registered: " + id);
                return; // Exit if book already exists
            }
        }
        books.add(new Book(id, title));
        System.out.println("Book added: " + title);
    }

    public void userRegistation(String userId) {
        if (users.contains(userId)) {
            System.out.println("User Already Registered: " + userId);
        } else {
            users.add(userId);
            System.out.println("User Registered: " + userId);
        }
    }

    public void bookIssue(String bookId, String userId) {
   
        if (!users.contains(userId)) {
            System.out.println("User Not Registered: " + userId);
            return;
        }

       
        boolean bookFound = false;
        for (Book book : books) {
            if (book.id.equals(bookId)) {
                bookFound = true;
                if (book.isIssued) {
                    System.out.println("Book Already Issued: " + bookId);
                } else {
                    book.isIssued = true;
                    System.out.println("Book Issued: " + bookId + " to User " + userId);
                }
                break; 
            }
        }

        if (!bookFound) {
            System.out.println("Book Not Found: " + bookId);
        }
    }
}
