package com.en.BookFilmApi.data;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.en.BookFilmApi.model.Book;
import com.en.BookFilmApi.model.Film;
import com.en.BookFilmApi.repository.BookRepository;
import com.en.BookFilmApi.repository.FilmRepository;

@SpringBootApplication
public class LoadDatabase {

  private static final org.jboss.logging.Logger log = LoggerFactory.logger(LoadDatabase.class);

  public static void main(String[] args) {
    SpringApplication.run(LoadDatabase.class);
  }

  @Bean
  public CommandLineRunner demo(final BookRepository repository,FilmRepository filmRepository) {
    return new CommandLineRunner() {
		@Override
		public void run(String... args) throws Exception {
		  repository.save(new Book( 1L,"Harry Potter and the Philosopher's Stone",
				  "	J. K. Rowling", "United Kingdom", "06/26/1997", "Bloomsbury (UK)","Book"));
		  
		  repository.save(new Book( 2L,"Dune",
				  "	Frank Herbert", "	United States", "08/01/1965", "	Chilton Books","Book"));

		  log.info("Books found with findAll():");
		  log.info("-------------------------------");
		  for (Book book : repository.findAll()) {
		    log.info(book.toString());
		  }
		  filmRepository.save(new Film( 1L,"Harry Potter and the Philosopher's Stone",
				  "J. K. Rowling", "United Kingdom", "11/04/2001", "John Seale","Film"));
		  
		  filmRepository.save(new Film( 2L,"Dune",
				  "David Lynch", "	United States", "12/03/1984", "Freddie Francis","Book"));

		  log.info("Films found with findAll():");
		  log.info("-------------------------------");
		  for (Film film : filmRepository.findAll()) {
		    log.info(film.toString());
		  }
		}
	};
  
		
	}

}
