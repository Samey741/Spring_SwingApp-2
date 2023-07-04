package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RegisterController {
    private final GetUsersDatabaseRepository userRepository;
    private final RoleRepository rolesRepository;
    @Autowired
    public RegisterController(GetUsersDatabaseRepository userRepository,RoleRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @PostMapping("/register")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession();
        Users user = new Users(username,password);
        try{
            userRepository.save(user);
        }catch (IllegalArgumentException e){
            System.out.println("Vlozenie nebolo uspešne \n");
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
            }
        }

        return "redirect:/login" ;//+ userId;
    }

    @GetMapping(value = "/register")
    public String getLogin(Model model) {
        return "registration";
    }


}
