package hr.fer.tel.rassus.server.controllers;


import hr.fer.tel.rassus.server.beans.ReadingReceivedDTO;
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
    private ResponseEntity<List<ReadingReceivedDTO>> getReading() {

        List<ReadingReceivedDTO> readingReceivedDTOList = readingService.aggregateReadings();


        if (readingReceivedDTOList != null) {
            return ResponseEntity.ok(readingReceivedDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}