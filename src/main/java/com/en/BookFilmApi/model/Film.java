package com.en.BookFilmApi.model;


import java.util.function.Supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "films")
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String country;
	private String releaseDate;
	private String cinematography;
	private String type;
	
	public Film() {}

	public Film(Long id, String title, String author, String country, String releaseDate, String cinematography,
			String type) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.country = country;
		this.releaseDate = releaseDate;
		this.cinematography = cinematography;
		this.type = type;
	}




	public Long getId() {
		return id;
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

	public String getCinematography() {
		return cinematography;
	}

	public void setCinematography(String cinematography) {
		this.cinematography = cinematography;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	   @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("Film{");
	        sb.append("id=").append(id);
	        sb.append(", title='").append(title).append('\'');
	        sb.append(", country='").append(country).append('\'');
	        sb.append(", releaseDate='").append(releaseDate).append('\'');
	        sb.append(", cinematography='").append(cinematography).append('\'');
	        sb.append(", type='").append(type).append('\'');
	        sb.append('}');
	        return sb.toString();
	   }

	public Film orElseThrow(Supplier<Throwable> supplier) {
		return null;
	}

}

