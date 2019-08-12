package com.example.demo.repository;

import com.example.demo.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street,Integer> {

}
