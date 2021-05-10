package com.github.gabrieljofre.petly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gabrieljofre.petly.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
