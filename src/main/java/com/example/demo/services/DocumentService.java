package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Document;

@Service
public class DocumentService {
    private List<Document> documents = new ArrayList<Document>();
    private long ID = 0;

    {
        documents.add(new Document(++ID, "1", LocalDate.now(), 1, "document"));
        documents.add(new Document(++ID, "2", LocalDate.now(), 2, "document2"));
    }

    public List<Document> GetDocuments(){ return documents; }

    public void saveDocument(Document document){
        document.setId(++ID);
        documents.add(document);
    }

    public void deleteDocument(long id){
        documents.removeIf(document -> document.getId().equals(id));
    }

    public Document getDocumentById(long id){
        for (Document document : documents){
            if (document.getId().equals(id)) return document;
        }
         return null;
    }
}
