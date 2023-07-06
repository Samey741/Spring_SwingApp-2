package com.example.cipherSpringAPP.Services;

import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.Repositories.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UsersRepository userRepository;

    public List<String> getUserRoles(String username) {
        Users user = userRepository.findByLogin(username);
        if (user != null) {
            List<Roles> roles = user.getRoles();
            List<String> roleNames = new ArrayList<>();
            for (Roles role : roles) {
                roleNames.add(role.getRole());
            }
            return roleNames;
        } else {
            return new ArrayList<>();
        }
    }

}
