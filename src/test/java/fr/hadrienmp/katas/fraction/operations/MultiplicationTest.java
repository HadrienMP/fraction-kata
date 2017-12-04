package fr.hadrienmp.katas.fraction.operations;

import fr.hadrienmp.katas.fraction.Fraction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    // TODO gérer la composition d'opérations

    @Test
    public void multiply_integers() throws Exception {
        Fraction result = Fraction.of(2).times(Fraction.of(3));
        assertThat(result).isEqualTo(Fraction.of(2*3));
    }

    @Test
    public void multiply_fractions() throws Exception {
        Fraction result = Fraction.of(2,3).times(Fraction.of(4,5));
        assertThat(result).isEqualTo(Fraction.of(2*4, 3*5));
    }
}
