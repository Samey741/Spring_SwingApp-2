package com.example.cipherSpringAPP;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetUsersDatabaseRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);

}