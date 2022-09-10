public class Book extends Product  {
    protected String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

//    public void setAuthor(String author) {
//        this.author = author;
//    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        } else {
            return getAuthor().contains(search);
        }
    }
}
