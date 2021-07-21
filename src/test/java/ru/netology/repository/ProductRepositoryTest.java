package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();

  private Product first = new Book(1, "One", 100, "Author1", 2019);
  private Product second = new Book(2, "Second", 200, "Author2", 2018);
  private Product third = new Book(3, "Third", 300, "Author3", 2021);

  @BeforeEach
  void setUp() {
    repository.save(first);
    repository.save(second);
    repository.save(third);
  }

  @Test
  void removeById() {
    repository.removeById(3);
    Product[] actual = repository.findAll();
    Product[] expected = new Product[]{first,second};
    assertArrayEquals(expected, actual);
  }


  @Test
  void shouldRemoveByIdNotExist() {
    assertThrows(NotFoundException.class, () -> repository.removeById(5));
  }
}



