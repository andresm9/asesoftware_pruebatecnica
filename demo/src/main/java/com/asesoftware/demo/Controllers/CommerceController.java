package com.asesoftware.demo.Controllers;

import com.asesoftware.demo.Models.Commerce;
import com.asesoftware.demo.Repositories.CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CommerceController {

    @Autowired
    CommerceRepository commerceRepository;

    @GetMapping("commerces")
    public ResponseEntity<List<Commerce>> getAll(){
        List<Commerce> commerces = commerceRepository.findAll();
        if(commerces.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(commerces, HttpStatus.OK);
    }

}
