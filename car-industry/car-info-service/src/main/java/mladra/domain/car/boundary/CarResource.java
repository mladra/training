package mladra.domain.car.boundary;

import mladra.domain.car.control.CarService;
import mladra.domain.car.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarResource {

    private final CarService service;

    @Autowired
    public CarResource(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCarById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createCar(@RequestBody CarEntity carEntity) {
        try {
            CarEntity entityWithNoId = carEntity.toBuilder().id(null).build();
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrUpdate(entityWithNoId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCar(@PathVariable String id, @RequestBody CarEntity carEntity) {
        try {
            CarEntity entityWithId = carEntity.toBuilder().id(id).build();
            return ResponseEntity.ok(service.createOrUpdate(entityWithId));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable String id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("Car with id " + id + " successfully deleted");
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
