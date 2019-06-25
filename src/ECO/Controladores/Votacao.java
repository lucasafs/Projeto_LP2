package ECO.Controladores;

import ECO.COMISSAO.Comissao;
import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import ECO.PROJETOLEI.PEC;
import ECO.PROJETOLEI.PL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Votacao {

    private PropostaLeiController propostaLeiController;
    private ComissaoController comissaoController;
    private PartidoController partidoController;
    private PessoaController pessoaController;

    public Votacao(PropostaLeiController propostaLeiController, ComissaoController comissaoController,
                   PartidoController partidoController, PessoaController pessoaController)
    {
        this.propostaLeiController = propostaLeiController;
        this.comissaoController = comissaoController;
        this.partidoController = partidoController;
        this.pessoaController = pessoaController;
    }

    private boolean contaVotos(String codigo, String statusGovernista)
    {
        Comissao comissao = this.comissaoController.getComissao(this.propostaLeiController.getLocalAtual(codigo));
        int contador = 0;
        ArrayList<Pessoa> deputados = comissao.getDeputados();
        for (Pessoa deputado: deputados){
            PessoaComPartido deputadoc = (PessoaComPartido) deputado;
            if ("GOVERNISTA".equals(statusGovernista)){
                if (this.partidoController.contemPartido(deputadoc.getPartido())){
                    contador++;
                }
            } else if ("OPOSICAO".equals(statusGovernista)){
                if (!this.partidoController.contemPartido(deputadoc.getPartido())){
                    contador++;
                }
            } else {
                if (interesseEmComumComissao(codigo)){
                    contador++;
                }
            }
        } return (contador >= comissao.getTamanhoComissao() / 2 + 1);
    }

    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
    if (!this.propostaLeiController.getProposta(codigo).getSituacao().equals("EM VOTACAO")) {
        throw new RuntimeException("Erro ao votar proposta: tramitacao encerrada");
    }
    if (contaVotos(codigo,statusGovernista)) {
        if ("-".equals(proximoLocal)) {
            this.pessoaController.criaLeis(this.propostaLeiController.getAutorDNI(codigo));
            this.propostaLeiController.setSituacao(codigo, "APROVADO");
        } else if (!(this.propostaLeiController.getProposta(codigo) instanceof PL)) {
            if ("plenario".equals(proximoLocal)) {
                this.propostaLeiController.setComissaoAtual(codigo, "Plenario - 1o turno");
                this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
            }
        } else {
            System.out.println(proximoLocal + " " + codigo);
            if ("plenario".equals(proximoLocal)) {
                this.propostaLeiController.setComissaoAtual(codigo, "Plenario - 1o turno");
            } else {
                this.propostaLeiController.setComissaoAtual(codigo, proximoLocal);
            }
            this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
        }
        return true;
    } else {
        if ("-".equals(proximoLocal)) {
            this.propostaLeiController.setSituacao(codigo, "ARQUIVADO");
        }
    }
    if (this.propostaLeiController.getProposta(codigo).isConclusiva()) {
        this.propostaLeiController.setSituacao(codigo,"ARQUIVADO");
    } else {
        this.propostaLeiController.setSituacao(codigo,proximoLocal);
    }
    return false;
    }



    private boolean interesseEmComumComissao(String codigo){
        Comissao comissao = this.comissaoController.getComissao(this.propostaLeiController.getLocalAtual(codigo));

        String[] interessesPL = this.propostaLeiController.getInteresses(codigo).split(",");
        List<String> interessesDep = comissao.interessesDeputados();
        for (String interesses: interessesDep){
            String[] interesseSplitado = interesses.split(",");
            for (String interessesLei: interessesPL){
                if (Arrays.asList(interesseSplitado).contains(interessesLei)){
                    return true;
                }
            }
        } return false;
    }

    private void validaVotacaoPlenario(String codigo, String deputados){
        String situacao = this.propostaLeiController.getProposta(codigo).getSituacao();
        String local = this.propostaLeiController.getLocalAtual(codigo);
        String[] deputadosLista = deputados.split(",");
        int totalDeputados = this.pessoaController.totalDeputados();
        if (!(this.propostaLeiController.getProposta(codigo) instanceof PEC)){
            if (deputadosLista.length < (totalDeputados / 2 + 1)){
                throw new RuntimeException("Erro ao votar proposta: quorum invalido");
            }
        }
        if (this.propostaLeiController.getProposta(codigo) instanceof PEC){
            if (deputadosLista.length < ((3*totalDeputados) / 5 + 1)){
                throw new RuntimeException("Erro ao votar proposta: quorum invalido");
            }
        }
        if(!situacao.equals("EM VOTACAO")){
            throw new RuntimeException("Erro ao votar proposta: tramitacao encerrada");
        }
        if (!("Plenario - 1o turno".equals(local)||"Plenario - 2o turno".equals(local))){
            throw new RuntimeException("Erro ao votar proposta: tramitacao em comissao");
        }

    }


    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
        validaVotacaoPlenario(codigo,presentes);

        if (this.propostaLeiController.getProposta(codigo) instanceof PL) {
            if (contaVotosPlenario(codigo, presentes, statusGovernista)){
                this.pessoaController.criaLeis(this.propostaLeiController.getAutorDNI(codigo));
                this.propostaLeiController.setSituacao(codigo,"APROVADA");
                return true;
            } else {
                this.propostaLeiController.setSituacao(codigo,"ARQUIVADA");
                return false;
            }
        } else {
            if (contaVotosPlenario(codigo, presentes, statusGovernista)){
                if("Plenario - 2o turno".equals(this.propostaLeiController.getLocalAtual(codigo))){
                    this.pessoaController.criaLeis(this.propostaLeiController.getAutorDNI(codigo));
                    this.propostaLeiController.setSituacao(codigo,"APROVADA");
                    return true;
                }
                else{
                    this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
                    this.propostaLeiController.setComissaoAtual(codigo,"Plenario - 2o turno");
                    return true;
                }
            } else {
                this.propostaLeiController.setSituacao(codigo,"ARQUIVADA");
                return false;
            }
        }
    }

    private boolean contaVotosPlenario(String codigo, String presentes, String statusGovernista) {
        String[] deputadosDNI = presentes.split(",");

        ArrayList<Pessoa> deputados = new ArrayList<>();
        for (String dni: deputadosDNI){
            deputados.add(this.pessoaController.getDeputadoComissao(dni));
        }
        int contador = 0;
        for (Pessoa deputado: deputados){
            PessoaComPartido deputadoc = (PessoaComPartido) deputado;
            if ("GOVERNISTA".equals(statusGovernista)){
                if (this.partidoController.contemPartido(deputadoc.getPartido())){
                    contador++;
                }
            } else if ("OPOSICAO".equals(statusGovernista)){
                if (!this.partidoController.contemPartido(deputadoc.getPartido())){
                    contador++;
                }
            } else {
                if (interesseEmComumPlenario(codigo,deputadoc)){
                    contador++;
                }
            }
        }
        if (contador >= deputadosDNI.length / 2 + 1){
            return true;
        }
        return false;
    }

    private boolean interesseEmComumPlenario(String codigo,PessoaComPartido deputado) {
        String[] interessesPL = this.propostaLeiController.getInteresses(codigo).split(",");
        String[] interessesDep = deputado.getInteresses().split(",");

        for (String interesse: interessesDep){
            if (Arrays.asList(interessesPL).contains(interesse)){
                return true;
            }
        } return false;
    }
}

