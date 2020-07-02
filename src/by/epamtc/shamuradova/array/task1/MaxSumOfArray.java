package by.epamtc.shamuradova.array.task1;

public class MaxSumOfArray {

    public static double findMaxSum(double[] array) {
        if (array != null) {
            double maxSum = sumOfTwoElements(array[0], array[array.length - 1]);
            for (int i = 1; i < array.length / 2; i++) {
                double sum = sumOfTwoElements(array[i], array[array.length - 1 - i]);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            return maxSum;
        } else return -1;
    }

    private static double sumOfTwoElements(double firstElement, double secondElement) {
        return firstElement + secondElement;
    }


}
