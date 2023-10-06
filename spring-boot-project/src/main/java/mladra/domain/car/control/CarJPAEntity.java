package mladra.domain.car.control;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CARS")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

}
