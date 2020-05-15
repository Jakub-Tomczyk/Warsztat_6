package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }


    @GetMapping("")
    public List<Book> getAllBooks() {
        return memoryBookService.getList();
    }

//    @GetMapping("")
//    public Book viewsBooks(@RequestBody Book book) {
//        return null;
//    }

    @GetMapping("{id}")
    public Book showBook(@PathVariable long id) {
        return memoryBookService.getBook(id);
    }

    @PostMapping("{id}")
    public String addBook(@RequestBody Book book) {
        memoryBookService.addBook(book);
        return"added";
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable long id) {
        memoryBookService.deleteBook(id);
        return "deleted";
    }

    @PutMapping("{id}")
    public String updateBook(@RequestBody Book book, @PathVariable long id){
        book.setId(id);
        memoryBookService.updateBook(book);
        return "updated";
    }
}
