package ECO.Controladores;

import ECO.Comissao;

import java.util.Arrays;
import java.util.List;

public class VotacaoController {

    private PropostaLeiController propostaLeiController;
    private ComissaoController comissaoController;

    public VotacaoController()
    {
        this.propostaLeiController = new PropostaLeiController();
        this.comissaoController = new ComissaoController();
    }

    public boolean votarComissao(String codigo, String statusGovernista){
        Comissao comissao = this.comissaoController.getComissao(this.propostaLeiController.getLocalAtual(codigo));
        int votosFavor;
        if ("GOVERNISTA".equals(statusGovernista.toUpperCase())){
            votosFavor = comissao.contaVotos("GOVERNISTA");
        } else if ("OPOSICAO".equals(statusGovernista.toUpperCase())){
            votosFavor = comissao.contaVotos("OPOSICAO");
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
        return (votosFavor >= comissao.getTamanhoComissao() / 2 + 1);
    }
}
