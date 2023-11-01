package com.example.demo.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Document;
import com.example.demo.services.DocumentService;

@Controller
public class DocumentsController{

    private final DocumentService documentService;

    public DocumentsController(DocumentService documentService){
        this.documentService = documentService;
    }
    
    @GetMapping("/")
    public String documents(Model model){
        model.addAttribute("documents", documentService.GetDocuments());
        return "documents";
    }

    @GetMapping("/document/{id}")
    public String documentInfo(@PathVariable Long id, Model model){
        model.addAttribute("document", documentService.getDocumentById(id));
        return "document-info";
    }

    @PostMapping("/document/create")
    public String createDocument(Document document){
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @PostMapping("/document/delete/{id}")
    public String deleteDocument(@PathVariable Long id){
        documentService.deleteDocument(id);
        return "redirect:/";
    }

    @PostMapping("/document/update/{id}")
    public String updateDocument(@PathVariable long id, String document_number, LocalDate date, int sum, String note){
        documentService.updateDocument(id, document_number, date, sum, note);
        return "redirect:/document/{id}";
    }
}
