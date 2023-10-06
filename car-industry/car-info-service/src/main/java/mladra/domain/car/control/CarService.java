package mladra.domain.car.control;

import mladra.domain.car.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CarEntity createOrUpdate(CarEntity entity) {
        entity.getId().ifPresent(this::checkIfCarExists);
        CarJPAEntity jpaEntity = convertToJpaEntity(entity);
        CarJPAEntity created = repository.save(jpaEntity);
        return convertToEntity(created);
    }

    @Transactional
    public void deleteById(String id) {
        checkIfCarExists(id);
        repository.deleteById(id);
    }

    private void checkIfCarExists(String id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Car with id " + id + " cannot be found");
        }
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

    private CarJPAEntity convertToJpaEntity(CarEntity entity) {
        return CarJPAEntity.builder()
                .id(entity.getId().orElse(null))
                .brand(entity.getBrand())
                .model(entity.getModel())
                .productionYear(entity.getProductionYear())
                .horsePower(entity.getHorsePower())
                .build();
    }
}
