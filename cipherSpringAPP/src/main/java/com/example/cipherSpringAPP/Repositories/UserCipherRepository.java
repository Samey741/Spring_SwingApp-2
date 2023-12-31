package com.example.cipherSpringAPP.Repositories;

import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCipherRepository extends JpaRepository<UserCyphers, Long> {
    List<UserCyphers> findAllByUserId(Long id);

}



