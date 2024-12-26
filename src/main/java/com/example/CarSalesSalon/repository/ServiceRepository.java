
package com.example.CarSalesSalon.repository;

import com.example.CarSalesSalon.model.MyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<MyService, Long> {
    // Дополнительные методы для работы с услугами
}

