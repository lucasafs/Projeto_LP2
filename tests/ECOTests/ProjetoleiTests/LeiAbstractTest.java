package ECOTests.ProjetoleiTests;

import ECO.PROJETOLEI.LeiAbstract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeiAbstractTest {

    LeiAbstract l1;

    @BeforeEach
    void setup(){
        l1 = new LeiAbstract("111111911-0", 2000, "codigo", "ementa", "futebol, parquedopovo", "http://123.com") {
            @Override
            public String exibirProjeto() {
                return null;
            }
            @Override
            public boolean isConclusiva() {
                return false;
            }
        };


    }
    @Test
    void setSituacao() {
        assertEquals("EM VOTACAO", l1.getSituacao());
        l1.setSituacao("testando");
        assertEquals("testando", l1.getSituacao());
    }

    @Test
    void getSituacaoComissao() {
        assertEquals("EM VOTACAO (CCJC)", l1.getSituacaoComissao());
        l1.setSituacao("testando");
        l1.setComissaoAtual("PLENARIO");
        assertEquals("testando (PLENARIO)", l1.getSituacaoComissao());
    }
}