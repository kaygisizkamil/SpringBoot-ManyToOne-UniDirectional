package com.example.Relations.service.concretes;

import com.example.Relations.domain.Book;
import com.example.Relations.repository.AuthorRepository;
import com.example.Relations.repository.BookRepository;
import com.example.Relations.service.abstracts.BookService;
import com.example.Relations.service.requests.CreateBookRequest;
import com.example.Relations.service.requests.UpdateBookRequest;
import com.example.Relations.service.responses.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Relations.service.exceptions.*;


import java.util.ArrayList;
import java.util.List;
@Service

public class BookManager implements BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    @Autowired
    public BookManager(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(CreateBookRequest createBookRequest){
      try{
            //you may want to change this exception cuz if any of book has null author in it
            //it will throw an exception
            Book book=new Book();
            book.setIsbn(createBookRequest.getIsbn());
            book.setName(createBookRequest.getName());
            book.setAuthor(this.authorRepository.findById(createBookRequest.getAuthor_id()).get());
            this.bookRepository.save(book);
            this.bookRepository.flush();
        }
      catch(Exception e){
          throw new AuthorNotFound("No author that has the id of "+ createBookRequest.getAuthor_id());
      }
    }

    // i did not add exceptino handling in here you can add that
    //if there is no such a record it will return 200 anyway
    @Override
    public List<GetBookResponse> getAllBooks() {

            List<Book> books = this.bookRepository.findAllByOrderByIdAsc();
            if(books.isEmpty())throw new BookNotFound("No book in db") ;
            List<GetBookResponse> bookResponses = new ArrayList<>();

            for (Book book : books) {
                GetBookResponse getBookResponse = new GetBookResponse();
                getBookResponse.setIsbn(book.getIsbn());
                getBookResponse.setName(book.getName());
                getBookResponse.setId(book.getId());
                getBookResponse.setAuthor_id(book.getAuthor().getId());
                bookResponses.add(getBookResponse);
            }
            return bookResponses;


        }
    @Override
    public GetBookResponse getBookById(Long id){
        try {
            Book book = this.bookRepository.findById(id).get();
            GetBookResponse getBookResponse = new GetBookResponse();
            getBookResponse.setId(book.getId());
            getBookResponse.setIsbn(book.getIsbn());
            getBookResponse.setName(book.getName());
            getBookResponse.setAuthor_id(book.getAuthor().getId());
            return getBookResponse;
        }
        catch(Exception e){
            throw new BookNotFound("No book that has the id of " + bookRepository.findById(id));
        }
    }

    @Override
    public void updateBook(UpdateBookRequest updateBookRequest, Long id) {
        try {
            Book book = this.bookRepository.findById(id).get();
            if(book==null) new BookNotFound("No book that has the id of " + bookRepository.findById(id));
            book.setName(updateBookRequest.getName());
            book.setIsbn(updateBookRequest.getIsbn());
            book.setAuthor(this.authorRepository.findById(updateBookRequest.getAuthor_id()).get());
            this.bookRepository.save(book);
        } catch (Exception ex) {
                throw new AuthorNotFound("No author that has the id of " + updateBookRequest.getAuthor_id());
            }

    }
    @Override
    public void deleteBook(Long id){
        try {
            //using getReference might be better idea to not to make a two heat  on database but it is small example so its cool
            Book book = this.bookRepository.findById(id).get();
            this.bookRepository.delete(book);
            this.bookRepository.flush();
        }
        catch (Exception e){
            throw new BookNotFound("There is no such a book with the id of "+id);

        }
    }
}
