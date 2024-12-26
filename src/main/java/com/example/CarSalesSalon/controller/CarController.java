package com.example.CarSalesSalon.controller;

import com.example.CarSalesSalon.model.Car;
import com.example.CarSalesSalon.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car-list"; // Представление для отображения списка машин
    }

    @GetMapping("/cars/search")
    public String getCarsByBrend(@RequestParam("brend") String brend, Model model) {
        List<Car> cars;
        if (brend == null || brend.isBlank()){
            cars = carService.getAllCars();
        } else {
            cars = carService.getCarsByBrend(brend);
        }
        model.addAttribute("cars", cars);
        model.addAttribute("searchQuery", brend);
        return "car-list";
    }
}
