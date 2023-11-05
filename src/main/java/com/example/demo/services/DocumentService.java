package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Document;
import com.example.demo.models.DocumentCreationError;
import com.example.demo.models.Position;
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

    public List<Document> getDocuments(String document_number){
        log.info("Listing documents");
        if (document_number != null && !document_number.equals(""))  return documentRepository.findBydocument_number(document_number);
        return documentRepository.findAll();
     }

    public ResponseEntity<?> saveDocument(Document document){
        String document_number = document.getDocument_number();
        if (!documentRepository.findBydocument_number(document_number).isEmpty()){
            log.info("Document creation error occured");
            documentCreationError(document_number);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Document with the same number already exists.");
        }else{
            log.info("Saving new document: {}", document);
            documentRepository.save(document);
            return ResponseEntity.ok(document);
        }
    }

    public void deleteDocument(long id){
        documentRepository.deleteById(id);
        log.info("Document {} deleted", id);
    }

    public ResponseEntity<?> getDocumentById(long id){
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null){
            return ResponseEntity.ok(document);
        }else{
            return ResponseEntity.badRequest().body("No such document.");
        }
    }

    public ResponseEntity<?> updateDocument(long id, Document updated_document){
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null){
            if (updated_document.getDocument_number() != null){
                document.setDocument_number(updated_document.getDocument_number());
            }
            if (updated_document.getDate() != null){
                document.setDate(updated_document.getDate());
            }
            if (updated_document.getNote() != null){
                document.setNote(updated_document.getNote());
            }

            documentRepository.save(document);
            log.info("Document {} updated", id);
            return ResponseEntity.ok("Successful update.");
        }else{
            log.error("Update document {} error", id);
            log.error("Input arguments: \nid = {}\ndocument_number = {}\ndate = {}\nnote =", id, updated_document.getDocument_number(), updated_document.getDate(), updated_document.getNote());
            return ResponseEntity.badRequest().body("No such document.");
        }
    }

    public void documentCreationError(String document_number){
        DocumentCreationError document_error = new DocumentCreationError();
        document_error.setName("Ошибка при создании документа");
        document_error.setNote("Повторяющийся номер документа: " + document_number);
        errorRepository.save(document_error);
    }

    public ResponseEntity<List<Position>> getPositions(Long document_id){
        return ResponseEntity.ok(documentRepository.findById(document_id).get().getPositions());
    }
}