package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;

public class Subtraction implements Operation {
    private final Addition addition;

    public Subtraction(Fraction first, Fraction second) {
        Fraction minusSecond = Fraction.of(-second.numerator, second.denominator);
        addition = new Addition(first, minusSecond);
    }

    @Override
    public Fraction result() {
        return addition.result();
    }
}
