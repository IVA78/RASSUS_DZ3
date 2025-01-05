package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.ReadingDTO;
import hr.fer.tel.rassus.server.beans.ReadingTransferDTO;
import hr.fer.tel.rassus.server.repository.ReadingRepository;
import hr.fer.tel.rassus.server.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReadingService {

    @Autowired
    ReadingRepository readingRepository;

    public ReadingTransferDTO generateAndSaveReading() {

        ReadingDTO newReading = Utils.parseReading();

        try {
            readingRepository.save(newReading);
            ReadingTransferDTO newTransferReading = new ReadingTransferDTO("Humidity", "%", newReading.getHumidity());

            return newTransferReading;
        } catch(Exception e) {
            return null;
        }
    }

}
