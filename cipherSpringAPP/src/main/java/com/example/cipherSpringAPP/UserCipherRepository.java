package com.example.cipherSpringAPP;

import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCipherRepository extends JpaRepository<UserCyphers, Long> {


}



