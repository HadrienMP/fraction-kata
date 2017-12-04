package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AdditionTest {

    @Test
    @Parameters({
            "0,0,0",
            "1,0,1",
            "0,1,1",
            "1,2,3"
    })
    public void adding_integers(int first, int second, int expected) throws Exception {
        Fraction firstFraction = Fraction.of(first);
        Fraction secondFraction = Fraction.of(second);
        Fraction expectedFraction = Fraction.of(expected);

        Fraction sum = new Addition(firstFraction, secondFraction).result();
        assertThat(sum).isEqualTo(expectedFraction);
    }

    @Test
    public void adding_with_the_same_denominator() throws Exception {
        Fraction sum = new Addition(Fraction.of(2, 2), Fraction.of(1, 2)).result();
        assertThat(sum).isEqualTo(Fraction.of(3, 2));
    }

    @Test
    public void adding_a_fraction_with_an_integer() throws Exception {
        Fraction first = Fraction.of(1);
        Fraction second = Fraction.of(1, 2);

        Fraction sum = new Addition(first, second).result();

        assertThat(sum).isEqualTo(Fraction.of(3, 2));
    }

    @Test
    public void adding_with_different_denominators() throws Exception {
        Fraction first = Fraction.of(1, 3);
        Fraction second = Fraction.of(1, 2);

        Fraction sum = new Addition(first, second).result();

        assertThat(sum).isEqualTo(Fraction.of(5, 6));
    }

}
