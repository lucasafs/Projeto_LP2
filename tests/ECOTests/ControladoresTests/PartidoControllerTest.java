package ECOTests.ControladoresTests;

import ECO.Controladores.PartidoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidoControllerTest {

    PartidoController p;

    @BeforeEach
    void setUp() {
        p = new PartidoController();
    }

    @Test
    void cadastraPartido() {
        p.cadastraPartido("PT");
        p.cadastraPartido("PSDB");
    }

    @Test
    void exibirBase() {
        assertEquals("", p.exibirBase());
        p.cadastraPartido("PT");
        p.cadastraPartido("PSDB");
        assertEquals("PSDB,PT", p.exibirBase());
    }

    @Test
    void contemPartido() {
        assertEquals(false, p.contemPartido("PT"));
        p.cadastraPartido("PT");
        assertEquals(true, p.contemPartido("PT"));
        assertEquals(false, p.contemPartido("PCdoB"));
    }
}