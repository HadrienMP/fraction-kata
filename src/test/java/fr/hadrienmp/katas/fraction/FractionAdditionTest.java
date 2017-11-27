package fr.hadrienmp.katas.fraction;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class FractionAdditionTest {

    @Test
    @Parameters({
            "0,0,0",
            "1,0,1",
            "0,1,1",
            "1,2,3"
    })
    public void adding_integers(int first, int second, int expected)throws Exception {
        Fraction sum = Fraction.of(first).plus(Fraction.of(second));
        assertThat(sum).isEqualTo(Fraction.of(expected));
    }

    @Test
    public void adding_with_the_same_denominator()throws Exception {
        Fraction sum = Fraction.of(2,2).plus(Fraction.of(1,2));
        assertThat(sum).isEqualTo(Fraction.of(3,2));
    }

    @Test
    public void adding_a_fraction_with_an_integer()throws Exception {
        Fraction first = Fraction.of(1);
        Fraction second = Fraction.of(1, 2);

        Fraction sum = first.plus(second);

        assertThat(sum).isEqualTo(Fraction.of(3,2));
    }

    @Test
    public void adding_with_different_denominators()throws Exception {
        Fraction first = Fraction.of(1, 3);
        Fraction second = Fraction.of(1, 2);

        Fraction sum = first.plus(second);

        assertThat(sum).isEqualTo(Fraction.of(5,6));
    }

}
