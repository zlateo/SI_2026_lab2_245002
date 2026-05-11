import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class SI2026Lab2Test {
    private Library library;

    @BeforeEach
    public void setUpLibrary() {
        library=new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", "Programming"));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        library.addBook(new Book("1984", "George Orwell", "Dystopian"));
    }

    @Test
    void searchBookEveryStatementTest() {
        //test 1: invalid title, line 1, 2, 10
        assertThrows(IllegalArgumentException.class, () -> library.searchBookByTitle(""));

        //test 2: line 1, 3, 4.1, 4.2, 4.3, 5 (true), 6, 7 (false), 9 и 10
        List<Book> result=library.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());

        //test 3: empty list, line 1, 3, 4.1, 4.2, 4.3, 5 (false), 7 (true), 8 и 10
        assertNull(library.searchBookByTitle("Dune"));
    }

    @Test
    void borrowBookEveryBranchTest() {
        //test 1 no valid title
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("", "Tolkien"));

        //test 2 valid title but does not exist
        assertThrows(RuntimeException.class, () -> library.borrowBook("Dune", "Frank Herbert"));

        //test 3 valid title, exists, is not borrowed
        assertDoesNotThrow(() -> library.borrowBook("The Hobbit", "J.R.R. Tolkien"));

        //test 4 valid title, exists, is borrowed
        assertThrows(RuntimeException.class, () -> library.borrowBook("The Hobbit", "J.R.R. Tolkien"));
    }

    @Test
    void borrowBookMultipleConditionTest() {
        //TX: title empty, author not evaluated
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("", "J.R.R. Tolkien"));

        //FT: title given, author empty
        assertThrows(IllegalArgumentException.class, () -> library.borrowBook("1984", ""));

        //FF: title given, author given
        assertDoesNotThrow(() -> library.borrowBook("Clean Code", "Robert C. Martin"));
    }

    @Test
    void searchBookMultipleConditionTest () {
        //TT: title matches, not borrowed
        List <Book> result=library.searchBookByTitle("1984");
        assertNotNull(result);

        //TF: title matches, is borrowed
        library.borrowBook("The Hobbit", "J.R.R. Tolkien");
        assertNull(library.searchBookByTitle("The Hobbit"));

        //FX: title doesn't exist
        assertNull(library.searchBookByTitle("Dune"));
    }
}