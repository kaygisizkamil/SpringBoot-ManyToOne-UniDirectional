package com.example.Relations.controller;

import com.example.Relations.service.abstracts.BookService;
import com.example.Relations.service.requests.CreateAuthorRequest;
import com.example.Relations.service.requests.CreateBookRequest;
import com.example.Relations.service.requests.UpdateAuthorRequest;
import com.example.Relations.service.requests.UpdateBookRequest;
import com.example.Relations.service.responses.GetAuthorResponse;
import com.example.Relations.service.responses.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private BookService bookService;
    @Autowired

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Void>addAuthor(@RequestBody CreateBookRequest createBookRequest){
        this.bookService.createBook(createBookRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/books")
    public ResponseEntity<List<GetBookResponse>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<GetBookResponse>getBookById(@PathVariable Long id){
        return new ResponseEntity<>(this.bookService.getBookById(id),HttpStatus.OK);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Void>updateBook(@RequestBody UpdateBookRequest updateBookRequest, @PathVariable Long id){
        this.bookService.updateBook(updateBookRequest,id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
      @DeleteMapping("/books/{id}")
      public ResponseEntity<Void>deleteBook(@PathVariable Long id){
          this.bookService.deleteBook(id);
          return new ResponseEntity<Void>(HttpStatus.OK);

      }

}
