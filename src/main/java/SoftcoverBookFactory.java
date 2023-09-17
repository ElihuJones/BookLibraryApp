public class SoftcoverBookFactory implements BookFactoryInterface {
  @Override
  public Book createBook(String title, String author, String publishedDate, String ISBN,
      String genre, int pageCount, boolean isRead) {
    return new SoftcoverBook(title, author, publishedDate, ISBN, genre, pageCount, isRead);
  }
}


