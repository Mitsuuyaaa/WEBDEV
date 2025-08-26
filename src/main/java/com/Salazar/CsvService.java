package com.Salazar;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    private static final String FILE_NAME = "cars.csv";

    public void saveCar(Car car) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(String.join(",",
                    String.valueOf(car.getCarID()),
                    car.getLicensePlateNumber(),
                    car.getMake(),
                    car.getModel(),
                    String.valueOf(car.getYear()),
                    car.getColor(),
                    car.getBodyType(),
                    car.getEngineType(),
                    car.getTransmission()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    Car car = new Car();
                    car.setLicensePlateNumber(parts[1]);
                    car.setMake(parts[2]);
                    car.setModel(parts[3]);
                    car.setYear(Integer.parseInt(parts[4]));
                    car.setColor(parts[5]);
                    car.setBodyType(parts[6]);
                    car.setEngineType(parts[7]);
                    car.setTransmission(parts[8]);
                    cars.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
