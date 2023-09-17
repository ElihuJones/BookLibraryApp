import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LibraryTest {
  @Test
  public void testThatAddBookWorks() {
    // Create an instance of Library
    Library library = Library.getInstance();

    // Create a new book for library
    Book book = new Book("Sample Title", "Sample Author", "September 2023,",
         "0123456789", "Non-Fiction", 300, true);

    // Add the new book to the library
    library.addBook(book);

    // Verify the test is what you expect via assertEquals() method
    assertEquals(1, library.getBookCount());
  }

  @Test
  public void testThatGetBookCountIsCorrect() {
    Library library = Library.getInstance();
    assertEquals(0, library.getBookCount());


    Book book1 = new Book("Book1", "Sample Author", "September 2023,",
        "0123456789", "Non-Fiction", 300, true);
    Book book2 = new Book("Book2", "Sample Author", "August 2023,",
        "9876543210", "Fiction", 350, true);

    library.addBook(book1);
    library.addBook(book2);
    assertEquals(2, library.getBookCount());
  }

  @Test
  public void testThatFileIsSaved() {
    // Try-Catch test
    return ;
  }

  public void testThatCorrectFileLoads() {
    // Try-Catch test
    return;
  }
}
