package by.epamtc.array.task2;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        int[] withoutMin = ArrayWithoutMin.arrayWithoutMinElements(new int[]{1, 2, 1, 5, 1, 6});
        System.out.println(Arrays.toString(withoutMin));

    }
}
