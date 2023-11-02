package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DocumentCreationError;

public interface ErrorRepository extends JpaRepository<DocumentCreationError, Long>{

} 