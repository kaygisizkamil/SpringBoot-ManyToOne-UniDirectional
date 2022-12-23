package com.example.Relations.repository;

import com.example.Relations.domain.Author;
import com.example.Relations.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    public Optional<Book> findById(Long id);
    //public Book getBookById(Long id);//bunun yerine findById kullan
    //to be able to use method inside jpa repo need to explicitly write the name of the method
    List<Book> findAllByOrderByIdAsc();
}
