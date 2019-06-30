package ECOTests.ControladoresTests;

import ECO.COMISSAO.Comissao;
import ECO.Controladores.ComissaoController;
import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComissaoControllerTest {

    ComissaoController c;
    List<Pessoa> arr;

    @BeforeEach
    void setUp() {
        c = new ComissaoController();
        arr = new ArrayList<Pessoa>();
        arr.add(new PessoaComPartido("carlos", "111111111-0", "amapa", "", "PT"));
        arr.add(new PessoaComPartido("eduardo", "999999999-0", "paraiba","praca,praia,ruas",  "PSDB"));
        arr.add(new PessoaComPartido("nome", "casa", "idk", "jajaja", "alo"));
    }

    @Test
    void cadastrarComissao() {
        c.cadastrarComissao("passeio", (ArrayList)arr);
    }

    @Test
    void contemComissao() {

        assertEquals(false, c.contemComissao("passeio"));
        assertEquals(false, c.contemComissao("fazerProjetoLP2"));
        c.cadastrarComissao("passeio", (ArrayList)arr);
        assertEquals(true, c.contemComissao("passeio"));
    }

}