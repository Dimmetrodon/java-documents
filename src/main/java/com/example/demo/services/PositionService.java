package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.Document;
import com.example.demo.models.Position;
import com.example.demo.repositories.DocumentRepository;
import com.example.demo.repositories.PositionsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionService {
        private final DocumentRepository documentRepository;
        private final PositionsRepository positionRepository;

        public void createPosition(Long document_id, Position position){
            Document document = documentRepository.findById(document_id).orElse(null);
            if (document != null) {
                position.setDocument(document);
                positionRepository.save(position);
                document.AddPosition(position);
                documentRepository.save(document);
                log.info("created position {} for document {}", position.getId(), document_id);
            }
        }

        public void updatePosition(Long position_id, String position_number, String name, int sum){
            Position position = positionRepository.findById(position_id).get();
            Document document = position.getDocument();
            if (document != null){
                if (name != null){
                    position.setName(name);
                }
                if (position_number != null){
                    position.setPosition_number(position_number);
                }
                position.setSum(sum);

                positionRepository.save(position);
                document.UpdateDocumentSum();
                documentRepository.save(document);
                log.info("Position {} updated", position_id);
            }
        }

        public void deletePosition(Long position_id){
            Position position = positionRepository.findById(position_id).get();
            Document document = position.getDocument();
            positionRepository.deleteById(position_id);
            document.UpdateDocumentSum();
            documentRepository.save(document);
            log.info("Position {} deleted", position_id);
        }
}
