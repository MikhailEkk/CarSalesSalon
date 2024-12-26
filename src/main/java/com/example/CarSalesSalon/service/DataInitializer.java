package com.example.CarSalesSalon.service;

import com.example.CarSalesSalon.model.Car;
import com.example.CarSalesSalon.model.Role;
import com.example.CarSalesSalon.model.User;
import com.example.CarSalesSalon.repository.RoleRepository;
import com.example.CarSalesSalon.repository.UserRepository;
import com.example.CarSalesSalon.repository.CarRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.HashSet;

@Component
@Profile("dev")
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CarRepository carRepository;

    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, CarRepository carRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initData() {
        // Создаем роли
        Role adminRole = new Role();
        adminRole.setRoleName("ROLE_ADMIN");
        Role userRole = new Role();
        userRole.setRoleName("ROLE_USER");

        adminRole = roleRepository.save(adminRole);
        userRole = roleRepository.save(userRole);

        // Создаем пользователей
        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("admin")); // Шифруем пароль
        adminUser.setRoles(new HashSet<>());
        adminUser.getRoles().add(adminRole);

        User regularUser = new User();
        regularUser.setUsername("user");
        regularUser.setPassword(passwordEncoder.encode("user")); // Шифруем пароль
        regularUser.setRoles(new HashSet<>());
        regularUser.getRoles().add(userRole);

        userRepository.save(adminUser);
        userRepository.save(regularUser);

        // Добавление автомобилей
        Car car1 = new Car("Toyota", "Camry", "Sedan", 2021, 30000.0);
        Car car2 = new Car("BMW", "X5", "SUV", 2022, 50000.0);
        Car car3 = new Car("Audi", "A4", "Sedan", 2020, 35000.0);
        Car car4 = new Car("Mercedes-Benz", "GLE", "SUV", 2023, 60000.0);
        Car car5 = new Car("Honda", "Civic", "Compact", 2019, 20000.0);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);


        System.out.println("Данные успешно инициализированы!");
    }
}

