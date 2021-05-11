package com.github.gabrieljofre.petly.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.gabrieljofre.petly.dto.PostDTO;
import com.github.gabrieljofre.petly.entities.Post;
import com.github.gabrieljofre.petly.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	@Transactional(readOnly = true)
	public List<PostDTO> findAll() {
		List<Post> result = repository.findAll();
		return result.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PostDTO getPost(Long id) {
		if (repository.findById(id).isPresent()) {
			Post result = repository.findById(id).get();
			return new PostDTO(result.getId(), result.getName(), result.getEmail(), result.getGenero(),
					result.getType());
		} else {
			return null;
		}
	}
}
