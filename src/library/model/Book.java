package library.model;

public class Book {
    protected  double isbn;
    protected String author;
    protected String booktitle;
    protected int ypublishing;

    public Book(double isbn, String author, String booktitle, int ypublishing) {
        this.isbn = isbn;
        this.author = author;
        this.booktitle = booktitle;
        this.ypublishing = ypublishing;
    }


    public double getIsbn() {
        return isbn;
    }

    public void setIsbn(double isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getYpublishing() {
        return ypublishing;
    }

    public void setYpublishing(int ypublishing) {
        this.ypublishing = ypublishing;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Book book = (Book) object;

        return Double.compare(isbn, book.isbn) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(isbn);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author='" + author + '\'' +
                ", booktitle='" + booktitle + '\'' +
                ", ypublishing=" + ypublishing +
                '}';
    }
}
