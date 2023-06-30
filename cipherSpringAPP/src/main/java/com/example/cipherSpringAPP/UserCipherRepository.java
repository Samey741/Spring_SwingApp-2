package com.example.cipherSpringAPP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCipherRepository extends JpaRepository<UserCipherData, Long> {

    //List<UserCipherData> findByLogin(String username);

}



