package com.example.CarSalesSalon.controller;

import com.example.CarSalesSalon.model.ContactForm;
import com.example.CarSalesSalon.service.ContactFormService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactFormService contactFormService;

    @Autowired
    public ContactController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping
    public String submitContactForm(@ModelAttribute("contactForm") @Valid ContactForm contactForm,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        // Сохраняем форму в базе данных
        contactFormService.saveContactForm(contactForm);

        model.addAttribute("successMessage", "Ваш запрос отправлен успешно!");

        return "success";
    }
}
