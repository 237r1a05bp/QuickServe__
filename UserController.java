[8:14 pm, 22/02/2026] R.Navy sri🦋: package com.quickserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quickserve.model.User;
import com.quickserve.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        Optional<User> user = userService.login(email, password);

        if (user.isPresent()) {
            return "Login Successful! Role: " + user.get().getRole();
        }
        return "Invalid Credentials";
    }
}
[8:15 pm, 22/02/2026] R.Navy sri🦋: Service Entity
package com.quickserve.model;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;
    private String category;
    private Double price;
    private String description;

}