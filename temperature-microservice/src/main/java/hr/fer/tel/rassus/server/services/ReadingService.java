package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.ReadingDTO;
import hr.fer.tel.rassus.server.beans.ReadingTransferDTO;
import hr.fer.tel.rassus.server.repository.ReadingRepository;
import hr.fer.tel.rassus.server.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    public ReadingTransferDTO generateAndSaveReading() {

        ReadingDTO newReading = Utils.parseReading();

        try {
            readingRepository.save(newReading);

            //generiranje mjerne jedinice
            //Random random = new Random();
            //String unit = random.nextBoolean() ? "C" : "K";

            ReadingTransferDTO newTransferReading = new ReadingTransferDTO("Temperature", "C", newReading.getTemperature());

            return newTransferReading;
        } catch(Exception e) {
            return null;
        }
    }

    public List<ReadingDTO> getAllReadings() {

        List<ReadingDTO> readingDTOList = readingRepository.findAll();
        readingRepository.findAll();

        return readingDTOList;

    }

}
