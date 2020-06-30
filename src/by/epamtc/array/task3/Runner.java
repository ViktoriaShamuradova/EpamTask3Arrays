package by.epamtc.array.task3;

import java.util.Random;


public class Runner {
    public static void main(String[] args) {

        Lock lock = new Lock();
        randomInsert(lock);
        System.out.println(lock);
        Breaker breaker = new Breaker();
        int iteration = breaker.hack(lock);
        System.out.println(iteration);
        System.out.println(lock);

    }

    public static void randomInsert(Lock lock) {
        Random random = new Random();

        int i = 1;
        while (i < 3) {
            Dice dice = new Dice(1 + random.nextInt(6));
            int cell = random.nextInt(9);
            lock.insert(dice, cell);
            i++;
        }
    }
}
