package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Product;

// This is optional, but it is a good practice to annotate the repository interface with @Repository
// is optional because JpaRepository already has the @Repository annotation
@Repository 
public interface ProductRepository extends JpaRepository<Product, Long>{

}
