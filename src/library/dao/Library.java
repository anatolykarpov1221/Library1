package library.dao;

import library.model.Book;

public interface Library {
    boolean addBook(Book book);
    Book removeBook(double isbn);
    Book findBook(double isbn);
    int quantity();
    void printBooks();


}
