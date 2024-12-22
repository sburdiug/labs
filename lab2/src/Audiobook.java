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
