import javax.swing.JFrame;

public class BookLibraryApp {

  public static void main(String[] args) {
    Library library = Library.getInstance();

    JFrame frame = new JFrame("Junior's Library App");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 500);
    frame.add(new BookEntryPanel(library));
    frame.setVisible(true);
  }
}
