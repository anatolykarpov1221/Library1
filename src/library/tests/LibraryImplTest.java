package library.tests;

import library.dao.Library;
import library.dao.LibraryImpl;
import library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

;

class LibraryImplTest {
    Library library;
    Book[] b;
    @BeforeEach
    void setUp() {
        library = new LibraryImpl(5);
        b = new Book[4];
        b[0] = new Book(100011,"Bulgakow M.","White Guard",1930);
        b[1] = new Book(100012,"L.Tolostoy", "Anna Karenina", 1886);
        b[2] = new Book(100013,"O.Genry", "Green Lamp", 1928);
        b[3] = new Book(100014, "S.Dovlatov", "Our", 2016);
        for (int i = 0; i < b.length; i++) {
            library.addBook(b[i]);
        }
    }


    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        //второй раз не можем добавить
        assertFalse(library.addBook(b[1]));
        Book book1  =  new Book (100015,"George Orwel ","1984",1974);
        assertTrue(library.addBook(book1));//добавили
        assertEquals(5,library.quantity());
        Book book3 = new Book(100016,"Kuprin","Lolita",1916);
        assertFalse(library.addBook(book3)); // не можем превысить capacity
    }


    @Test
    void removeBook() {
        assertEquals( b[1],library.removeBook(100012));
        assertEquals(3,library.quantity());// books стало на один меньше
        assertNull(library.removeBook(100012)); // дважды нельзя удалить
        assertNull(library.findBook(100012));// не можем найти
    }

    @Test
    void findBook() {
        assertEquals( b[1],library.findBook(100012));
        assertNull(library.findBook(100016)); //не найден за границей arr
    }

    @Test
    void quantity() {
        assertEquals(4,library.quantity());
    }

    @Test
    void printBooks() {
        library.printBooks();
    }
}