package com.example.demo.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Position;
import com.example.demo.services.PositionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PositionsController {
    private final PositionService positionService;

    @PostMapping("/document/{document_id}/createposition")
    public ResponseEntity<?> addPositionToDocument(@PathVariable Long document_id, @RequestBody Position position){
        return positionService.createPosition(document_id, position);
    }

    @PostMapping("document/{document_id}/updateposition/{position_id}")
    public ResponseEntity<?> updatePosition(@PathVariable Long position_id, @RequestBody Position position){
        return positionService.updatePosition(position_id, position);
    }

    @PostMapping("document/{document_id}/deleteposition/{position_id}")
    public ResponseEntity<?> deletePosition(@PathVariable Long position_id){
        return positionService.deletePosition(position_id);
    }
}
