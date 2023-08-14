package com.allianz.BlogApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //Hibernate bu anotasyon sayesinde database de tablomuzu oluşturacak.
@Table(name="users") //istediğimiz ismi verebiliriz Userla aynı isim olmak zorunda değil
@Data //Getter ve setterları otomatik olarak generate edecek.
public class Users {
    @Id
    Long id;
    String userName;
    String password;

}
