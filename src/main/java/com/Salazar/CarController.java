package com.Salazar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @Autowired
    private CsvService csvService;

    @GetMapping("/")
    public String viewCars(Model model) {
        model.addAttribute("cars", csvService.loadCars());
        return "cars";
    }

    @GetMapping("/add")
    public String addCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "form";
    }

    @PostMapping("/add")
    public String saveCar(@ModelAttribute Car car) {
        csvService.saveCar(car);
        return "redirect:/";
    }
}
