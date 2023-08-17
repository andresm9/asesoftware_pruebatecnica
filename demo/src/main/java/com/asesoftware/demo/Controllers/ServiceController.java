package com.asesoftware.demo.Controllers;

import com.asesoftware.demo.Models.Service;
import com.asesoftware.demo.Repositories.CommerceRepository;
import com.asesoftware.demo.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    CommerceRepository commerceRepository;

    @Autowired
    ServiceRepository repository;

    @GetMapping("/commerces/{commerceId}/services")
    public ResponseEntity<List<Service>> getAllServicesByCommerceId(@PathVariable(value = "commerceId") Long commerceId) {
        if (!commerceRepository.existsById(commerceId)) {
            throw new RuntimeException("Not found Commerce with id = " + commerceId);
        }

        List<Service> services = repository.findByCommerceId(commerceId);
        return new ResponseEntity<>(services, HttpStatus.OK);

    }
}
