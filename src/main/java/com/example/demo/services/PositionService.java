package com.example.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Document;
import com.example.demo.models.Position;
import com.example.demo.repositories.DocumentRepository;
import com.example.demo.repositories.PositionsRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionService {
        private final DocumentRepository documentRepository;
        private final PositionsRepository positionRepository;

        @Transactional
        public ResponseEntity<?> createPosition(Long document_id, Position new_position){
            Document document = documentRepository.findById(document_id).orElse(null);
            
            if (document != null) {
                Position position = new Position();
                position.setName(new_position.getName());
                position.setPosition_number(new_position.getPosition_number());
                position.setSum(new_position.getSum());
                position.setDocument(document);

                position = positionRepository.save(position);

                document.AddPosition(position);
                // document.getPositions().add(position);
                documentRepository.save(document);

                log.info("created position {} for document {}", position.getId(), document_id);
                return ResponseEntity.ok(String.format("Position %s created", position.getName()));
            }else{
                return ResponseEntity.badRequest().body("No such document.");
            }
        }

        public ResponseEntity<?> updatePosition(Long position_id, Position new_position){
            Position position = positionRepository.findById(position_id).get();
            Document document = position.getDocument();

            if (document != null){
                if (new_position.getName() != null){
                    position.setName(new_position.getName());
                }
                if (new_position.getPosition_number() != null){
                    position.setPosition_number(new_position.getPosition_number());
                }
                position.setSum(new_position.getSum());

                positionRepository.save(position);
                document.UpdateDocumentSum();
                documentRepository.save(document);
                log.info("Position {} updated", position_id);
                return ResponseEntity.ok("Position updated.");
            } else{
                return ResponseEntity.badRequest().body("No such position or document.");
            }
        }

        public ResponseEntity<?> deletePosition(Long position_id){
            Position position = positionRepository.findById(position_id).orElse(null);
            Document document = position.getDocument();

            document.getPositions().remove(position);
            document.UpdateDocumentSum();
            positionRepository.delete(position);

            log.info("Position {} deleted", position_id);
            return ResponseEntity.ok("Position deleted");
        }
}
