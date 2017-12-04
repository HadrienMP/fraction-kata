package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import fr.hadrienmp.katas.fraction.FractionProvider;

public class Subtraction implements FractionProvider {
    private final Addition addition;

    public Subtraction(FractionProvider first, FractionProvider second) {
        addition = new Addition(first, new Minus(second));
    }

    @Override
    public Fraction get() {
        return addition.get();
    }
}
