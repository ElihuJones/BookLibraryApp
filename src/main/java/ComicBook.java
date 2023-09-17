public class ComicBook extends Book {
  public ComicBook(String title, String author, String publishedDate, String ISBN,
      String genre, int pageCount, boolean isRead) {
    super(title, author, publishedDate, ISBN, genre, pageCount, isRead);
  }

  @Override
  public String toString() {
    return super.toString() + " Type: Comic";
  }

}
