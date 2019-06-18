package ECO.Controladores;

import ECO.Comissao;
import ECO.LeiAbstract;

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
        if (!this.propostaLeiController.getProposta(codigo).isTrami()){
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }
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
            this.propostaLeiController.adicionaTramitacao(codigo,this.propostaLeiController.getLocalAtual(codigo),"APROVADA");
            this.propostaLeiController.getProposta(codigo).setTrami(false);
            return true;
        }
        this.propostaLeiController.proximoLocal(codigo,proximoLocal);
        this.propostaLeiController.adicionaTramitacao(codigo,this.propostaLeiController.getLocalAtual(codigo),"REPROVADA");
        return false;
    }

    public boolean votarComissaoConclusiva(String codigo, String statusGovernista, String proximoLocal)
    {
        LeiAbstract proposta = this.propostaLeiController.getProposta(codigo);
        if(this.propostaLeiController.getLocalAtual(codigo).equals("CCJC")){
            if(!votarComissao(codigo,statusGovernista,proximoLocal)){
                proposta.setSituacao("ARQUIVADA");
                proposta.setTrami(false);
                return false;
            } else if(votarComissao(codigo,statusGovernista,proximoLocal)){
                proposta.setSituacao("APROVADA");
                return true;
            }
        } else {
            if(votarComissao(codigo,statusGovernista,proximoLocal)){
                proposta.setSituacao("APROVADA");
                proposta.setTrami(false);
                return true;
            } else {
                proposta.setSituacao("ARQUIVADA");
                proposta.setTrami(false);
                return false;
            }
        } return false;
    }
}
