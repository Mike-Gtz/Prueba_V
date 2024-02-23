package com.example.demo.repository;

import com.example.demo.models.DomiciliosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DomiciliosRepository extends JpaRepository<DomiciliosModel, Long> {
}