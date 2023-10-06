package mladra.domain.car.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Builder(toBuilder = true)
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CarEntity {

    private final String id;
    private final String brand;
    private final String model;
    private final int productionYear;
    private final int horsePower;

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

}
