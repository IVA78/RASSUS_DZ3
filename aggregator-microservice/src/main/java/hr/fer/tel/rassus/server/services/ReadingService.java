package hr.fer.tel.rassus.server.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.tel.rassus.server.beans.ReadingReceivedDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadingService {

    @Value("${temperature.service-url}")
    private String temperatureServiceUrl;

    @Value("${humidity.service-url}")
    private String humidityServiceUrl;

    @Value("${temperature.unit}")
    private String temperatureDefaultUnit;

    private static HttpClient client = HttpClient.newHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public List<ReadingReceivedDTO> aggregateReadings() {

        List<ReadingReceivedDTO> aggregatedReadings = new ArrayList<>();

        //slanje HTTP zahtjeva
        HttpRequest requestTemperature = HttpRequest.newBuilder()
                .uri(URI.create(temperatureServiceUrl))
                .header("Content-Type", "application/json")
                .GET().build();

        HttpRequest requestHumidity = HttpRequest.newBuilder()
                .uri(URI.create(humidityServiceUrl))
                .header("Content-Type", "application/json")
                .GET().build();

        try{
            HttpResponse<String> responseTemperature = client.send(requestTemperature, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> responseHumidity = client.send(requestHumidity, HttpResponse.BodyHandlers.ofString());


            ReadingReceivedDTO temperatureReading = objectMapper.readValue(responseTemperature.body(), ReadingReceivedDTO.class);
            ReadingReceivedDTO humidityReading = objectMapper.readValue(responseHumidity.body(), ReadingReceivedDTO.class);

            //pretvaranje u odgovarajucu mjernu jedinicu
            if(temperatureReading.getUnit().equals("C") && temperatureDefaultUnit.equals("K")){
                temperatureReading.setValue(temperatureReading.getValue() + 273.15);
                temperatureReading.setUnit("K");
            }

            if(temperatureReading.getUnit().equals("K") && temperatureDefaultUnit.equals("C")){
                temperatureReading.setValue(temperatureReading.getValue() - 273.15);
                temperatureReading.setUnit("C");
            }


            //dodavanje odgovora u listu
            aggregatedReadings.add(temperatureReading);
            aggregatedReadings.add(humidityReading);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }


        //vraćanje liste
        return aggregatedReadings;

    }
}
