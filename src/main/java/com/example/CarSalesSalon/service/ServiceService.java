package com.example.CarSalesSalon.service;

import com.example.CarSalesSalon.model.MyService;
import com.example.CarSalesSalon.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Получить все услуги
    public List<MyService> getAllServices() {
        return serviceRepository.findAll();
    }

    // Сохранить новую услугу
    public MyService saveService(MyService service) {
        return serviceRepository.save(service);
    }

    // Получить услугу по ID
    public MyService getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    // Обновить услугу
    public MyService updateService(Long id, MyService serviceDetails) {
        MyService service = getServiceById(id);
        if (service != null) {
            service.setName(serviceDetails.getName());
            service.setDescription(serviceDetails.getDescription());
            service.setPrice(serviceDetails.getPrice());
            return serviceRepository.save(service);
        }
        return null;
    }

    // Удалить услугу
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}

