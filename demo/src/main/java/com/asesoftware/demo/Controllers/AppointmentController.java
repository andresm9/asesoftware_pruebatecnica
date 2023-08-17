package com.asesoftware.demo.Controllers;

import com.asesoftware.demo.Models.Appointment;
import com.asesoftware.demo.Repositories.AppointmentRepository;
import com.asesoftware.demo.Repositories.ServiceRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AppointmentRepository repository;

    @GetMapping("/services/{serviceId}/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointmentsByServiceId(@PathVariable(value = "serviceId") Long serviceId) {
        if (!serviceRepository.existsById(serviceId)) {
            throw new RuntimeException("Not found Service with id = " + serviceId);
        }
        List<Appointment> appointments = repository.findByServiceId(serviceId);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/appointment/agenda")
    public ResponseEntity<List<Appointment>> getPossibleAppointments(
            @RequestParam(name = "start") String startDate,
            @RequestParam(name = "end") String endDate,
            @RequestParam(name = "service_id") Long serviceId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        List<Appointment> agenda = repository.getPossibleAppointments(start.atStartOfDay(), end.atTime(23,59), serviceId);
        return new ResponseEntity<>(agenda, HttpStatus.OK);
    }

    @PutMapping("/appointment/status/{id}")
    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable(value = "id") Long appointmentId, @RequestBody Appointment appointment) {
       Appointment _appointment = repository.findById(appointmentId).orElseThrow();

       _appointment.setStatus(appointment.getStatus());
       return new ResponseEntity<>(repository.save(_appointment), HttpStatus.OK);


    }


}
