import java.io.Serializable;

/**
This Book class is show the fundamental metrics that I want each book to display.
 May add additional instance variables to the fold such as Edition, etc.

 Reading Clean Code had given such a great insight to how I need to move forward.
 Looking forward to the future.

 Implements the Serializable Interface
 */
public class Book implements Serializable {
  private String title;
  private String authorName;
  private String publishedDate;
  private String ISBN;
  private String genre;
  private int pageCount;
  private boolean isRead;

  //Constructor created to initialize the book attributes
  public Book(String title, String authorName, String publishedDate, String ISBN,
      String genre, int pageCount, boolean isRead) {
    this.title = title;
    this.authorName = authorName;
    this.publishedDate = publishedDate;
    this.ISBN = ISBN;
    this.genre = genre;
    this.pageCount = pageCount;
    this.isRead = isRead;
  }

  //Created toString() method which provides a string representation of the book
  @Override
  public String toString() {
    return "\n Title = " + title +
        "\n Author(s) = " + authorName +
        "\n Date Published = " + publishedDate +
        "\n ISBN = " + ISBN +
        "\n Genre = " + genre +
        "\n Page Count = " + pageCount +
        "\n Read = " + (isRead ? "Yes" : "No") +
        "\n";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(String publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean read) {
    isRead = read;
  }
}