package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.DocumentService;

@Controller
public class DocumentsController{

    private final DocumentService documentService;

    public DocumentsController(DocumentService documentService){
        this.documentService = documentService;
    }
    
    @GetMapping("/")
    public String documents(Model model){
        model.addAttribute("documents", documentService.listDocuments());
        return "documents";
    }
}
