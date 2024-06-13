package com.example.demo.repository;

import com.example.demo.models.Varietal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietalRepository extends JpaRepository<Varietal, Long> {
}