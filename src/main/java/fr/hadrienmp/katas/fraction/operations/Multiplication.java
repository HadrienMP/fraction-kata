package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;

public class Multiplication implements Operation {
    private final Fraction first;
    private final Fraction second;

    public Multiplication(Fraction first, Fraction second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Fraction result() {
        return Fraction.of(first.numerator * second.numerator, first.denominator * second.denominator);
    }
}
