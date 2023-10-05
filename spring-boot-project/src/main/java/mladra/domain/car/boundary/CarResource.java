package mladra.domain.car.boundary;

import mladra.domain.car.control.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
