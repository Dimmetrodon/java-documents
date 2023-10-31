package com.example.demo.models;

import java.time.LocalDate;

public class Document {
    private Long id;
    private String document_number;
    private LocalDate date;
    private int sum;
    private String note;

    public Document(Long id, String document_number, LocalDate date, int sum, String note) {
        this.id = id;
        this.document_number = document_number;
        this.date = date;
        this.sum = sum;
        this.note = note;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDocument_number() {
        return document_number;
    }
    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}

