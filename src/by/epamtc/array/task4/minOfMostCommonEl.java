package by.epamtc.array.task4;

public class minOfMostCommonEl {

    public static int getMinOfMostCommonElement(int[] array) {
        int res = 0;
        int[] counts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    count++;
            }
            counts[i] = count;
            if (counts[i] == counts[res])
                res = array[res] > array[i] ? i : res;
            else
                res = count > counts[res] ? i : res;
        }
        return array[res];
    }

    public static void main(String[] args) {
        int minOfMostCommonNumber = minOfMostCommonEl.getMinOfMostCommonElement(new int[]{1, 2, 3, 1, 5, 5, 6, 1, 5});
        System.out.println(minOfMostCommonNumber);

    }
}
