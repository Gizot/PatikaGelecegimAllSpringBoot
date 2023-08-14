package com.allianz.BlogApp.service;

import com.allianz.BlogApp.entity.Post;
import com.allianz.BlogApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return postRepository.findByUsersId(userId.get());
            return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(Post newPost) {
        return postRepository.save(newPost);
    }
}
