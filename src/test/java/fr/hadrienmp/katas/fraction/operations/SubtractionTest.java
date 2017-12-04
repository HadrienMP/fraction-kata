package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SubtractionTest {
    @Test
    public void substraction() throws Exception {
        Fraction result = new Subtraction(Fraction.of(3, 4), Fraction.of(2, 4)).get();
        Assertions.assertThat(result).isEqualTo(Fraction.of(1,4));
    }

    @Test
    public void substraction_to_negative_number() throws Exception {
        Fraction result = new Subtraction(Fraction.of(1, 4), Fraction.of(3, 4)).get();
        Assertions.assertThat(result).isEqualTo(Fraction.of(-2,4));
    }
}
