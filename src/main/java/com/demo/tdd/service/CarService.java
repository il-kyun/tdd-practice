package com.demo.tdd.service;

import com.demo.tdd.CarNotFoundException;
import com.demo.tdd.domain.Car;
import com.demo.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if(Objects.isNull(car)){
            throw new CarNotFoundException();
        }
        return car;
    }
}
