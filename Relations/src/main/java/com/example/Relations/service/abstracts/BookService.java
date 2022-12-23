package com.example.Relations.service.abstracts;

import com.example.Relations.service.requests.CreateBookRequest;
import com.example.Relations.service.requests.UpdateBookRequest;
import com.example.Relations.service.responses.GetBookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    void createBook(CreateBookRequest createBookRequest);
    List<GetBookResponse> getAllBooks();
    void updateBook(UpdateBookRequest updateBookRequest, Long id);
    GetBookResponse getBookById(Long id);
    void deleteBook (Long id);
}
