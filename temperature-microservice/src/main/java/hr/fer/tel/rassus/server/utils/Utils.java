package hr.fer.tel.rassus.server.utils;


import hr.fer.tel.rassus.server.Application;
import hr.fer.tel.rassus.server.beans.ReadingDTO;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Utils {



    public static ReadingDTO parseReading() {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("/app/resources/readings.csv"));
        } catch (IOException e) {
            // Log the exception message for better debugging
            System.out.println("Failed to read CSV: " + e.getMessage());
            System.out.println("Path attempted: " + Paths.get("/app/resources/readings.csv").toAbsolutePath());
            e.printStackTrace();
        }




        Long elapsedTimeInNanos = System.nanoTime() - Application.getStartTime();
        Long elapsedTimeInSeconds = elapsedTimeInNanos / 1000000000;
        //Long red = (elapsedTimeInSeconds / 60  % 100) + 1;
        Long red = (elapsedTimeInSeconds % 100) + 1;
        String randomLine = lines.get(red.intValue());

        int cnt = 0;

        //parsiranje linije za ocitanje
        HashMap<String, String> readingValues = new HashMap<>();
        randomLine = randomLine + "$,";
        for (String s : randomLine.split(",")) {
            switch (cnt) {
                case 0:
                    readingValues.put("temperature", s == "" ? "" : s.trim());
                    break;
                case 1:
                    readingValues.put("pressure", s == "" ? "" : s.trim());
                    break;
                case 2:
                    readingValues.put("humidity", s == "" ? "" : s.trim());
                    break;
                case 3:
                    readingValues.put("co", s == "" ? "" : s.trim());
                    break;
                case 4:
                    readingValues.put("no2", s == "" ? "" : s.trim());
                    break;
                case 5:
                    readingValues.put("so2", s == "" ? "" : s.trim());
                    break;
                default:
                    break;
            }
            cnt++;
        }

        Double temperature = Double.parseDouble(readingValues.get("temperature"));
        Integer pressure = Integer.parseInt(readingValues.get("pressure"));
        Double humidity = Double.parseDouble(readingValues.get("humidity"));
        Integer co = readingValues.get("co") == "" ? 0 : Integer.parseInt(readingValues.get("co"));
        Integer no2 = readingValues.get("no2") == "" ? 0 : Integer.parseInt(readingValues.get("no2"));
        Integer so2 = readingValues.get("so2") == "" ? 0 : Integer.parseInt(readingValues.get("so2"));


        return new ReadingDTO(temperature, pressure, humidity, co, no2, so2);

    }

}