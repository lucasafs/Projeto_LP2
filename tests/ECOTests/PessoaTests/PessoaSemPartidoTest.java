package ECOTests.PessoaTests;

import ECO.PESSOA.PessoaSemPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaSemPartidoTest {

    PessoaSemPartido p1, p2;

    @BeforeEach
    void setup(){
        p1 = new PessoaSemPartido("joao", "181829191-0", "tocantins", "anime");
        p2 = new PessoaSemPartido("maria", "181829192-0", "tocantins", "");
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
        assertEquals("joao - 181829191-0 (tocantins) - Interesses: anime", p1.toString());
        assertEquals("maria - 181829192-0 (tocantins)", p2.toString());
    }
}