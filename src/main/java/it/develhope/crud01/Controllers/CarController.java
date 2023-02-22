package it.develhope.crud01.Controllers;

import it.develhope.crud01.Entities.Car;
import it.develhope.crud01.Repositories.CarRepository;
import jakarta.persistence.Id;
import jakarta.servlet.annotation.HttpConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @PostMapping("")
    public Car createCar(@RequestBody Car car) {
        return carRepository.saveAndFlush(car);
    }

    @GetMapping
    public List<Car> get() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id) {
        if (carRepository.existsById(id)) {
            return carRepository.getReferenceById(id);
        } else {
            return new Car();
        }
    }

    @PutMapping("/{id}")
    public Car updateSingle(@PathVariable long id, @RequestBody Car car) {
        if (!carRepository.existsById(id)) {
            return new Car();
        } else {
            car.setId(id);
             return carRepository.saveAndFlush(car);
        }

    }


    @DeleteMapping("/{id}")
    public HttpStatus deleteSingle(@PathVariable long id) {
        if (!carRepository.existsById(id)) {
            return HttpStatus.CONFLICT;
        } else {
            carRepository.deleteById(id);
            return HttpStatus.ACCEPTED;
        }
    }

    @DeleteMapping
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
