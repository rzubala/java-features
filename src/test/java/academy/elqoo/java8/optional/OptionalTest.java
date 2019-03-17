package academy.elqoo.java8.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void shouldCreateEmptyOptional(){
        //Optional<String> optional = null; // create empty optional
        Optional<String> optional = Optional.ofNullable(null);
        assertThat(optional.isPresent(),equalTo(false));
    }

    @Test
    public void shouldReturnBookName(){
        Optional<Book> book = Optional8.getBook();
        //String bookName = null; // book. ....
        String bookName = book.get().getName();
        assertThat(bookName,equalTo("Experience Java 8"));
    }

    @Test
    public void shouldReturnBookAuthor(){
        Optional<Book> book = Optional8.getBookWithAuthor();
        //String authorName = null; // book. ....
        String authorName = book.get().getAuthor().get();
        assertThat(authorName,equalTo("Stijn De Mulder"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoElementException(){
        Optional<Book> book = Optional8.getBook();
        //book.get().getAuthor();
        book.get().getAuthor().get();
    }

    @Test(expected = MyCustomException.class)
    public void shouldThrowOptionalEmptyException() throws MyCustomException{
        Optional<Book> book = Optional8.getBook();
        //book.get().getAuthor(); // getAuthor.or.....
        book.get().getAuthor().orElseThrow(() -> new MyCustomException());
    }
}
