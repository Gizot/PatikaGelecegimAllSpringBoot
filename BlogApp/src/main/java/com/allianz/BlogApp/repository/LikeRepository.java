package com.allianz.BlogApp.repository;

import com.allianz.BlogApp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
