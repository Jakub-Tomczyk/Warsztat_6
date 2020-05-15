package pl.coderslab.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemoryBookService {
    private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel","Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

    public Book getBookById(long id) {
    return getList().stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public List<Book> updateBook(Book book) {
        Book bookById = getBookById(book.getId());
        list.remove(bookById);
        list.add(book);
        return list;
    }
     public Book addBook(Book book){
        book.setId(Book.count);
        list.add(book);
        return book;
     }

    public void deleteBook(long id) {
        Book bookById = getBook(id);
        list.remove(bookById);
    }

    public Book getBook(Long id) {
        return this.list.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
}
