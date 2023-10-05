package mladra.domain.car.control;

import mladra.domain.car.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository repository;

    @Autowired
    CarService(CarRepository repository) {
        this.repository = repository;
    }

    public CarEntity getById(String id) {
        return repository.findById(id)
                .map(this::convertToEntity)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find car with id " + id));
    }

    private CarEntity convertToEntity(CarJPAEntity jpaEntity) {
        return CarEntity.builder()
                .id(jpaEntity.getId())
                .brand(jpaEntity.getBrand())
                .model(jpaEntity.getModel())
                .productionYear(jpaEntity.getProductionYear())
                .horsePower(jpaEntity.getHorsePower())
                .build();
    }
}
