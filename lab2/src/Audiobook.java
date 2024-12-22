class Audiobook extends LibraryItem {
    private final double duration;

    public Audiobook(String title, String author, String id, double duration, int copies) {
        super(title, author, id, 0); // У аудіокниг немає копій
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
    @Override
    public void takeIt() {
        System.out.println("Audiobooks cannot be taken physically.");
    }

    @Override
    public void returnItem() {
        System.out.println("Audiobooks do not require returning.");
    }

}
