package training.algorithms.weight_point;

public final class WeightPointFactory {

    public static WeightPoint naive() {
        return new WeightPointNaive();
    }

    public static WeightPoint naiveV2() {
        return new WeightPointNaiveV2();
    }

    public static WeightPoint divideAndConquer() {
        return new WeightPointDivideAndConquer();
    }

}
