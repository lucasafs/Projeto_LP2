package ECOTests.ControladoresTests;

import ECO.Controladores.PessoaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaControllerTest {

    PessoaController p;

    @BeforeEach
    void setUp() {
        p = new PessoaController();
    }

    @Test
    void cadastrarPessoa() {
        assertThrows(IllegalArgumentException.class, ()->p.cadastrarPessoa("nome", "dni", "estado", "interesses"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("nome", "", "estado", "interesses"));
        assertEquals(true, p.cadastrarPessoa("nome", "123456789-1", "estado", "interesses"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("", "123456789-1", "estado", "interesses"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("nome", "123456789-1", "", "interesses"));
        assertThrows(NullPointerException.class, ()-> p.cadastrarPessoa("nome", "123456789-1", "estado", ""));
        assertDoesNotThrow(()-> p.cadastrarPessoa("nome", "123456789-2", "estado", ""));
        assertEquals(true, p.cadastrarPessoa("lucas", "987654321-9", "paraiba", "pavimentacao,iluminacao"));

    }

    @Test
    void cadastrarPessoa1() {
        assertThrows(IllegalArgumentException.class, ()->p.cadastrarPessoa("nome", "dni", "estado", "interesses", "partido"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("nome", "", "estado", "interesses", "partido"));
        assertEquals(true, p.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("", "123456789-1", "estado", "interesses", "partido"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarPessoa("nome", "123456789-1", "", "interesses", "partido"));
        assertThrows(NullPointerException.class, ()-> p.cadastrarPessoa("nome", "123456789-1", "estado", "", "partido"));
        assertDoesNotThrow(()-> p.cadastrarPessoa("nome", "123456789-2", "estado", "", "partido"));
        assertEquals(true, p.cadastrarPessoa("lucas", "987654321-9", "paraiba", "pavimentacao,iluminacao", "PT"));
    }

    @Test
    void cadastrarDeputado() {
        assertThrows(NullPointerException.class, ()-> p.cadastrarDeputado("123456789-0", "15122000"));
        p.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarDeputado("123456789-0", "12/05/1000"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarDeputado("123456789-0", "12310510000"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarDeputado("123456789-0", "06302019"));
        assertDoesNotThrow(()-> p.cadastrarDeputado("123456789-0", "15122000"));
        p.cadastrarPessoa("lucas", "987654321-9", "paraiba", "pavimentacao,iluminacao");
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarDeputado("987654321-9", "20111999"));
        assertThrows(IllegalArgumentException.class, ()-> p.cadastrarDeputado("dni", "13081000"));
    }

    @Test
    void exibirPessoa() {
        assertThrows(NullPointerException.class,()-> p.exibirPessoa("123456789-0"));
        p.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        assertEquals("nome - 123456789-0 (estado) - partido - Interesses: interesses", p.exibirPessoa("123456789-0"));
        assertThrows(IllegalArgumentException.class, ()-> p.exibirPessoa(""));

    }

    @Test
    void getDeputadoComissao() {
        assertThrows(NullPointerException.class, ()-> p.getDeputadoComissao("123456789-0"));
        p.cadastrarPessoa("nome", "123456789-0", "estado", "interesses");
        assertThrows(IllegalArgumentException.class, ()-> p.getDeputadoComissao("123456789-0"));
        p.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        assertThrows(IllegalArgumentException.class, ()-> p.getDeputadoComissao("123456789-1"));
        p.cadastrarDeputado("123456789-1", "30062019");
        assertDoesNotThrow(()-> p.getDeputadoComissao("123456789-1"));
    }

    @Test
    void totalDeputados() {
        assertEquals(0, p.totalDeputados());
        p.cadastrarPessoa("nome", "123456789-0", "estado", "interesses", "partido");
        assertEquals(0, p.totalDeputados());
        p.cadastrarDeputado("123456789-0", "20122000");
        assertEquals(1, p.totalDeputados());
        p.cadastrarPessoa("nome", "123456789-1", "estado", "interesses", "partido");
        p.cadastrarDeputado("123456789-1", "06062019");
        assertEquals(2, p.totalDeputados());
    }
}