package fr.hadrienmp.katas.fraction;

interface Fraction extends Addable<Fraction> {

    int numerator();
    int denominator();

    static ReducedFraction of(int value) {
        return new ReducedFraction(new RawFraction(value, 1));
    }

    static ReducedFraction of(int numerator, int denominator) {
        return new ReducedFraction(new RawFraction(numerator, denominator));
    }
}
