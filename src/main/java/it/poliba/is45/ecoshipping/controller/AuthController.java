package it.poliba.is45.ecoshipping.controller;



import it.poliba.is45.ecoshipping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/login")



    }
