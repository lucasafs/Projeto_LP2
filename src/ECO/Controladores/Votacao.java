package ECO.Controladores;

import ECO.Comissao;

import java.util.Arrays;
import java.util.List;

public class Votacao {

    private PropostaLeiController propostaLeiController;
    private ComissaoController comissaoController;

    public Votacao(PropostaLeiController propostaLeiController, ComissaoController comissaoController)
    {
        this.propostaLeiController = propostaLeiController;
        this.comissaoController = comissaoController;
    }

    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal){
        Comissao comissao = this.comissaoController.getComissao(this.propostaLeiController.getLocalAtual(codigo));
        int votosFavor;
        if ("GOVERNISTA".equals(statusGovernista.toUpperCase()) || "OPOSICAO".equals(statusGovernista.toUpperCase())){
            votosFavor = comissao.contaVotos(statusGovernista.toUpperCase());
        } else {
            int contaVoto = 0;
            String[] interessesPL = this.propostaLeiController.getInteresses(codigo).split(",");
            List<String> interessesDep = comissao.interessesDeputados();

            for (String interesses: interessesDep){
                String[] interesseSplitado = interesses.split(",");
                for (String interessesLei: interessesPL){
                    if (Arrays.asList(interesseSplitado).contains(interessesLei)){
                        contaVoto++;
                        break;
                    }
                }
            } votosFavor = contaVoto;

        }
        if (votosFavor >= comissao.getTamanhoComissao() / 2 + 1){
            this.propostaLeiController.proximoLocal(codigo,proximoLocal);
            return true;
        } return false;
    }
}
