package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Document;
import com.example.demo.services.DocumentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DocumentsController{

    private final DocumentService documentService;

    @GetMapping("/")
    public ResponseEntity<?> documents(@RequestParam(name = "document_number", required = false) String document_number) {
        return ResponseEntity.ok(documentService.getDocuments(document_number));
    }

    @GetMapping("/document/{id}")
    public ResponseEntity<?> documentInfo(@PathVariable Long id){
        return documentService.getDocumentById(id);
    }

    @PostMapping("/document/create")
    public ResponseEntity<?> createDocument(@RequestBody Document document){
        return documentService.saveDocument(document);
    }

    @DeleteMapping("/document/delete/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable Long id){
        documentService.deleteDocument(id);
        return ResponseEntity.ok("Successful deletion");
    }

    @PostMapping("/document/update/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable long id, @RequestBody Document document){
        return documentService.updateDocument(id, document);
    }

    @GetMapping("/document/getpositions/{document_id}")
    public ResponseEntity<?> getPositions(@PathVariable long document_id){
        return documentService.getPositions(document_id);
    }
}
