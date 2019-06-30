package ECOTests.ControladoresTests;

import ECO.Controladores.ECOntroller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ECOntrollerTest {

    ECOntroller c;

    @BeforeEach
    void setUp() {
        c = new ECOntroller();
    }

    @Test
    void cadastrarPessoa() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void cadastrarPessoa1() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void cadastrarDeputado() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void exibirPessoa() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void cadastrarPartido() {
        assertThrows(NullPointerException.class, ()-> c.cadastrarPartido(""));
        assertThrows(NullPointerException.class, ()-> c.cadastrarPartido(null));
        assertDoesNotThrow(()->  c.cadastrarPartido("partdido"));
        assertDoesNotThrow(()->  c.cadastrarPartido("PT"));
    }

    @Test
    void exibirBase() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void cadastrarComissao() {
        c.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-0", "20122000");
        c.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-1", "30062019");
        c.cadastrarPessoa("joao", "987654321-0", "paraiba", "passeata", "PSDB");
        c.cadastrarDeputado("987654321-0", "26082000");
        assertThrows(IllegalArgumentException.class, ()->  c.cadastrarComissao("", "123456789-0"));
        assertThrows(IllegalArgumentException.class, ()->  c.cadastrarComissao("casa", ""));
        assertDoesNotThrow(()-> c.cadastrarComissao("casa", "123456789-0,987654321-0"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarComissao("casa", "123456789-0,987654321-0"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarComissao("vaca", "123456789-1,123456789-0,1"));
        c.cadastrarPessoa("joao", "987654321-1", "paraiba", "passeata", "PSDB");
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarComissao("vaca", "123456789-1,123456789-0,987654321-1"));
        c.cadastrarDeputado("987654321-1", "26082000");
        assertDoesNotThrow(()-> c.cadastrarComissao("vaca", "123456789-1,123456789-0,987654321-1"));

    }

    @Test
    void cadastrarPL() {
        c.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-0", "20122000");
        c.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-1", "30062019");
        c.cadastrarPessoa("joao", "987654321-0", "paraiba", "passeata", "PSDB");
        c.cadastrarDeputado("987654321-0", "26082000");
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("dni", 2000,"007", "@", ".com", true));
        assertDoesNotThrow(()-> c.cadastrarPL("123456789-0", 2000,"007", "@", ".com", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("123456789-0", 1000,"PL 90123", "@", ".com", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("123456789-0", 2000,"", "@", ".com", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("123456789-0", 2000,"PL 90123", "", ".com", false));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("123456789-0", 2000,"PL 90123", "@", "", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPL("123456789-0", 2020,"PL 90123", "@", ".com", true));
        assertThrows(NullPointerException.class, () -> c.cadastrarPL("234325129-3", 2019, "consti", "pavimentacao,academia", "png", false));

    }

    @Test
    void cadastrarPLP() {
        c.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-0", "20122000");
        c.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-1", "30062019");
        c.cadastrarPessoa("joao", "987654321-0", "paraiba", "passeata", "PSDB");
        c.cadastrarDeputado("987654321-0", "26082000");
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("dni", 2000,"007", "@", ".com", "dvc"));
        assertDoesNotThrow(()-> c.cadastrarPL("123456789-0", 2000,"007", "@", ".com", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 1000,"PLP 718", "@", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 2000,"", "@", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 2000,"PLP 718", "", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 2000,"PLP 718", "@", "", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 2020,"PLP 718", "@", ".com", "artigos"));
        assertThrows(NullPointerException.class, () -> c.cadastrarPLP("234325129-3", 2019, "consti", "pavimentacao,academia", "png", "dvc,eda"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPLP("123456789-0", 2019,"PLP 718", "@", ".com", ""));
    }

    @Test
    void cadastrarPEC() {
        c.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-0", "20122000");
        c.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        c.cadastrarDeputado("123456789-1", "30062019");
        c.cadastrarPessoa("joao", "987654321-0", "paraiba", "passeata", "PSDB");
        c.cadastrarDeputado("987654321-0", "26082000");
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("dni", 2000,"007", "@", ".com", "dvc"));
        assertDoesNotThrow(()-> c.cadastrarPL("123456789-0", 2000,"007", "@", ".com", true));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 1000,"PEC 203", "@", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 2000,"", "@", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 2000,"PEC 203", "", ".com", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 2000,"PEC 203", "@", "", "artigos"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 2020,"PEC 203", "@", ".com", "artigos"));
        assertThrows(NullPointerException.class, () -> c.cadastrarPEC("234325129-3", 2019, "PEC 203", "pavimentacao,academia", "png", "dvc,eda"));
        assertThrows(IllegalArgumentException.class, ()-> c.cadastrarPEC("123456789-0", 2019,"PEC 203", "@", ".com", ""));
    }

    @Test
    void exibirProjeto() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void votarComissao() {
        //metodo testado em outro controler e nas classes bases
    }

    @Test
    void votarPlenario() {
        //metodo testado em outro controler e nas classes bases
    }
}