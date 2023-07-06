package com.example.cipherSpringAPP.Repositories;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByLogin(String login);

    Users findUsersById(Long id);

}