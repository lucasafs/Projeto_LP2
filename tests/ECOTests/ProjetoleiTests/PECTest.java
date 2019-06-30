package ECOTests.ProjetoleiTests;

import ECO.PROJETOLEI.PEC;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PECTest {

    PEC p1;

    @BeforeEach
    void setUp() {
        p1 = new PEC("111111911-0", 2000, "codigo", "ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca");
    }

    @Test
    void exibirProjeto() {
        assertEquals("Projeto de Emenda Constitucional - codigo - 111111911-0 - ementa - mariadapenha,  seca - EM VOTACAO (CCJC)", p1.exibirProjeto());
        p1.setSituacao("testando");
        assertEquals("Projeto de Emenda Constitucional - codigo - 111111911-0 - ementa - mariadapenha,  seca - testando", p1.exibirProjeto());
    }

    @Test
    void isConclusiva() {
        assertEquals(false, p1.isConclusiva());
    }
}