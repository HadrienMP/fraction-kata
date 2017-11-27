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
        for (int divisor = 2; divisor <= numerator(); divisor++) {
            simplifyBy(divisor);
        }
    }

    private void simplifyBy(int divisor) {
        while (simplifiableBy(divisor)) {
            reduceOnceBy(divisor);
        }
    }

    private boolean simplifiableBy(int divisor) {
        return numerator() % divisor == 0 && denominator() % divisor == 0;
    }

    private void reduceOnceBy(int divisor) {
        fraction = new RawFraction(numerator() / divisor, denominator() / divisor);
    }

    public int numerator() {
        return fraction.numerator();
    }

    public int denominator() {
        return fraction.denominator();
    }

    public Fraction plus(Fraction other) {
        return new ReducedFraction(fraction.plus(other));
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}
