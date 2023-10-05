package mladra.domain.car.control;

import jakarta.persistence.*;

@Entity
@Table(name = "CARS")
class CarJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private int productionYear;

    @Column
    private int horsePower;

    @Column
    private String model;

    @Column
    private String brand;

    String getId() {
        return id;
    }

    int getProductionYear() {
        return productionYear;
    }

    int getHorsePower() {
        return horsePower;
    }

    String getModel() {
        return model;
    }

    String getBrand() {
        return brand;
    }
}
