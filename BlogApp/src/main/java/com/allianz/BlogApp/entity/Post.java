package com.allianz.BlogApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="post")
@Data
public class Post {
    @Id
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)// User objesinin databaseden hemen çekme
            //LAZY ile Post objesini çektiğimde ilgili user objesini bana getirmene gerek yok diyorum.
            //Fetch.Type.EAGER yazsaydım ilgili objeyi de beraberinde getirirdi.

    @JoinColumn(name = "user_id", nullable = false) //Database deki user id colonuyla user objesine bağlandığımızı
    // bildirmiş oluyoruz ve bu alan null olmasın diyoruz.
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiğinde tüm postlarını da sil dedik
    @JsonIgnore // Serilization işlemlerinde sorun çıkartmasın bize diye ignore ettik.
    Users users;
    String title;
    @Lob
    @Column(columnDefinition="text")
    String text;
}
