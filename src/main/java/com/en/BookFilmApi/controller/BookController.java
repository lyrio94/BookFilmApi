package com.en.BookFilmApi.controller;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.en.BookFilmApi.model.Book;
import com.en.BookFilmApi.repository.BookRepository;
import com.en.BookFilmApi.service.IBookService;


@RestController
public class BookController {

	@Autowired
  private  IBookService bookService;
  private  BookRepository repository;
  
  BookController(IBookService bookService) {
	    this.bookService = bookService;
	  }

 		
    @GetMapping("/books")
    List<Book> all() {
    	return (List<Book>) bookService.findAll();
    }
   

    @PostMapping("/newBooks")
    Book newBook(@RequestBody Book newBook) {
      return bookService.save(newBook);
    }

    
    @GetMapping("/books/{title}")
    Book one(@PathVariable String title) throws Throwable {
      
      return bookService.findByTitle(title);

    }

    @PutMapping("/updateBooks/{id}")
    Book updateBook(@RequestBody  Book newBook, @PathVariable final Long id) {
      
      return (Book) repository.findById(id)
        .map(new Function<Book, Object>() {
  		@Override
  		public Object apply(Book book) {
  		    book.setTitle(newBook.getTitle());
  		    book.setAuthor(newBook.getAuthor());
  		    book.setCountry(newBook.getCountry());
  		    book.setReleaseDate(newBook.getReleaseDate());
  		    book.setPublisher(newBook.getPublisher());
  		    book.setType(newBook.getType());
  		    return repository.save(book);
  		  }
  	})
        .orElseGet(new Supplier<Object>() {
  		@Override
  		public Object get() {
  		    //newBook.setId(id);
  		    return repository.save(newBook);
  		  }
  	});
    }

    @DeleteMapping("/deleteBooks/{id}")
    void deleteBook(@PathVariable Long id) {
    	bookService.deleteById(id);
    }
    
    @DeleteMapping("/deletebBooks")
    void deleteAllBook() {
    	bookService.deleteAll();
    }
  }