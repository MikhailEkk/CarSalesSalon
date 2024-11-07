package com.example.CarSalesSalon.repository;

import com.example.CarSalesSalon.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
    // Дополнительные методы для поиска можно добавить здесь
}
