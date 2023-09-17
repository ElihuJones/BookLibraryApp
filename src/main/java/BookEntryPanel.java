import static java.util.Locale.filter;

import java.awt.GridLayout;
import java.io.File;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the GUI for Book Library App. While running the user input fields are displayed
 * and several options are given to continue on.
 *
 * Ultimately I want to embed the ability to sort the Master List by Genre, Book Edition, etc. * *
 */

public class BookEntryPanel extends JPanel {
  private JTextField titleField, authorField, publishedDateField, ISBNField, genreField, pageCountField;
  private JComboBox<String> bookTypeComboBox;
  private JCheckBox readCheckBox;
  JButton addButton;
  JButton showMasterListButton;
  JButton saveButton;
  JButton loadButton;
  JButton deleteButton;
  private Library library;

  //Constructor that builds JPanel
  public BookEntryPanel(Library library) {
    this.library = library;
    setLayout(new GridLayout(11, 2));
    titleField = new JTextField();
    authorField = new JTextField();
    publishedDateField = new JTextField();
    ISBNField =new JTextField();
    pageCountField = new JTextField();
    genreField = new JTextField();
    readCheckBox = new JCheckBox("Read");

    //ComboBox that selects book type
    bookTypeComboBox = new JComboBox<>(new String[]{"Hardcover", "Softcover", "Comic"});

    addButton = new JButton("Add Book");
    addButton.addActionListener(e -> addBook());

    deleteButton = new JButton("Delete Book");
    deleteButton.addActionListener(e -> deleteBook());

    showMasterListButton = new JButton("Show Master List");
    showMasterListButton.addActionListener(e -> showMasterBookList());

    saveButton = new JButton("Save To File");
    saveButton.addActionListener(e -> saveToFile());

    loadButton = new JButton("Load From File");
    loadButton.addActionListener(e -> loadFromFile());

    add(new JLabel("Title: "));
    add(titleField);
    add(new JLabel("Author: "));
    add(authorField);
    add(new JLabel("Published Date: "));
    add(publishedDateField);
    add(new JLabel("ISBN: "));
    add(ISBNField);
    add(new JLabel("Genre: "));
    add(genreField);
    add(new JLabel("Page Count: "));
    add(pageCountField);
    add(new JLabel("Read: "));
    add(readCheckBox);
    add(new JLabel("Book Type: "));
    add(bookTypeComboBox);
    add(addButton);
    add(showMasterListButton);
    add(saveButton);
    add(loadButton);
    add(deleteButton);
  }

  private void addBook() {
    String title = titleField.getText();
    String author = authorField.getText();
    String publishedDate = publishedDateField.getText();
    String ISBN = ISBNField.getText();
    String genre = genreField.getText();
    int pageCount = Integer.parseInt(pageCountField.getText());
    boolean isRead = readCheckBox.isSelected();

    String selectedBookType = (String) bookTypeComboBox.getSelectedItem();
    BookFactoryInterface bookFactory;

    switch (selectedBookType) {
      case "Softcover":
          bookFactory = new SoftcoverBookFactory();
          break;

      case "Comic":
          bookFactory = new ComicBookFactory();
          break;

      default:
          bookFactory = new HardcoverBookFactory();
          break;
    }

    // Creates a new book using the Factory
    Book newBook = bookFactory.createBook(title, author, publishedDate, ISBN, genre, pageCount, isRead);

    library.addBook(newBook);

    JOptionPane.showMessageDialog(this, "New Book Added To The Library");

    clearFields();
  }

  private void showMasterBookList() {
    List<Book> allBooks = library.getAllBooks();
    StringBuilder bookList = new StringBuilder("Master Book List: \n");
    for (int i = 0; i < allBooks.size(); i++) {
        bookList.append("[").append(i + 1).append("]").append(allBooks.get(i)).append("\n");
    }
    JOptionPane.showMessageDialog(this, bookList.toString());
  }

  private void saveToFile() {
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showSaveDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          library.saveToFile(selectedFile.getAbsolutePath());
    }
  }

  private void loadFromFile() {
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         library.loadFromFile(selectedFile.getAbsolutePath());
    }
  }

  //Shows dialog for user to select book to delete from library
  private void  deleteBook() {
    List<Book> allBooks = library.getAllBooks();
    String[] bookTitles = allBooks.stream().map(Book::getTitle).toArray(String[]::new);

    if (bookTitles.length == 0) {
      JOptionPane.showMessageDialog(this, "No Books In The Library To Delete.");
      return;
    }

    String selectedTitle = (String) JOptionPane.showInputDialog(
        this,
        "Select A Book To Delete: ",
        "Delete Book",
        JOptionPane.PLAIN_MESSAGE,
        null ,
        bookTitles,
        bookTitles[0]
    );

    if (selectedTitle != null) {
        Book selectedBook = allBooks.stream()
          .filter(book -> book.getTitle().equals(selectedTitle))
          .findFirst()
          .orElse(null);

          if (selectedBook != null) {
            library.deleteBook(selectedBook);
            JOptionPane.showMessageDialog(this, "Book Deleted From The Library");
          }else {
            JOptionPane.showMessageDialog(this, "Book Not Found In The Library");
          }
    }
  }

  private void clearFields() {
      titleField.setText("");
      authorField.setText("");
      publishedDateField.setText("");
      ISBNField.setText("");
      genreField.setText("");
      pageCountField.setText("");
      readCheckBox.setSelected(false);
  }
}
