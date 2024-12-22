class Book extends LibraryItem {
    public Book(String title, String author, String id, int copies) {
        super(title, author, id, copies);
    }

    @Override
    protected String getItemType() {
        return "Book";
    }
}
