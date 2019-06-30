package ECOTests.ProjetoleiTests;

import ECO.PROJETOLEI.PLP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PLPTest {

    PLP plp;

    @BeforeEach
    void setUp() {
        plp = new PLP("111111911-0", 2000, "codigo", "ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca");
    }

    @Test
    void exibirProjeto() {
        assertEquals("Projeto de Lei Complementar - codigo - 111111911-0 - ementa - mariadapenha,  seca - EM VOTACAO (CCJC)", plp.exibirProjeto());
        plp.setSituacao("testando");
        assertEquals("Projeto de Lei Complementar - codigo - 111111911-0 - ementa - mariadapenha,  seca - testando", plp.exibirProjeto());
    }

    @Test
    void isConclusiva() {
        assertEquals(false, plp.isConclusiva());
    }
}