package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;

public class SignSimplification implements Operation {
    private Operation operation;

    public SignSimplification(Operation operation) {
        this.operation = operation;
    }

    @Override
    public Fraction result() {
        Fraction fraction = operation.result();
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
