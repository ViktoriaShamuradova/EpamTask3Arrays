package by.epamtc.shamuradova.array.task3;

import java.util.Arrays;

public class Lock {

    private final int[] CELLS = new int[10];

    public int[] getCELLS() {
        return CELLS;
    }

    public void insert(Dice dice, int cell) {

        if (cell < 0 || cell > 9) throw new RuntimeException();
        CELLS[cell] = dice.getFrontFaceValue();
    }

    public boolean isOpen() {
        for (int i = 0; i < CELLS.length-2; i++) {
            if (CELLS[i] != 0 && CELLS[i + 1] != 0 && CELLS[i + 2] != 0) {
                if (CELLS[i] + CELLS[i + 1] + CELLS[i + 2] != 10) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lock lock = (Lock) o;
        return Arrays.equals(CELLS, lock.CELLS);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(CELLS);
    }


    @Override
    public String toString() {
        return "Lock{" +
                "CELLS=" + Arrays.toString(CELLS) +
                '}';
    }
}
