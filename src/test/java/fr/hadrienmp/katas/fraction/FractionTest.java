package fr.hadrienmp.katas.fraction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {
    @Test
    public void a_negative_numerator_or_a_negative_denominator_should_not_matter() throws Exception {
        assertThat(Fraction.of(-1,2)).isEqualTo(Fraction.of(1, -2));
    }
}
