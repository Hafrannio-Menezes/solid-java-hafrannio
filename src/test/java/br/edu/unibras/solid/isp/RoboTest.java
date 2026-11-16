package br.edu.unibras.solid.isp;

import br.edu.unibras.solid.isp.refatorado.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RoboTest {

    @Test
    void violacaoRoboForcadoAImplementarComer() {
        List<br.edu.unibras.solid.isp.violacao.Trabalhador> equipe = List.of(
                new br.edu.unibras.solid.isp.violacao.Humano(),
                new br.edu.unibras.solid.isp.violacao.Robo());
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> new br.edu.unibras.solid.isp.violacao.Refeitorio().servirAlmoco(equipe));
    }

    @Test
    void testRoboTrabalha() {
        Trabalhador r = new Robo();
        Assertions.assertDoesNotThrow(r::trabalhar);
    }

    @Test
    void roboNaoImplementaAlimentavel() {
        Assertions.assertFalse(Alimentavel.class.isAssignableFrom(Robo.class));
        Assertions.assertTrue(Alimentavel.class.isAssignableFrom(Humano.class));
    }

    @Test
    void refeitorioAtendeApenasAlimentaveis() {
        Assertions.assertEquals(2, new Refeitorio().servirAlmoco(List.of(new Humano(), new Humano())));
    }
}
