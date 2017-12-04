package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    @Test
    public void multiply_integers() throws Exception {
        Fraction first = Fraction.of(2);
        Fraction second = Fraction.of(3);

        Fraction result = new Multiplication(first, second).get();

        assertThat(result).isEqualTo(Fraction.of(2*3));
    }

    @Test
    public void multiply_fractions() throws Exception {
        Fraction first = Fraction.of(2, 3);
        Fraction second = Fraction.of(4, 5);

        Fraction result = new Multiplication(first, second).get();

        assertThat(result).isEqualTo(Fraction.of(2*4, 3*5));
    }
}
