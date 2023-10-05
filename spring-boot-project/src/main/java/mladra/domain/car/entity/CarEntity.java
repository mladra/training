package mladra.domain.car.entity;

import java.util.Objects;

public class CarEntity {

    private final String id;
    private final String brand;
    private final String model;
    private final int productionYear;
    private final int horsePower;

    public CarEntity(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.productionYear = builder.productionYear;
        this.horsePower = builder.horsePower;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String brand;
        private String model;
        private int productionYear;
        private int horsePower;

        private Builder() {

        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder productionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public CarEntity build() {
            Objects.requireNonNull(id, "ID cannot be null");
            Objects.requireNonNull(brand, "Brand cannot be null");
            Objects.requireNonNull(model, "Model cannot be null");
            return new CarEntity(this);
        }
    }
}
