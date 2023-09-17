import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This Library class creates the book library by adding all the books, maintaining the book count,
 * and choosing to save or load the file of the Master List
 *
 * Something to note here is if I am able to add to my original excel spreadsheet.
 */
public class Library implements Serializable {
  private static Library libraryInstance;
  private List<Book> books;

  //Private constructor to enforce Singleton pattern
  private Library() {
    books = new ArrayList<>();
  }

  public static Library getInstance() {
    if (libraryInstance == null) {
      libraryInstance = new Library();
    }
    return libraryInstance;
  }

  //Adds a book to the library
  public void addBook(Book book) {
    books.add(book);
  }

  //Returns all books in the library
  public List<Book> getAllBooks() {
    return books;
  }

  //Returns total book count in library
  public int getBookCount() {
    return books.size();
  }

  //Saves current book list to a file called "savedFile"
  public void saveToFile(String savedLibraryFile) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedLibraryFile))) {
      oos.writeObject(books);
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Loads the book list file
  public void loadFromFile(String savedLibraryFile) {
    try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(savedLibraryFile)))) {
      List<Book> loadedBooks = (List<Book>) ois.readObject();
      books.clear();
      books.addAll(loadedBooks);
    }catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void deleteBook(Book bookToDelete) {
    books.remove(bookToDelete);
  }
}
