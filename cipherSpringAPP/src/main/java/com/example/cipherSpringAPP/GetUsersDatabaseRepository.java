package com.example.cipherSpringAPP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetUsersDatabaseRepository extends JpaRepository<GetUsersDatabase, Long> {
    // Prípadne definujte ďalšie metódy potrebné pre prácu s databázou
    GetUsersDatabase findByLogin(String login);

}