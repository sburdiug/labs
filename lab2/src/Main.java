public class Main {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("book1", "book1_author", "B001", 3);
        LibraryItem journal1 = new Journal("journal1", "journal1_author Authors", "J001");
        LibraryItem audiobook1 = new Audiobook("audiobook1", "audiobook1_author", "A001", 10.5, 2);

        book1.searchItem();
        book1.checkOut();
        book1.takeIt();
        book1.takeIt();
        book1.takeIt();
        book1.takeIt(); // Всі копії закінчились
        book1.searchItem();
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
        System.out.println("\n--- Journal ---");
        journal1.searchItem();
        journal1.takeIt();
        journal1.returnItem();

    }
}
