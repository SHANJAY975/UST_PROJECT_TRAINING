package com.ust.books.controller;

import com.ust.books.entity.Book;
import com.ust.books.exception.BookNotFoundException;
import com.ust.books.request.BookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Book Rest API Endpoints", description = "Operations related to books")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController(){
        initailizer();
    }

    private void initailizer(){
        books.addAll(List.of(
                new Book(1, "Computer Science Pro", "Chad Darby", "Computer Science", 5),
                new Book(2, "Java Spring Mastery", "Eric Roby", "Computer Science", 5),
                new Book(3, "Why 1+1 rocks", "Adil A", "math", 5),
                new Book(4, "How bears Hibernate", "Bob b", "Science", 2),
                new Book(5, "A pirates Treasure", "Curt C", "History", 3),
                new Book(6, "Why 2+2 better", "Darby", "Math", 1)

        ));
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all books", description = "Retreive a list of all available Books")
    public List<Book> getBooks(@RequestParam(required = false) String category){
        if(category == null){
            return books;
        }
        return books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Book by ID", description = "Retreive a specific book by Id")
    public Book getBookById(@Parameter(description = "ID of the book to be retrieved") @PathVariable @Min(value = 1) long id){
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(()->new BookNotFoundException("Book not Found. ID: "+id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new Book", description = "Add a new book to the list")
    public void createBook(@RequestBody @Valid BookRequest bookRequest){
        long id = books.isEmpty()? 1 : books.get(books.size()-1).getId() + 1;
        Book book = convertToBook(id, bookRequest);
        books.add(book);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Update a Book", description = "update the details of the book")
    public Book updateBook(@PathVariable @Min(value = 1) @Parameter(description = "ID of the book to be Updated") long id,@Valid @RequestBody BookRequest bookRequest){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId()== id){
                Book updatedBook = convertToBook(id, bookRequest);
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        throw new BookNotFoundException("Book not Found -"+id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete book with Id", description = "delete the existing book from list")
    public void deleteBook(@Parameter(description = "ID of the book to be Deleted") @PathVariable @Min(value = 1) long id){
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(()->new BookNotFoundException("Book not Found. ID: "+id));
        books.removeIf(book -> book.getId() == id);
    }

    private Book convertToBook(long id, BookRequest bookRequest){
        return new Book(id, bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getCategory(), bookRequest.getRating());
    }




}
