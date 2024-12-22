class Book extends LibraryItem {
    public Book(String title, String author, String id, int copies) {
        super(title, author, id, copies);
    }

    @Override
    protected String getItemType() {
        return "Book";
    }
    @Override
    public void searchItem() {
        int UnavalibleCopies = copies - availableCopies ;
        System.out.println(getItemType() + " Title: " + title + ", Author: " + author + ", ID: " + id +
                ", Total Copies: " + copies + ", Available Copies: " + availableCopies + ", Unavailable Copies: "+ UnavalibleCopies );
    }
}
