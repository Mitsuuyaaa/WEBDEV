package com.Salazar.Service;

import com.Salazar.Class.Car;
import com.Salazar.DTO.CarDTO;
import com.Salazar.Repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(CarDTO carDTO) {
        Car car = new Car();
        car.setMake(carDTO.getMake());
        car.setYear(carDTO.getYear());
        car.setModel(carDTO.getModel());
        car.setLicensePlateNumber(carDTO.getLicensePlateNumber());
        car.setColor(carDTO.getColor());

        carRepository.save(car);
    }
}