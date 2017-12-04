package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import fr.hadrienmp.katas.fraction.FractionProvider;

public class Minus implements FractionProvider {
    private FractionProvider fraction;

    public Minus(FractionProvider fraction) {
        this.fraction = fraction;
    }

    @Override
    public Fraction get() {
        Fraction fraction = this.fraction.get();
        return Fraction.of(-fraction.numerator, fraction.denominator);
    }
}
