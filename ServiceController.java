package com.quickserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quickserve.model.ServiceEntity;
import com.quickserve.repository.ServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<ServiceEntity> getByCategory(@PathVariable String category) {
        return serviceRepository.findByCategory(category);
    }
