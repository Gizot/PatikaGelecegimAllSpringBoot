package com.allianz.BlogApp.repository;

import com.allianz.BlogApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
