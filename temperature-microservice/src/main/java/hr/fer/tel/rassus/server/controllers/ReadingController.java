package hr.fer.tel.rassus.server.controllers;


import hr.fer.tel.rassus.server.beans.ReadingDTO;
import hr.fer.tel.rassus.server.beans.ReadingTransferDTO;
import hr.fer.tel.rassus.server.services.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reading")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @GetMapping("/get")
    private ResponseEntity<ReadingTransferDTO> getReading() {

        ReadingTransferDTO readingTransferDTO = readingService.generateAndSaveReading();

        if (readingTransferDTO != null) {
            return ResponseEntity.ok(readingTransferDTO);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<ReadingDTO>> getAllReadings() {

        List<ReadingDTO> readingTransferDTOList = readingService.getAllReadings();

        if (readingTransferDTOList != null) {
            return ResponseEntity.ok(readingTransferDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}