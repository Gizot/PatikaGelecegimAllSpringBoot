package com.allianz.BlogApp.repository;

import com.allianz.BlogApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
