package fr.hadrienmp.katas.fraction;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FractionSimplificationTest {

    @Test
    public void should_not_simplify_fractions_integers()throws Exception {
        assertThat(frac(1)).isEqualTo(frac(1));
    }

    @Test
    @Parameters(method = "unsimplifiableFractions")
    public void should_not_simplify_the_fraction_when_the_numerator_and_denominator_do_not_share_a_divisor(Addable fraction)throws Exception {
        assertThat(fraction).isEqualTo(fraction);
    }

    public List<? extends Addable> unsimplifiableFractions() {
        return asList(
                frac(1, 2),
                frac(3,4),
                frac(6,7)
        );
    }

    @Test
    @Parameters(method = "simplifiedFractions")
    public void simplification(Fraction complicated, Fraction simplified)throws Exception {
        assertThat(complicated).isEqualTo(simplified);
    }

    public List<? extends List<? extends Fraction>> simplifiedFractions() {
        return asList(
            asList(frac(2,4), frac(1,2)),
            asList(frac(4,8), frac(1,2)),
            asList(frac(6,3), frac(2)),
            asList(frac(3,6), frac(1, 2))
        );
    }

    @Test
    @Ignore
    public void hard_simplification()throws Exception {
        Fraction first = frac(5, 12);
        Fraction second = frac(1, 4);

        Fraction sum = first.plus(second);

        assertThat(sum).isEqualTo(frac(2,3));
    }


    private static Fraction frac(int value) {
        return new Fraction(value);
    }
    private static Fraction frac(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }
}
