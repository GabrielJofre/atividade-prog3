package com.github.gabrieljofre.petly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gabrieljofre.petly.dto.PostDTO;
import com.github.gabrieljofre.petly.entities.Post;
import com.github.gabrieljofre.petly.repositories.PostRepository;
import com.github.gabrieljofre.petly.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService service;

	// MUDAR DEPOIS
	@Autowired
	PostRepository repository;

	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable(value = "id") Long id) {
		PostDTO post = service.getPost(id);
		return ResponseEntity.ok(post);
	}

	// MUDAR DEPOIS
	@PostMapping()
	public Post create(@RequestBody Post post) {
		return repository.save(post);
	}

	// MUDAR DEPOIS
	@PutMapping(value = "/{id}")
	public ResponseEntity<Post> update(@PathVariable("id") long id, @RequestBody Post post) {
		return repository.findById(id).map(record -> {
			record.setName(post.getName());
			record.setEmail(post.getEmail());
			record.setGenero(post.getGenero());
			record.setType(post.getType());
			Post updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	// MUDAR DEPOIS
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
