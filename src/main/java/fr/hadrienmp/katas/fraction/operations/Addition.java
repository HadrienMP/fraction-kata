package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import fr.hadrienmp.katas.fraction.FractionProvider;

public class Addition implements FractionProvider {

    private final FractionProvider first;
    private final FractionProvider second;

    public Addition(FractionProvider first, FractionProvider second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Fraction get() {
        return add(first.get(), second.get());
    }

    private static Fraction add(Fraction first, Fraction second) {
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
