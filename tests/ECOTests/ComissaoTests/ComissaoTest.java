package ECOTests.ComissaoTests;

import ECO.COMISSAO.Comissao;
import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComissaoTest {

    Comissao c1;
    List<Pessoa> arr;

    @BeforeEach
    void setUp() {
        arr = new ArrayList<Pessoa>();
        arr.add(new PessoaComPartido("carlos", "111111111-0", "amapa", "", "PT"));
        arr.add(new PessoaComPartido("eduardo", "999999999-0", "paraiba","praca,praia,ruas",  "PSDB"));
        arr.add(new PessoaComPartido("nome", "casa", "idk", "jajaja", "alo"));

        c1 = new Comissao("passeio", (ArrayList)arr);
    }


    @Test
    void getTamanhoComissao() {
        assertEquals(3, c1.getTamanhoComissao());
    }

    @Test
    void interessesDeputados() {
        List<String> interesses = new ArrayList<>();
        interesses.add("");
        interesses.add("praca,praia,ruas");
        interesses.add("jajaja");
        assertEquals(interesses, c1.interessesDeputados());
    }

    @Test
    void getDeputados() {
        assertEquals(arr, c1.getDeputados());
    }
}