package fr.hadrienmp.katas.fraction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class ReducedFraction implements Fraction {

    private Fraction fraction;

    ReducedFraction(Fraction fraction) {
        this.fraction = fraction;
        reduce();
    }

    private void reduce() {
        normalizeSign();
        for (int divisor = 2; divisor <= fraction.numerator(); divisor++) {
            reduceBy(divisor);
        }
    }

    private void normalizeSign() {
        boolean doubleNegative = fraction.numerator() < 0 && fraction.denominator() < 0;
        boolean megativeDenominator = fraction.numerator() > 0 && fraction.denominator() < 0;
        if (doubleNegative || megativeDenominator) {
            reduceOnceBy(-1);
        }
    }

    private void reduceBy(int divisor) {
        while (reduceableBy(divisor)) {
            reduceOnceBy(divisor);
        }
    }

    private boolean reduceableBy(int divisor) {
        return fraction.numerator() % divisor == 0 && fraction.denominator() % divisor == 0;
    }

    private void reduceOnceBy(int divisor) {
        fraction = new RawFraction(fraction.numerator() / divisor, fraction.denominator() / divisor);
    }


    @Override
    public Fraction plus(Fraction other) {
        return new ReducedFraction(fraction.plus(other));
    }

    @Override
    public Fraction minus(Fraction other) {
        return new ReducedFraction(fraction.minus(other));
    }

    @Override
    public String toString() {
        return fraction.toString();
    }

    @Override
    public int numerator() {
        return fraction.numerator();
    }

    @Override
    public int denominator() {
        return fraction.denominator();
    }
}
