package com.github.gabrieljofre.petly.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.gabrieljofre.petly.dto.PostDTO;
import com.github.gabrieljofre.petly.entities.Post;
import com.github.gabrieljofre.petly.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<PostDTO> findAll() {
		List<Post> result = repository.findAll();
		return result.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
}