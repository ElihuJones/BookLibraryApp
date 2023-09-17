public interface BookFactoryInterface {
  Book createBook(String title, String author, String publishedDate, String ISBN,
      String genre, int pageCount, boolean isRead);
}
