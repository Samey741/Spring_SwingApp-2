package com.example.cipherSpringAPP.Repositories;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetUsersDatabaseRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);

    Users findUsersById(Long id);

}