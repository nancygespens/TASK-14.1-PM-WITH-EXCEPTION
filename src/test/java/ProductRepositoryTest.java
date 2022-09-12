import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test
    public void findById() {
        ProductRepository repo = new ProductRepository();

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        repo.add(book);
        repo.add(product);
        repo.add(smartphone);

        repo.findById(103);

        Product[] actual = repo.findAll();
        Product[] expected = {book, product, smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByNonExistentId() {
        ProductRepository repo = new ProductRepository();

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        repo.add(book);
        repo.add(product);
        repo.add(smartphone);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(943);
        });
    }

    @Test
    public void deleteById() {
        ProductRepository repo = new ProductRepository();

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        repo.add(book);
        repo.add(product);
        repo.add(smartphone);

        repo.removeById(583);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(583);
        });
    }

    @Test
    public void deleteByIdNonExistentId() {
        ProductRepository repo = new ProductRepository();

        Product book = new Book(103, "Harry Potter Collection", 200, "Joan Roaling");
        Product product = new Product(320, "TShirt Collection", 300);
        Product smartphone = new Smartphone(583, "Iphone", 50_000, "Apple");

        repo.add(book);
        repo.add(product);
        repo.add(smartphone);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(323);
        });
    }

}
