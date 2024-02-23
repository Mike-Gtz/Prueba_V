package com.example.demo.repository;


import com.example.demo.models.CiudadanosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CiudadanoRepository extends JpaRepository<CiudadanosModel, Long> {
}

