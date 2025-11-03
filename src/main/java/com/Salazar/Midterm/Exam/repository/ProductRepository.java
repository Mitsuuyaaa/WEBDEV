package com.Salazar.Midterm.Exam.repository;

import com.Salazar.Midterm.Exam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
