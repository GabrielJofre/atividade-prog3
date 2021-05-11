package com.github.gabrieljofre.petly.dto;

import java.io.Serializable;

import com.github.gabrieljofre.petly.entities.Post;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String genero;
	private String type;

	public PostDTO() {
	}

	public PostDTO(Long id, String name, String email, String genero, String type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.genero = genero;
		this.type = type;
	}

	public PostDTO(Post entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		genero = entity.getGenero();
		type = entity.getGenero();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
