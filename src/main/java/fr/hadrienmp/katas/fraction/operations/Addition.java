package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;

public class Addition implements Operation {
    private final Fraction first;
    private final Fraction second;

    public Addition(Fraction first, Fraction second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Fraction result() {
        if (first.denominator == second.denominator) {
            int numerator = first.numerator + second.numerator;
            int denominator = first.denominator;
            return Fraction.of(numerator, denominator);
        } else {
            int numerator = first.numerator * second.denominator + second.numerator * first.denominator;
            int denominator = second.denominator * first.denominator;
            return Fraction.of(numerator, denominator);
        }
    }
}
