package com.example.CarSalesSalon.repository;

import com.example.CarSalesSalon.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrendIgnoreCase(String brend);
}
