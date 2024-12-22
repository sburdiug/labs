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
