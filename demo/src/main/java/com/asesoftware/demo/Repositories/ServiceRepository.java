package com.asesoftware.demo.Repositories;

import com.asesoftware.demo.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByCommerceId(Long commerceId);

}
