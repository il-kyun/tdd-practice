package com.demo.tdd.controller;

import com.demo.tdd.domain.Car;
import com.demo.tdd.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name){
        return carService.getCarDetails(name);
    }

}
