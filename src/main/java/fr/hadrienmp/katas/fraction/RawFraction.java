package fr.hadrienmp.katas.fraction;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class RawFraction implements Fraction {
    private final int numerator;
    private final int denominator;

    RawFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int numerator() {
        return numerator;
    }

    @Override
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
    public Fraction minus(Fraction other) {
        return this.plus(new RawFraction(-other.numerator(), other.denominator()));
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
