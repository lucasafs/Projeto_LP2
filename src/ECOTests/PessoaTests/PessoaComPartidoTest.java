package ECOTests.PessoaTests;

import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// ainda deve ser implementado, e necessario implementar os testes de Deputado antes de PessoaComPartido

class PessoaComPartidoTest {

    PessoaComPartido p1, p2, p3;
    @BeforeEach
    void setUp() {
        p1 = new PessoaComPartido("nome", "casa", "idk", "jajaja", "alo");
        p2 = new PessoaComPartido("eduardo", "999999999-0", "paraiba","praca,praia,ruas",  "PSDB");
        p3 = new PessoaComPartido("carlos", "111111111-0", "amapa", "", "PT");
    }

    @Test
    void cadastraDeputado() {
        assertEquals(p1.cadastraDeputado("12052013"), true);
    }

    @Test
    void getPartido() {

        assertEquals("alo", p1.getPartido());
    }

    @Test
    void exibirPessoa() {
        assertEquals("nome - casa (idk) - alo - Interesses: jajaja", p1.exibirPessoa());
        assertEquals("eduardo - 999999999-0 (paraiba) - PSDB - Interesses: praca,praia,ruas", p2.exibirPessoa());
    }

    @Test
    void toStringTest() {
        assertEquals("carlos - 111111111-0 (amapa) - PT", p3.toString());
        p3.cadastraDeputado("15052002");
        assertEquals("carlos - 111111111-0 (amapa) - PT - 15/05/2002 - 0 Leis", p3.toString());
        assertEquals("eduardo - 999999999-0 (paraiba) - PSDB - Interesses: praca,praia,ruas", p2.toString());
        p2.cadastraDeputado(("26082000"));
        assertEquals("eduardo - 999999999-0 (paraiba) - PSDB - Interesses: praca,praia,ruas - 26/08/2000 - 0 Leis", p2.toString());
    }
}