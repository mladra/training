package training.algorithms.weight_point;

public interface WeightPoint {

    // Mamy na wejściu tablicę liczb i musimy zwrócić indeks elementu, który jest środkiem ciężkości
    // (suma elementów z lewej równa jest sumie elementów z prawej)
    // -> pivot jest wliczany do prawej części sumy
    int compute(int[] array);

}
