package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
    @Query("SELECT d FROM Document d WHERE d.document_number = ?1")
    List<Document> findBydocument_number(String document_number);
}
