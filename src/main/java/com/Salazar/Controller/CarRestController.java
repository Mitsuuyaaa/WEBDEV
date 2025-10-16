package com.Salazar.Controller;

import com.Salazar.Class.Car;
import com.Salazar.DTO.CarDTO;
import com.Salazar.Service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    // Get all cars
    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.findAll();
    }

    // Create new car
    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@Valid @RequestBody CarDTO carDTO) {
        return carService.save(carDTO);
    }

    // Update car
    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable int id, @Valid @RequestBody CarDTO carDTO) {
        Car existingCar = carService.findById(id);
        if (existingCar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID " + id + " not found.");
        }
        return carService.updateCar(existingCar, carDTO);
    }

    // Delete car
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable int id) {
        Car existingCar = carService.findById(id);
        if (existingCar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID " + id + " not found.");
        }
        carService.deleteCar(id);
    }
}
