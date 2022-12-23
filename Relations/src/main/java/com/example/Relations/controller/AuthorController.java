package com.example.Relations.controller;

import com.example.Relations.service.abstracts.AuthorService;
import com.example.Relations.service.requests.CreateAuthorRequest;
import com.example.Relations.service.requests.UpdateAuthorRequest;
import com.example.Relations.service.responses.GetAuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/authors")
    public ResponseEntity<List<GetAuthorResponse>>getAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }
    @GetMapping("/authors/{id}")
    public ResponseEntity<GetAuthorResponse>getAuthorById(@PathVariable Long id){
        return new ResponseEntity<>(this.authorService.getAuthorById(id),HttpStatus.OK);
    }
    @PostMapping("/authors")
    public ResponseEntity<Void>addAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        this.authorService.addAuthor(createAuthorRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

   @PutMapping("/authors/{id}")
   public ResponseEntity<Void>updateAuthor(@RequestBody UpdateAuthorRequest updateAuthorRequest, @PathVariable Long id){
       this.authorService.updateAuthor(updateAuthorRequest,id);
      return new ResponseEntity<Void>(HttpStatus.OK);
   }
   @DeleteMapping("/authors/{id}")
   public ResponseEntity<Void>deleteAuthor(@PathVariable Long id){
       this.authorService.deleteAuthorById(id);
       return new ResponseEntity<Void>(HttpStatus.OK);

   }

}
