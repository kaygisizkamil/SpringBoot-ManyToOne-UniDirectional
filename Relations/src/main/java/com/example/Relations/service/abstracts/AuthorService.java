package com.example.Relations.service.abstracts;

import com.example.Relations.service.requests.CreateAuthorRequest;
import com.example.Relations.service.requests.UpdateAuthorRequest;
import com.example.Relations.service.responses.GetAuthorResponse;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AuthorService {
    List<GetAuthorResponse> getAllAuthors();
    void addAuthor(CreateAuthorRequest createAuthorRequest);
    void updateAuthor(UpdateAuthorRequest updateAuthorRequest, Long id);
    GetAuthorResponse getAuthorById(Long id);
    void deleteAuthorById(Long id);
}
