package com.allianz.BlogApp.repository;

import com.allianz.BlogApp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //jpa , hazır kütüphanesinde bulunan findAll, findById, delete, save ..vs
    //gibi hazır metotları kullanarak database'ee hazır query'ler göndermemize olanak
    //sağlar.
}
