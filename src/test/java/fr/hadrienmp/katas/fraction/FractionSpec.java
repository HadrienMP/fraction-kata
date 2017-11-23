package fr.hadrienmp.katas.fraction;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(JUnitParamsRunner.class)
public class FractionSpec {

    @Test
    public void the_same_two_fractions_should_be_equal() throws Exception {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction).isEqualTo(new Fraction(1, 2));
    }

    @Test
    public void two_different_fractions_should_not_be_equal() throws Exception {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction).isNotEqualTo(new Fraction(1, 3));
    }

    @Test
    public void a_fraction_cannot_have_a_0_denominator() throws Exception {
        assertThatThrownBy(() -> new Fraction(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A fraction cannot have a 0 denominator");
    }

    @Test
    public void the_fraction_should_have_a_readable_string_representation() throws Exception {
        Fraction fraction = new Fraction(1, 2);
        String representation = fraction.toString();
        assertThat(representation).isEqualTo("1/2");
    }

    @Test
    public void the_denominator_should_be_the_representation_for_a_fraction_with_a_denominator_of_1() throws Exception {
        Fraction fraction = new Fraction(3, 1);
        String representation = fraction.toString();
        assertThat(representation).isEqualTo("3");
    }

    // Property ?
    @Test
    @Ignore
    public void should_be_able_to_create_a_fraction_from_its_representation() throws Exception {
        Fraction expected = new Fraction(1, 2);
        Fraction actual = new Fraction(expected.toString());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @Parameters({
            "2/4 | 1/2"
    })
    @Ignore
    public void a_fraction_should_be_simplified_when_possible() throws Exception {
        Fraction fraction = new Fraction(2, 4);
        assertThat(fraction).isEqualTo(new Fraction(1, 2));
    }
}
