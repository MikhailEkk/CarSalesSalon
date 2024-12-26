package com.example.CarSalesSalon.controller;

import com.example.CarSalesSalon.model.MyService;
import com.example.CarSalesSalon.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // Получить все услуги и отобразить их на странице
    @GetMapping
    public String getAllServices(Model model) {
        List<MyService> myServices = serviceService.getAllServices();
        model.addAttribute("myServices", myServices);
        return "services"; // имя представления (например, myServices.html)
    }

    // Получить услугу по ID и отобразить на странице
    @GetMapping("/{id}")
    public String getServiceById(@PathVariable Long id, Model model) {
        MyService myService = serviceService.getServiceById(id);
        if (myService != null) {
            model.addAttribute("myService", myService);
            return "serviceDetails"; // имя представления для деталей услуги
        }
        return "404"; // имя представления для страницы "Не найдено"
    }

    // Показать форму для создания новой услуги
    @GetMapping("/create")
    public String createServiceForm(Model model) {
        model.addAttribute("service", new MyService());
        return "serviceForm"; // имя представления для формы создания услуги
    }

    // Сохранить новую услугу
    @PostMapping
    public String createService(@ModelAttribute MyService myService) {
        serviceService.saveService(myService);
        return "redirect:/services"; // перенаправление на список услуг после сохранения
    }

    // Показать форму для обновления услуги
    @GetMapping("/edit/{id}")
    public String editServiceForm(@PathVariable Long id, Model model) {
        MyService myService = serviceService.getServiceById(id);
        if (myService != null) {
            model.addAttribute("myService", myService);
            return "serviceForm"; // имя представления для формы редактирования услуги
        }
        return "404"; // имя представления для страницы "Не найдено"
    }

    // Обновить существующую услугу
    @PostMapping("/update/{id}")
    public String updateService(@PathVariable Long id, @ModelAttribute MyService myServiceDetails) {
        serviceService.updateService(id, myServiceDetails);
        return "redirect:/services"; // перенаправление на список услуг после обновления
    }

    // Удалить услугу
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return "redirect:/services"; // перенаправление на список услуг после удаления
    }
}

