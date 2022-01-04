package com.belajarspring.repo;

import java.util.List;

import com.belajarspring.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface productRepo extends CrudRepository<Product, Long>{
    List<Product> findByNameContains(String keyword);
}
