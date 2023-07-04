package com.example.cipherSpringAPP.Services;


import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final GetUsersDatabaseRepository userRepository;
    private final RoleRepository rolesRepository;
    @Autowired
    public RegistrationService(GetUsersDatabaseRepository userRepository,RoleRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    public void registerUser(Users user) throws IllegalArgumentException{
        try{
            userRepository.save(user);
        }catch (IllegalArgumentException e){
            System.out.println("Vlozenie nebolo uspešne \n");
            throw e;
        }

        // Vyhľadanie role USER a získanie jej ID
        List<Roles> userRole = rolesRepository.findByRole("USER");
        if (userRole != null) {
            // Pridanie role do zoznamu rolí pre používateľa
            user.setRoles(userRole);
            try {
                userRepository.save(user);
            }catch (IllegalArgumentException e){
                System.out.println("Vlozenie nebolo uspešne \n");
                throw e;
            }
        }
    }

}