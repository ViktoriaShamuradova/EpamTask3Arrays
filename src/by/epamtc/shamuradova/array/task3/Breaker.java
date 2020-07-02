package by.epamtc.shamuradova.array.task3;

import java.util.Arrays;

public class Breaker {

    public int hack(Lock lock) {
        int[] cells = lock.getCELLS();
        int iteration = 0;
        int position = 0;

        //читаем,сколько вставленных кубиков, берем их за истину
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] != 0) {
                position++;
            }
        }
        int[] positions = new int[position];

        //сохраняем индексы этих позиций, чтобы при прокрутке кубиков их не трогать
        int shift = 0;
        for (int index = 0; index < cells.length; index++) {
            if (cells[index] != 0) {
                positions[shift] = index;
                shift++;
            }
        }
        //вставляем в кубики в пустые ячейким
        for (int positionOfLock = 0; positionOfLock < cells.length; positionOfLock++) {
            if (isDiceInserted(positionOfLock, positions)) {
                continue;
            }
            lock.insert(new Dice(1), positionOfLock);
        }

        OUTER:
        for (int positionOfLock = 0; positionOfLock < cells.length; positionOfLock++) {
            //проверяем можно ли вертеть этот кубик
            if (isDiceInserted(positionOfLock, positions)) {
                continue;
            }
            for (int frontFace = 1; frontFace <= Dice.getSideCount(); frontFace++) {
                cells[positionOfLock] = frontFace;

                for (int positionOfLock2 = positionOfLock+1; positionOfLock2 < cells.length - 1; positionOfLock2++) { //i

                    //проверяем можно ли вертеть этот кубик
                    if (isDiceInserted(positionOfLock2, positions)) {
                        continue;
                    }


                    for (int frontFace2 = 1; frontFace2 <= Dice.getSideCount(); frontFace2++) { //j
                        cells[positionOfLock2] = frontFace2;

                        for (int nextPosition2 = positionOfLock2 + 1; nextPosition2 < cells.length; nextPosition2++) { //k

                            //проверяем можно ли вертеть этот кубик
                            if (isDiceInserted(nextPosition2, positions)) {
                                continue;
                            }

                            for (int nextFrontFace = 1; nextFrontFace <= Dice.getSideCount(); nextFrontFace++) { //h
                                iteration++;
                                cells[nextPosition2] = nextFrontFace;
                                System.out.println(Arrays.toString(cells));
                                if(lock.isOpen()){
                                    break OUTER;
                                }

                            }
                            cells[nextPosition2] = frontFace;

                        }
                    }
               }
                cells[positionOfLock] = frontFace;
            }


        }

        return iteration;
    }

    //проверяем можно ли вертеть этот кубик
    private static boolean isDiceInserted(int index, int[] positions) {
        boolean isDiceInserted = false;

        for (int i = 0; i < positions.length; i++) {
            if (index == positions[i]) {
                isDiceInserted = true;
            }
        }
        return isDiceInserted;
    }

}
