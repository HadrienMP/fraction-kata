package fr.hadrienmp.katas.fraction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Fraction implements Addable<Fraction> {

    private final RawFraction rawFraction;

    @Data
    @AllArgsConstructor
    static class RawFraction {
        private int numerator;
        private int denominator;
    }

    public Fraction(int value) {
        this(value, 1);
    }

    public Fraction(int numerator, int denominator) {

        RawFraction rawFraction = new RawFraction();

        rawFraction = simplify(rawFraction);

        this.rawFraction = rawFraction;
    }

    private RawFraction simplify(RawFraction rawFraction) {
        RawFraction simplified = new RawFraction();
        if (rawFraction.numerator % rawFraction.denominator == 0) {
            rawFraction.numerator = rawFraction.numerator / rawFraction.denominator;
            rawFraction.denominator = 1;
        }

        while (rawFraction.numerator % 2 == 0 && rawFraction.denominator % 2 == 0) {
            rawFraction.numerator /= 2;
            rawFraction.denominator /= 2;
        }

        while (rawFraction.numerator % 3 == 0 && rawFraction.denominator % 3 == 0) {
            rawFraction.numerator /= 3;
            rawFraction.denominator /= 3;
        }
        return rawFraction;
    }

    public Fraction plus(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction(this.numerator + other.numerator, this.denominator);
        } else {
            int numerator = this.numerator * other.denominator + other.numerator * this.denominator;
            int denominator = other.denominator * this.denominator;
            return new Fraction(numerator, denominator);
        }
    }

    @Override
    public String toString() {
        String string = numerator + "";
        if (denominator != 1) {
            string += "/" + denominator;
        }
        return string;
    }
}
