package ECOTests.ProjetoleiTests;

import ECO.PROJETOLEI.PL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PLTest {

    PL pl1;
    PL pl2;

    @BeforeEach
    void setUp() {
        pl1 = new PL("111111911-0", 2000, "codigo", "ementa", "futebol, parquedopovo", "http://123.com", true);
        pl2 = new PL("892182191-9", 2019, "atelobrob", "794-2", "ruas, passarelas", "onp.tom.musical", false);
    }

    @Test
    void exibirProjeto() {
        assertEquals("Projeto de Lei - codigo - 111111911-0 - ementa - Conclusiva - EM VOTACAO (CCJC)", pl1.exibirProjeto());
        pl1.setSituacao("testando");
        assertEquals("Projeto de Lei - codigo - 111111911-0 - ementa - Conclusiva - testando", pl1.exibirProjeto());

        assertEquals("Projeto de Lei - atelobrob - 892182191-9 - 794-2 - EM VOTACAO (CCJC)", pl2.exibirProjeto());
        pl2.setSituacao("testando");
        assertEquals("Projeto de Lei - atelobrob - 892182191-9 - 794-2 - testando", pl2.exibirProjeto());
    }

    @Test
    void isConclusiva() {
        assertEquals(true, pl1.isConclusiva());
        assertEquals(false, pl2.isConclusiva());
    }
}