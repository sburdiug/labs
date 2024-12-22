class Journal extends LibraryItem {
    public Journal(String title, String author, String id) {
        super(title, author, id, 1);
    }

    @Override
    protected String getItemType() {
        return "Journal";
    }
    @Override
    public void searchItem() {
        System.out.println(getItemType() + " Title: " + title + ", Author: " + author + ", ID: " + id +
                ", Journal is available");
    }

    @Override
    public void returnItem() {
        if (availableCopies >= copies) {
            System.out.println(title + " already has all copies returned");
            return;
        }
        availableCopies++;
        System.out.println(title + " has been returned. Journal is available ");
    }
    @Override
    public void takeIt() {
        if (availableCopies <= 0) {
            System.out.println(title + " is not available");
            return;
        }
        availableCopies--;
        System.out.println(title + " has been taken. Journal is unavailable ");
    }



}
