package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Position;
import com.example.demo.services.PositionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PositionsController {
    private final PositionService positionService;

    @PostMapping("/document/{document_id}/createposition")
    public String addPositionToDocument(@PathVariable Long document_id, Position position){
        positionService.createPosition(document_id, position);
        return "redirect:/document/{document_id}";
    }

    @PostMapping("document/{document_id}/updateposition/{position_id}")
    public String updatePosition(@PathVariable Long position_id, String position_number, String name, int sum){
        positionService.updatePosition(position_id, position_number, name, sum);
        return "redirect:/document/{document_id}";
    }

    @PostMapping("document/{document_id}/deleteposition/{position_id}")
    public String deletePosition(@PathVariable Long position_id){
        positionService.deletePosition(position_id);
        return "redirect:/document/{document_id}";
    }
}
