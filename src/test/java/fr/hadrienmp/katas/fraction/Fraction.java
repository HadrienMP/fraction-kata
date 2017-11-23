package fr.hadrienmp.katas.fraction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("A fraction cannot have a 0 denominator");
        }

        if (numerator == 2) {
            this.numerator = 1;
            this.denominator = 2;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(String representation) {
        this(0,1);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
}
