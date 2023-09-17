public class HardcoverBookFactory implements BookFactoryInterface {

  public Book createBook(String title, String author, String publishedDate, String ISBN,
      String genre, int pageCount, boolean isRead) {
    return new HardcoverBook(title, author, publishedDate, ISBN, genre, pageCount, isRead);
  }
}



