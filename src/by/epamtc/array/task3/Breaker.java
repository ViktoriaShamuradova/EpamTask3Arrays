package by.epamtc.array.task3;

public class Breaker {

    public int hack(Lock lock) {
        int[] cells = lock.getCELLS();
        int iteration = 0;

        OUTER:
        for (int cell = 0; cell < 10; cell++) {
            if (cells[cell] == 0) {

                Dice dice = new Dice(1);

                for (int frontFace = 2; frontFace <= 7; frontFace++) {
                    iteration++;
                    lock.insert(dice, cell);
                    if (lock.isOpen()) {
                        break OUTER;
                    }
                    dice.setFrontFaceValue(frontFace);

                }
            }
        }
        return iteration;
    }
}
