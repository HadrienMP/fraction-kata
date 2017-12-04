package fr.hadrienmp.katas.fraction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FractionTest {
    @Test
    public void equals() throws Exception {
        assertThat(Fraction.of(1, 2)).isEqualTo(Fraction.of(1, 2));
    }

    @Test
    public void a_negative_numerator_or_a_negative_denominator_should_not_matter() throws Exception {
        assertThat(Fraction.of(-1, 2)).isEqualTo(Fraction.of(1, -2));
    }

    @Test
    public void a_fraction_cannot_have_a_zero_denominator() throws Exception {
        assertThatThrownBy(() -> Fraction.of(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
