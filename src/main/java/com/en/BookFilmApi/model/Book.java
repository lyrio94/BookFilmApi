package com.en.BookFilmApi.model;


import java.util.function.Supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public  class Book  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String country;
	private String releaseDate;
	private String publisher;
	private String type;

	public Book() {}

	public Book(Long id, String title, String author, String country, String releaseDate, String publisher,
			String type) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.country = country;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.type = type;
	}
	public Long getId() {
		    return this.id;
		  }
	 public void setId(Long id) {
		    this.id = id;
		  }
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Book orElseThrow(Supplier<Throwable> supplier) {
		return null;
	}

	   @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("Book{");
	        sb.append("id=").append(id);
	        sb.append(", title='").append(title).append('\'');
	        sb.append(", country='").append(country).append('\'');
	        sb.append(", releaseDate='").append(releaseDate).append('\'');
	        sb.append(", publisher='").append(publisher).append('\'');
	        sb.append(", type='").append(type).append('\'');
	        sb.append('}');
	        return sb.toString();
	   }
	
}