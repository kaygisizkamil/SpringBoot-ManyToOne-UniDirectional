package com.example.Relations.repository;

import com.example.Relations.domain.Author;
import com.example.Relations.service.responses.GetAuthorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    public Optional<Author> findById(Long id);
    //to be able to use method inside jpa repo need to explicitly write the name of the method
    List<Author>findAllByOrderByIdAsc();
}
