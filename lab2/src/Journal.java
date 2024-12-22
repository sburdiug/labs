class Journal extends LibraryItem {
    public Journal(String title, String author, String id, int copies) {
        super(title, author, id, copies);
    }

    @Override
    protected String getItemType() {
        return "Journal";
    }
}
