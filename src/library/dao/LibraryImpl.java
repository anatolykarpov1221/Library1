package library.dao;

import library.model.Book;

public class LibraryImpl implements Library{
    private  Book[] books; // массив для books
    private int size; //текущее кол во books

    public LibraryImpl(int capasity) {
        books = new Book[capasity];///максим размер
    }

    @Override
    public boolean addBook(Book book) {
        if(book == null||size==books.length||findBook(book.getIsbn())!=null){
            return false;
        }
        books[size] = book;
        size++;
        return true;

    }

    @Override
    public Book removeBook(double isbn) {
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn()==isbn){
                Book temp = books[i];
                books[i] = books [size-1];
                books[size-1] = null;
                size--;
                return temp;
            }

        }
        return null;
    }

    @Override
    public Book findBook(double isbn) {
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn()==isbn){
                return books[i];
            }

        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public void printBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);

        }

    }
}
