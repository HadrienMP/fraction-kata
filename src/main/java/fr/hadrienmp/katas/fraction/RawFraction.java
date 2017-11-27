package fr.hadrienmp.katas.fraction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
class RawFraction implements Fraction {
    private final int numerator;
    private final int denominator;

    public RawFraction(int value) {
        this(value, 1);
    }

    public int numerator() {
        return numerator;
    }

    public int denominator() {
        return denominator;
    }
    
    @Override
    public Fraction plus(Fraction other) {
        if (denominator == other.denominator()) {
            return new RawFraction(numerator + other.numerator(), denominator);
        } else {
            int numerator = this.numerator * other.denominator() + other.numerator() * denominator;
            int denominator = other.denominator() * this.denominator;
            return new RawFraction(numerator, denominator);
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
