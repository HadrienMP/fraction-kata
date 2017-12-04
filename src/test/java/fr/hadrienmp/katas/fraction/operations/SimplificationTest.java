package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SimplificationTest {

    @Test
    public void should_not_simplify_fractions_integers()throws Exception {
        Assertions.assertThat(Fraction.of(1)).isEqualTo(Fraction.of(1));
    }

    @Test
    @Parameters(method = "unsimplifiableFractions")
    public void should_not_simplify_the_fraction_when_the_numerator_and_denominator_do_not_share_a_divisor(Fraction fraction)throws Exception {
        assertThat(fraction).isEqualTo(fraction);
    }

    public List<Fraction> unsimplifiableFractions() {
        return asList(
                Fraction.of(1, 2),
                Fraction.of(3, 4),
                Fraction.of(6, 7)
        );
    }

    @Test
    @Parameters(method = "simplifiableFractions")
    public void simplification(Fraction complicated, Fraction simplified)throws Exception {
        assertThat(complicated).isEqualTo(simplified);
    }

    public List<? extends List<? extends Fraction>> simplifiableFractions() {
        return asList(
            asList(Fraction.of(2, 4), Fraction.of(1, 2)),
            asList(Fraction.of(4, 8), Fraction.of(1, 2)),
            asList(Fraction.of(6, 3), Fraction.of(2)),
            asList(Fraction.of(3, 6), Fraction.of(1, 2)),
            asList(Fraction.of(5, 10), Fraction.of(1, 2))
        );
    }

    @Test
    public void hard_simplification()throws Exception {
        assertThat(Fraction.of(32, 48)).isEqualTo(Fraction.of(2, 3));
    }

    @Test
    public void a_negative_numerator_and_denominator_simplifies_into_a_positive_fraction() throws Exception {
        assertThat(Fraction.of(-1, -2)).isEqualTo(Fraction.of(1, 2));
    }
}