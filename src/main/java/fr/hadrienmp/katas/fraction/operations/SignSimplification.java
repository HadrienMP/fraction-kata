package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import fr.hadrienmp.katas.fraction.FractionProvider;

public class SignSimplification implements FractionProvider {
    private FractionProvider operation;

    public SignSimplification(FractionProvider operation) {
        this.operation = operation;
    }

    @Override
    public Fraction get() {
        Fraction fraction = operation.get();
        if (doubleNegative(fraction) || negationOnDenominator(fraction)) {
            return Fraction.of(-fraction.numerator, -fraction.denominator);
        } else {
            return fraction;
        }
    }

    private boolean doubleNegative(Fraction fraction) {
        return fraction.numerator < 0 && fraction.denominator < 0;
    }

    private boolean negationOnDenominator(Fraction fraction) {
        return fraction.numerator > 0 && fraction.denominator < 0;
    }
}
