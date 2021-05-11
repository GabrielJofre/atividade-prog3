package com.github.gabrieljofre.petly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gabrieljofre.petly.dto.PostDTO;
import com.github.gabrieljofre.petly.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<PostDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable("id") Long id) {
		PostDTO post = service.getPost(id);
		return ResponseEntity.ok(post);
	}
}
