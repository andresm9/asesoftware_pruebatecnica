package com.asesoftware.demo.Repositories;

import com.asesoftware.demo.Models.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommerceRepository extends JpaRepository<Commerce, Long> {

}
