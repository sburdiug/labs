abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String id;
    protected int copies;
    protected int availableCopies;

    public LibraryItem(String title, String author, String id, int copies) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.copies = copies;
        this.availableCopies = copies;
    }


    protected abstract String getItemType();

    public void checkOut() {
        String availabilityMessage = (availableCopies > 0) ?
                getItemType() + " \"" + title + "\" is available (" + availableCopies + " copies left)" :
                getItemType() + " \"" + title + "\" is not available";
        System.out.println(availabilityMessage);
    }

    public void takeIt() {
        if (availableCopies <= 0) {
            System.out.println(title + " is not available (no copies left)");
            return;
        }
        availableCopies--;
        System.out.println(title + " has been taken. Copies left: " + availableCopies);
    }

    public void returnItem() {
        if (availableCopies >= copies) {
            System.out.println(title + " already has all copies returned");
            return;
        }
        availableCopies++;
        System.out.println(title + " has been returned. Copies available: " + availableCopies);
    }

    public void searchItem() {
        System.out.println(getItemType() + " Title: " + title + ", Author: " + author + ", ID: " + id +
                ", Total Copies: " + copies + ", Available Copies: " + availableCopies);
    }
}

// Підклас Book
class Book extends LibraryItem {
    public Book(String title, String author, String id, int copies) {
        super(title, author, id, copies);
    }

    @Override
    protected String getItemType() {
        return "Book";
    }
}

// Підклас Journal
class Journal extends LibraryItem {
    public Journal(String title, String author, String id, int copies) {
        super(title, author, id, copies);
    }

    @Override
    protected String getItemType() {
        return "Journal";
    }
}

// Підклас Audiobook
class Audiobook extends LibraryItem {
    private final double duration;

    public Audiobook(String title, String author, String id, double duration, int copies) {
        super(title, author, id, copies);
        this.duration = duration;
    }

    @Override
    public void searchItem() {
        System.out.println(getItemType() + " Title: " + title + ", Author: " + author + ", ID: " + id +
                ", Duration: " + duration + " hours, Total Copies: " + copies + ", Available Copies: " + availableCopies);
    }

    @Override
    protected String getItemType() {
        return "Audiobook";
    }
}

// Головний клас Main
public class Main {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("book1", "book1_author", "B001", 3);
        LibraryItem journal1 = new Journal("journal1", "journal1_author Authors", "J001", 5);
        LibraryItem audiobook1 = new Audiobook("audiobook1", "audiobook1_author", "A001", 10.5, 2);

        book1.searchItem();
        book1.checkOut();
        book1.takeIt();
        book1.takeIt();
        book1.takeIt();
        book1.takeIt(); // Всі копії закінчились
        book1.returnItem();
        book1.returnItem();
        book1.returnItem();
        book1.returnItem(); // Повернено всі копії


        System.out.println("\n--- Audiobook ---");
        audiobook1.searchItem();
        audiobook1.takeIt();
        audiobook1.takeIt();
        audiobook1.takeIt();
        audiobook1.returnItem();
    }
}
