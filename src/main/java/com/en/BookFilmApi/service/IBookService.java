package com.en.BookFilmApi.service;

import java.util.List;

import com.en.BookFilmApi.model.Book;

public interface IBookService {

	List<Book> findAll();

	Book save(Book newBook);

	Book findByTitle(String title);

	void deleteById(Long id);

	void deleteAll();
}
