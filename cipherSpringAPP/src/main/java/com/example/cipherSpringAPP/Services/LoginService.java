package com.example.cipherSpringAPP.Services;

import com.example.cipherSpringAPP.GetUsersDatabase;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    private final GetUsersDatabaseRepository usersRepository;

    @Autowired
    public LoginService(GetUsersDatabaseRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void printUsers() {
        List<GetUsersDatabase> users = usersRepository.findAll();
        for (GetUsersDatabase user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getLogin());
            System.out.println("Password: " + user.getPassword());
            System.out.println("-------------------");
        }
    }
}