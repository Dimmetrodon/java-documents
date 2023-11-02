package com.example.demo.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Document;
import com.example.demo.models.Position;
import com.example.demo.services.DocumentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DocumentsController{

    private final DocumentService documentService;

    @GetMapping("/")
    public String documents(@RequestParam(name = "document_number", required = false) String document_number, Model model){
        System.out.println("got:" + document_number + ".");
        model.addAttribute("documents", documentService.GetDocuments(document_number));
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
    public String updateDocument(@PathVariable long id, String document_number, LocalDate date, String note){
        documentService.updateDocument(id, document_number, date, note);
        return "redirect:/document/{id}";
    }

    @PostMapping("/document/addposition/{id}")
    public String addPositionToDocument(@PathVariable long id, Position position){
        documentService.addPositionToDocument(id, position);
        return "redirect:/document/{id}";
    }

    @PostMapping("document/updateposition/{id}")
    public String updatePosition(@PathVariable long id, Position position){
        documentService.updatePosition(id, position);
        return "redirect:/document/{id}";
    }

    @PostMapping("document/deleteposition/{id}")
    public String deletePosition(@PathVariable long id, Long position_id){
        documentService.deletePosition(id, position_id);
        return "redirect:/document/{id}";
    }
}
