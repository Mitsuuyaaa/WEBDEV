package com.Salazar.Midterm.Exam.service;

import com.Salazar.Midterm.Exam.dto.ProductDTO;
import com.Salazar.Midterm.Exam.model.Product;
import com.Salazar.Midterm.Exam.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product save(ProductDTO dto) {
        Product p = new Product();
        p.setName(dto.name());
        p.setDescription(dto.description());
        p.setStock(dto.stock());
        p.setUnit(dto.unit());
        p.setPrice(dto.price());
        return repo.save(p);
    }

    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product update(Product existing, ProductDTO dto) {
        existing.setName(dto.name());
        existing.setDescription(dto.description());
        existing.setStock(dto.stock());
        existing.setUnit(dto.unit());
        existing.setPrice(dto.price());
        return repo.save(existing);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
