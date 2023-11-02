package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Document;
import com.example.demo.models.DocumentCreationError;

import com.example.demo.repositories.DocumentRepository;
import com.example.demo.repositories.ErrorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final ErrorRepository errorRepository;

    public List<Document> GetDocuments(String document_number){
        log.info("Listing documents");
        if (document_number != null && !document_number.equals(""))  return documentRepository.findBydocument_number(document_number);
        return documentRepository.findAll();
     }

    public void saveDocument(Document document){
        if (!documentRepository.findBydocument_number(document.getDocument_number()).isEmpty()){
            log.info("Document creation error occured");
            DocumentCreationError(document.getDocument_number());
        }else{
            log.info("Saving new document: {}", document);
            documentRepository.save(document);
        }
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

    public void DocumentCreationError(String document_number){
        DocumentCreationError document_error = new DocumentCreationError();
        document_error.setName("Ошибка при создании документа");
        document_error.setNote("Повторяющийся номер документа: " + document_number);
        errorRepository.save(document_error);
    }
}