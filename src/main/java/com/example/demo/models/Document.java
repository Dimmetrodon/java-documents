package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "document_number")
    private String document_number;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "sum")
    private int sum;
    @Column(name = "note", columnDefinition = "text")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "document")
    private List<Position> positions = new ArrayList<>();
    private Long previewPositionId;

    public void AddPosition(Position position){
        positions.add(position);
        this.UpdateDocumentSum();
    }

    public void UpdateDocumentSum(){
        int sum = 0;
        for (Position position : this.getPositions()){
            sum += position.getSum();
        }
        this.setSum(sum);
    }
}

