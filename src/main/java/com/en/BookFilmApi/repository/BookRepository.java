package com.en.BookFilmApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.en.BookFilmApi.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByTitle(String title);
  
}
