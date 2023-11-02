package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Document;
import com.example.demo.models.Position;

import com.example.demo.repositories.DocumentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {
    private final DocumentRepository documentRepository;

    public List<Document> GetDocuments(String document_number){ 
        if (document_number != null)  return documentRepository.findBydocument_number(document_number);
        return documentRepository.findAll();
     }

    public void saveDocument(Document document){
        log.info("Saving new {}", document);
        documentRepository.save(document);
    }

    public void deleteDocument(long id){
        documentRepository.deleteById(id);
        log.info("Document {} deleted", id);
    }

    public Document getDocumentById(long id){
        return documentRepository.findById(id).orElse(null);
    }

    public void updateDocument(long id, String document_number, LocalDate date, String note){
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null){
            if (document_number != null){
                document.setDocument_number(document_number);
            }
            if (date != null){
                document.setDate(date);
            }
            if (note != null){
                document.setNote(note);
            }

            documentRepository.save(document);
            log.info("Document {} updated", id);
        }else{
            log.error("Update document {} error", id);
            log.error("Input arguments: \nid = {}\ndocument_number = {}\ndate = {}\nnote =", id, document_number, date, note);
        }
    }

    public void addPositionToDocument(long id, Position position){
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null){
            document.addPositionToDocument(position);
            documentRepository.save(document);
        }
    }
}
