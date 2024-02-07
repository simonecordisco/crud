package co.crud.democrud.controllers;

import co.crud.democrud.enities.Car;
import co.crud.democrud.repositories.CarRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car")
public class CarController {
    // Create C.

    @Autowired
    private CarRepositories carRepositories;
    @PostMapping
    public Car create(@RequestBody Car car){
         Car carSaved = carRepositories.save(car);
         return  carSaved;
    }
    @GetMapping("/getallcar")
    public List<Car> getCar(){
        List<Car> cars = carRepositories.findAll();
        return cars;
    }
    @GetMapping("getsingle/{id}")
    public Car getSingle(@PathVariable long id ){
        Car car = carRepositories.getReferenceById(id);
        return car;
    }
    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        if (!carRepositories.existsById(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        carRepositories.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/updateCarModel/{id}")
    public ResponseEntity<Car> updateCarModel(@PathVariable Long id, @RequestParam String model) {
        if (!carRepositories.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Car car = carRepositories.findById(id).get();
        car.setModel(model);
        Car updatedCar = carRepositories.save(car);
        return ResponseEntity.ok(updatedCar);
    }
    @DeleteMapping("/deleteAllCars")
    public ResponseEntity<Void> deleteAllCars() {
        carRepositories.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
