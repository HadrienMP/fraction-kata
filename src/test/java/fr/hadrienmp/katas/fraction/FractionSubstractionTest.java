package fr.hadrienmp.katas.fraction;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FractionSubstractionTest {
    @Test
    public void substraction() throws Exception {
        Fraction result = Fraction.of(3, 4).minus(Fraction.of(1, 4));
        Assertions.assertThat(result).isEqualTo(Fraction.of(1,2));
    }

    @Test
    public void substraction_to_negative_number() throws Exception {
        Fraction result = Fraction.of(1, 4).minus(Fraction.of(3, 4));
        Assertions.assertThat(result).isEqualTo(Fraction.of(-2,4));
    }
}
