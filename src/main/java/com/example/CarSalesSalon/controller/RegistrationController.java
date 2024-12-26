package com.example.CarSalesSalon.controller;

import com.example.CarSalesSalon.model.RegistrationRequest;
import com.example.CarSalesSalon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationRequest", new RegistrationRequest());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("registrationRequest") RegistrationRequest request, Model model) {

        System.out.println("Регистрация пользователя: " + request.getUsername());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Пароли совпадают: " + request.getPassword().equals(request.getConfirmPassword()));

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            model.addAttribute("error", "Пароли не совпадают");
            return "registration";
        }

        try {
            userService.registerUser(request);
            return "redirect:/login?success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registration";
        }
    }
}
