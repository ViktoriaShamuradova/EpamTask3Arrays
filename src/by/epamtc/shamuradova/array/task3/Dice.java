package by.epamtc.shamuradova.array.task3;


import java.util.Objects;

public class Dice {
    private int frontFaceValue;
    private static final int SIDE_COUNT = 6;

    public Dice(int frontFaceValue) {

        setFrontFaceValue(frontFaceValue);
    }


    private void setFrontFaceValue(int frontFaceValue) {
        if (frontFaceValue < 1 || frontFaceValue > 6) throw new RuntimeException();
        this.frontFaceValue = frontFaceValue;
    }

    public int getFrontFaceValue() {

        return frontFaceValue;
    }

    public static int getSideCount() {
        return SIDE_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return frontFaceValue == dice.frontFaceValue;
    }

    @Override
    public int hashCode() {

        return Objects.hash(frontFaceValue);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "frontFaceValue=" + frontFaceValue +
                '}';
    }
}

