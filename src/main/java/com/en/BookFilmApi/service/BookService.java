package com.en.BookFilmApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.en.BookFilmApi.model.Book;
import com.en.BookFilmApi.repository.BookRepository;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository repository;

    BookService(BookRepository repository) {
        this.repository = repository;
      }
    
    @Override
    public List<Book> findAll() {

        return (List<Book>) repository.findAll();
    }

	@Override
	public Book save(Book newBook) {
		return repository.save(newBook);
	}

	@Override
	public Book findByTitle(String title) {
		return repository.findByTitle(title);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
		
	}
}
