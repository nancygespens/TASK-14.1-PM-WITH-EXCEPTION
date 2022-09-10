import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    @Test
    public void addProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = repo.findAll();
        Product[] expected = {book, product, smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchBook() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {book};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("TShirt");
        Product[] expected = {product};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphone() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTheSameThings() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Collection");
        Product[] expected = {book, product};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNothing() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Krampus");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Joan Roaling");
        Product[] expected = {book};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByVendor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTitle() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        manager.add(book);
        manager.add(product);
        manager.add(smartphone);

        Product[] actual = manager.searchBy("TShirt");
        Product[] expected = {product};

        Assertions.assertArrayEquals(expected, actual);
    }

}
