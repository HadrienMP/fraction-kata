package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;

public class Simplification implements Operation {

    private Fraction fraction;

    public Simplification(Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public Fraction result() {
        return simplify(fraction);
    }

    private static Fraction simplify(Fraction fraction) {
        for (int divisor = 2; divisor <= fraction.numerator; divisor++) {
            fraction = simplifyBy(fraction, divisor);
        }
        return fraction;
    }

    private static Fraction simplifyBy(Fraction fraction, int divisor) {
        while (simplifiableBy(fraction, divisor)) {
            fraction = simplifyOnceBy(fraction, divisor);
        }
        return fraction;
    }

    private static boolean simplifiableBy(Fraction fraction, int divisor) {
        return fraction.numerator % divisor == 0 && fraction.denominator % divisor == 0;
    }

    private static Fraction simplifyOnceBy(Fraction fraction, int divisor) {
        return Fraction.of(fraction.numerator / divisor, fraction.denominator / divisor);
    }
}
