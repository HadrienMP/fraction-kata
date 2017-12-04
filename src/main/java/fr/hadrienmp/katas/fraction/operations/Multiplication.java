package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import fr.hadrienmp.katas.fraction.FractionProvider;

public class Multiplication implements FractionProvider {
    private final FractionProvider first;
    private final FractionProvider second;

    public Multiplication(FractionProvider first, FractionProvider second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public Fraction get() {
        return multiply(first.get(), second.get());
    }

    private Fraction multiply(Fraction first, Fraction second) {
        return Fraction.of(first.numerator * second.numerator, first.denominator * second.denominator);
    }
}
