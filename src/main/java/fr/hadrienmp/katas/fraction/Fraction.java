package fr.hadrienmp.katas.fraction;

import fr.hadrienmp.katas.fraction.operations.Multiplication;
import fr.hadrienmp.katas.fraction.operations.SignSimplification;
import fr.hadrienmp.katas.fraction.operations.Simplification;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Fraction {
    public final int numerator;
    public final int denominator;

    private Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException();
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction of(int value) {
        return Fraction.of(value, 1);
    }

    public static Fraction of(int numerator, int denominator) {
        return new SignSimplification(
                new Simplification(
                        new Fraction(numerator, denominator)))
                .result();
    }

    @Override
    public String toString() {
        String string = numerator + "";
        if (denominator != 1) {
            string += "/" + denominator;
        }
        return string;
    }

    public Fraction times(Fraction other) {
        return new Multiplication(this, other).result();
    }
}
