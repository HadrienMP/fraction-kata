package fr.hadrienmp.katas.fraction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class ReducedFraction implements Fraction {

    private Fraction fraction;

    ReducedFraction(Fraction fraction) {
        this.fraction = fraction;
        simplify();
    }

    private void simplify() {
        for (int divisor = 2; divisor <= fraction.numerator(); divisor++) {
            simplifyBy(divisor);
        }
    }

    private void simplifyBy(int divisor) {
        while (simplifiableBy(divisor)) {
            reduceOnceBy(divisor);
        }
    }

    private boolean simplifiableBy(int divisor) {
        return fraction.numerator() % divisor == 0 && fraction.denominator() % divisor == 0;
    }

    private void reduceOnceBy(int divisor) {
        fraction = new RawFraction(fraction.numerator() / divisor, fraction.denominator() / divisor);
    }

    public Fraction plus(Fraction other) {
        return new ReducedFraction(fraction.plus(other));
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
