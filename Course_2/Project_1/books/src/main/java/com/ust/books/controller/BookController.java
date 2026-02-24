package com.ust.books.controller;

import com.ust.books.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController(){
        initailizer();
    }

    private void initailizer(){
        books.addAll(List.of(
                new Book("Title 1", "Author 1", "Science"),
                new Book("Title 2", "Author 2", "Science"),
                new Book("Title 3", "Author 3", "History"),
                new Book("Title 4", "Author 4", "math"),
                new Book("Title 5", "Author 5", "math"),
                new Book("Title 6", "Author 6", "math")
        ));
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String category){
        if(category == null){
            return books;
        }
        return books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).toList();
    }

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title){
//        for(Book book: books){
//            if(book.getTitle().equalsIgnoreCase(title)){
//                return book;
//            }
//        }
//        return null;

        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    @PostMapping
    public void createBook(@RequestBody Book newBook){
        boolean isNewBook = books.stream().noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));
        if(isNewBook){
            books.add(newBook);
        }
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book updatedBook){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getTitle().equalsIgnoreCase(title)){
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title){
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}
