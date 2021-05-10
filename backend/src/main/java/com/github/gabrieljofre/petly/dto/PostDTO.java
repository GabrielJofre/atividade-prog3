package com.github.gabrieljofre.petly.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.github.gabrieljofre.petly.entities.Post;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String genero;
	private LocalDate date;
	private String type;

	public PostDTO() {
	}

	public PostDTO(Long id, String name, String email, String genero, LocalDate date, String type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.genero = genero;
		this.date = date;
		this.type = type;
	}

	public PostDTO(Post entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		genero = entity.getGenero();
		date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
