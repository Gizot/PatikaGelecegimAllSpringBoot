package com.allianz.BlogApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="posts")
@Data
public class Post {
    @Id
    Long id;
    Long userId;
    String title;
    @Lob
    @Column(columnDefinition="text")
    String text;
}
