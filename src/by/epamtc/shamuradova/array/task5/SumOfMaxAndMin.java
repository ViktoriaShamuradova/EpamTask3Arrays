package by.epamtc.shamuradova.array.task5;

public class SumOfMaxAndMin {

    public static int sumOfMaxAndMinElement(int[] array) {
        int max = array[1];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                if (array[i] < min) {
                    min = array[i];
                }
            } else {
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }
        return max + min;
    }

    public static void main(String[] args) {

        System.out.println(sumOfMaxAndMinElement(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
