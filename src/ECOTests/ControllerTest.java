package ECOTests;


import ECO.Controladores.PessoaController;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    PessoaController c;

    @BeforeEach
    void setup(){
       c = new PessoaController();
    }

    @org.junit.jupiter.api.Test
    void cadastrarPessoa() {
    }

    @org.junit.jupiter.api.Test
    void cadastrarPessoa1() {
    }

    @org.junit.jupiter.api.Test
    void cadastrarDeputado() {
    }

    @org.junit.jupiter.api.Test
    void exibirPessoa() {
    }

    @org.junit.jupiter.api.Test
    void cadastraPartido() {
        assertThrows(IllegalArgumentException.class, () -> c.cadastraPartido(null));
        assertThrows(IllegalArgumentException.class, () -> c.cadastraPartido(""));
        assertDoesNotThrow(() -> c.cadastraPartido("abacaba"));
        assertDoesNotThrow(() -> c.cadastraPartido("ashj"));
    }

    @org.junit.jupiter.api.Test
    void exibirBase() {
        assertEquals(c.exibirBase(), "");
        c.cadastraPartido("pt");
        assertEquals(c.exibirBase(), "pt");
        c.cadastraPartido("psdb");
        assertEquals(c.exibirBase(), "psdb,pt");
    }
}