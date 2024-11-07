package com.example.CarSalesSalon.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "contact_forms")
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть длиной от 2 до 30 символов")
    private String name;

    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Некорректный формат email")
    private String email;

    @NotEmpty(message = "Сообщение не должно быть пустым")
    @Size(min = 10, message = "Сообщение должно быть минимум 10 символов")
    private String message;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
