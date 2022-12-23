package com.example.Relations.service.concretes;

import com.example.Relations.domain.Author;
import com.example.Relations.repository.AuthorRepository;
import com.example.Relations.service.abstracts.AuthorService;
import com.example.Relations.service.exceptions.AuthorNotFound;
import com.example.Relations.service.requests.CreateAuthorRequest;
import com.example.Relations.service.requests.UpdateAuthorRequest;
import com.example.Relations.service.responses.GetAuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AuthorManager implements AuthorService {

    public AuthorRepository authorRepository;
    @Autowired
    public AuthorManager(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<GetAuthorResponse> getAllAuthors() {
        //to get all by ascend order
        List<Author>authors=this.authorRepository.findAllByOrderByIdAsc();
        List<GetAuthorResponse>getAuthorResponses=new ArrayList<>();
        for(Author author: authors){
            GetAuthorResponse getAuthorResponse=new GetAuthorResponse();
            getAuthorResponse.setId(author.getId());//id return edince id guncelleme sart
            getAuthorResponse.setFirstName(author.getFirstName());
            getAuthorResponse.setLastName(author.getLastName());
            getAuthorResponses.add(getAuthorResponse);
        }
        return getAuthorResponses;
    }

    @Override
    public void addAuthor(CreateAuthorRequest createAuthorRequest) {
        Author author=new Author();
        author.setFirstName(createAuthorRequest.getFirstName());
        author.setLastName(createAuthorRequest.getLastName());

        this.authorRepository.save(author);
        this.authorRepository.flush();

    }

    @Override
    public void updateAuthor(UpdateAuthorRequest updateAuthorRequest, Long id) {
        try {
            Author author = this.authorRepository.findById(id).get();
            author.setFirstName(updateAuthorRequest.getFirstName());
            author.setLastName(updateAuthorRequest.getLastName());
            this.authorRepository.save(author);
            this.authorRepository.flush();
        }
        catch (Exception e){
            throw new AuthorNotFound("No such an autor with the id "+ id);

        }



    }

    @Override
    public GetAuthorResponse getAuthorById(Long id) {
        try {
            Author author = this.authorRepository.findById(id).get();
            GetAuthorResponse getAuthorResponse = new GetAuthorResponse();
            getAuthorResponse.setId(author.getId());
            getAuthorResponse.setFirstName(author.getFirstName());
            getAuthorResponse.setLastName(author.getLastName());
            this.authorRepository.flush();
            return getAuthorResponse;
        }
          catch (Exception e){
            throw new AuthorNotFound("No such an author");
        }
    }
    @Override
    public void deleteAuthorById(Long id) {
        //as relation is unidirectional it is not possible to delete an author unless it has no book
        //in next days the bidirectional version will also be implemented
        try {
            this.authorRepository.deleteById(id);
            this.authorRepository.flush();
        }
        catch (Exception e){
            throw new AuthorNotFound("No such an author");
        }

    }


}
