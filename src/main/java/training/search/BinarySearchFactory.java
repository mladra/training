package training.search;

public class BinarySearchFactory {

    public static BinarySearch iterative() {
        return new BinarySearchIterative();
    }

    public static BinarySearch recursive() {
        return new BinarySearchRecursive();
    }

}
