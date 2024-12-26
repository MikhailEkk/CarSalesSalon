package com.example.CarSalesSalon.service;

import com.example.CarSalesSalon.model.RegistrationRequest;
import com.example.CarSalesSalon.model.Role;
import com.example.CarSalesSalon.model.User;
import com.example.CarSalesSalon.repository.RoleRepository;
import com.example.CarSalesSalon.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository; // Для назначения ролей
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationRequest request) {
        System.out.println("Начало регистрации пользователя: " + request.getUsername());

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            System.out.println("Имя пользователя уже занято.");
            throw new RuntimeException("Имя пользователя уже занято");
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            System.out.println("Email уже используется.");
            throw new RuntimeException("Email уже используется");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        // Назначаем роль USER по умолчанию
        Role userRole = roleRepository.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Роль USER не найдена"));
        user.setRoles(Set.of(userRole));

        userRepository.save(user);

        System.out.println("Регистрация завершена для пользователя: " + request.getUsername());
    }
}
