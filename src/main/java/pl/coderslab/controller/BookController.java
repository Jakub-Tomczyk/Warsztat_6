package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
//    private BookService bookService;
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        return bookList;
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return null;
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return null;
    }
    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id){
        return null;
    }
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable int id){
        return null;
    }
}
