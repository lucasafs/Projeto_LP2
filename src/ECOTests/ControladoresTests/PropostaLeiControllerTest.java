package ECOTests.ControladoresTests;

import ECO.Controladores.PropostaLeiController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropostaLeiControllerTest {

    PropostaLeiController p;

    @BeforeEach
    void setUp() {
        p = new PropostaLeiController();
    }

    @Test
    void cadastrarPL() {
        assertEquals("PL 1/2019", p.cadastrarPL("892182191-9", 2019, "794-2", "ruas, passarelas", "onp.tom.musical", false));
        assertEquals("PL 2/2019", p.cadastrarPL("892182191-9", 2019, "794-2", "ruas, passarelas", "onp.tom.musical", false));
        assertEquals("PL 3/2019", p.cadastrarPL("12341234-1", 2019, "ementa", "interesses", ".com", true));
        assertEquals("PL 1/1020", p.cadastrarPL("892182191-9", 1020, "794-2", "ruas, passarelas", "onp.tom.musical", false));
    }

    @Test
    void cadastrarPLP() {
        assertEquals("PLP 1/2019", p.cadastrarPLP("111111911-0", 2019 , "ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
        assertEquals("PLP 2/2019", p.cadastrarPLP("111111911-0", 2019 , "ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
        assertEquals("PLP 3/2019", p.cadastrarPLP("222221911-0", 2019 , "ema", "parquedopovo", "//123.com", "apenha, seca"));
        assertEquals("PLP 1/1000", p.cadastrarPLP("111111911-0", 1000,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
    }

    @Test
    void cadastrarPEC() {
        assertEquals("PEC 1/2019", p.cadastrarPEC("111111911-0", 2019,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
        assertEquals("PEC 2/2019", p.cadastrarPEC("111111911-0", 2019,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
        assertEquals("PEC 3/2019", p.cadastrarPEC("111111911-0", 2019,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
        assertEquals("PEC 1/2000", p.cadastrarPEC("111111911-0", 2000,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca"));
    }

    @Test
    void exibirProjeto() {
        //metodo testado individualmente em cada uma das classes de tests para as propostas de lei
    }

    @Test
    void getLocalAtual() {
        //metodo testado individualmente em cada uma das classes de tests para as propostas de lei
    }

    @Test
    void contemProspota() {
        assertEquals(false, p.contemProspota("PL 1/2019"));
        p.cadastrarPL("111111911-0", 2019,"ementa", "futebol, parquedopovo", "http://123.com", true);
        assertEquals(true, p.contemProspota("PL 1/2019"));
        p.cadastrarPEC("111111911-0", 2000,"ementa", "futebol, parquedopovo", "http://123.com", "mariadapenha, seca");
        assertEquals(true, p.contemProspota("PEC 1/2000"));
    }

    @Test
    void getInteresses() {
        //metodo testado individualmente em cada uma das classes de tests para as propostas de lei
    }

    @Test
    void getAutorDNI() {
        p.cadastrarPL("111111911-0", 2019,"ementa", "futebol, parquedopovo", "http://123.com", true);
        assertEquals("111111911-0", p.getAutorDNI("PL 1/2019"));
        assertThrows(NullPointerException.class, ()-> p.getAutorDNI("PL"));
    }
}