package ECO.Controladores;

import ECO.COMISSAO.Comissao;
import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import ECO.PROJETOLEI.PEC;
import ECO.PROJETOLEI.PL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe composta por atributos e metodos necessarios para realizar votacoes tanto em comissao como no plenario.
 */
public class Votacao {

    private PropostaLeiController propostaLeiController;
    private ComissaoController comissaoController;
    private PartidoController partidoController;
    private PessoaController pessoaController;

    /**
     * Construtor que recebe acesso aos demais controllers, necessarios para realizar a votacao.
     * @param propostaLeiController Controller das Propostas de Leis.
     * @param comissaoController Controller das comissoes.
     * @param partidoController Controller dos partidos governistas.
     * @param pessoaController Controller de Pessoa.
     */
    public Votacao(PropostaLeiController propostaLeiController, ComissaoController comissaoController,
                   PartidoController partidoController, PessoaController pessoaController)
    {
        this.propostaLeiController = propostaLeiController;
        this.comissaoController = comissaoController;
        this.partidoController = partidoController;
        this.pessoaController = pessoaController;
    }

    /**
     * Metodo desenvolvido para realizar a contagem de votos em uma PL com base no apoio que ela recebe (Governista, Oposicao ou Livre).
     * @param codigo Codigo do Projeto de Lei.
     * @param statusGovernista Status de apoio da votacao.
     * @return retorna true caso a base de apoio seja maioria ou false em demais casos.
     */
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
                if (interesseEmComumComissao(codigo, deputadoc)){
                    contador++;
                }
            }
        } return (contador >= comissao.getTamanhoComissao() / 2 + 1);
    }

    /**
     * Metodo utilizado para validar a Comissao antes de realizar a votacao.
     * @param codigo Codigo do Projeto de Lei.
     * @param statusGovernista Status de apoio da votacao.
     * @param proximoLocal Local a qual a PL sera encaminhada.
     */
    private void validaVotarComissao(String codigo, String statusGovernista, String proximoLocal){
        if (proximoLocal == null || "".equals(proximoLocal.trim())){
            throw new IllegalArgumentException("Erro ao votar proposta: proximo local vazio");
        }
        if (!("GOVERNISTA".equals(statusGovernista.toUpperCase()) || "OPOSICAO".equals(statusGovernista.toUpperCase()) || "LIVRE".equals(statusGovernista.toUpperCase()))){
            throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
        }
        if (!this.propostaLeiController.contemProspota(codigo)){
            throw new NullPointerException("Erro ao votar proposta: projeto inexistente");
        }
        String situacao = this.propostaLeiController.getSituacao(codigo);
        String local = this.propostaLeiController.getLocalAtual(codigo);
        if(situacao.equals("APROVADA") || situacao.equals("ARQUIVADA")){
            throw new RuntimeException("Erro ao votar proposta: tramitacao encerrada");
        }
        if (situacao.equals("plenario") || local.equals("Plenario - 1o turno")
                || local.equals("Plenario - 2o turno")){
            throw new RuntimeException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }
        if (!this.comissaoController.contemComissao(this.propostaLeiController.getLocalAtual(codigo))){
            throw new NullPointerException("Erro ao votar proposta: " + this.propostaLeiController.getLocalAtual(codigo) + " nao cadastrada");
        }
    }

    /**
     * Metodo utilizado para realizar a votacao em comissao.
     * @param codigo Codigo dao Projeto de Lei.
     * @param statusGovernista Status de apoio a votacao.
     * @param proximoLocal Local a qual o Projeto sera encaminhado apos votacao.
     * @return retorna true caso aprovada ou false em demais casos.
     */
    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
        validaVotarComissao(codigo, statusGovernista, proximoLocal);
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
                if ("plenario".equals(proximoLocal)) {
                    this.propostaLeiController.setComissaoAtual(codigo, "Plenario");
                } else {
                    this.propostaLeiController.setComissaoAtual(codigo, proximoLocal);
                }
                this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
            }
            return true;
        } else {
            if ("plenario".equals(proximoLocal)) {
                this.propostaLeiController.setComissaoAtual(codigo, "Plenario - 1o turno");
                this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
            }
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

    /**
     * Metodo privado com o intuito de verificar se o Deputado contem algum interesse em comum com o Projeto de Lei votada na comissao.
     * @param codigo Codigo do Projeto de Lei.
     * @param deputado Deputado a votar.
     * @return retorna true caso tenha algum interesse em comum e false em demais casos.
     */
    private boolean interesseEmComumComissao(String codigo, PessoaComPartido deputado){

        String[] interessesPL = this.propostaLeiController.getInteresses(codigo).split(",");
        String[] interessesDeputado = deputado.getInteresses().split(",");
        for (String interesses: interessesDeputado){
            for (String interessesLei: interessesPL){
                if (interesses.equals(interessesLei)){
                    return true;
                }
            }
        } return false;
    }

    /**
     * Metodo privado utilizado para validar a votacao no Plenario.
     * @param codigo Codigo do Projeto de Lei.
     * @param deputados Deputados presentes para a votacao.
     */
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
        if(!situacao.equals("EM VOTACAO") && !situacao.equals("plenario")){
            throw new RuntimeException("Erro ao votar proposta: tramitacao encerrada");
        }
        if (this.propostaLeiController.getProposta(codigo) instanceof PEC){
            if (deputadosLista.length < (totalDeputados * 0.6 + 1)){
                throw new RuntimeException("Erro ao votar proposta: quorum invalido");
            }
        }
        if (!("Plenario - 1o turno".equals(local)||"Plenario - 2o turno".equals(local)||"Plenario".equals(local))){
            throw new RuntimeException("Erro ao votar proposta: tramitacao em comissao");
        }

    }

    /**
     * Metodo utilizado para realizar a votacao no Plenario.
     * @param codigo Codigo do Projeto de Lei.
     * @param statusGovernista Status de apoio a votacao.
     * @param presentes Deputados presentes para a votacao.
     * @return retorna true caso seja aprovada ou false em demais casos.
     */
    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
        validaVotacaoPlenario(codigo,presentes);

        if (this.propostaLeiController.getProposta(codigo) instanceof PL) {
            if (contaVotosPlenario(codigo, presentes, statusGovernista)){
                this.pessoaController.criaLeis(this.propostaLeiController.getAutorDNI(codigo));
                this.propostaLeiController.setSituacao(codigo,"APROVADO");
                return true;
            } else {
                this.propostaLeiController.setSituacao(codigo,"ARQUIVADA");
                return false;
            }
        } else {
            if (contaVotosPlenario(codigo, presentes, statusGovernista)){
                if("Plenario - 2o turno".equals(this.propostaLeiController.getLocalAtual(codigo))){
                    this.pessoaController.criaLeis(this.propostaLeiController.getAutorDNI(codigo));
                    this.propostaLeiController.setSituacao(codigo,"APROVADO");
                    return true;
                }
                else{
                    this.propostaLeiController.setSituacao(codigo,"EM VOTACAO");
                    this.propostaLeiController.setComissaoAtual(codigo,"Plenario - 2o turno");
                    return true;
                }
            } else {
                this.propostaLeiController.setSituacao(codigo,"ARQUIVADO");
                return false;
            }
        }
    }

    /**
     * Metodo privado utilizado para realizar a contagem de votos no plenario, com base no apoio recebido.
     * @param codigo Codigo do Projeto de Lei.
     * @param presentes Deputados Presentes na votacao.
     * @param statusGovernista Status de apoio a votacao.
     * @return retorna true caso os votos seja maioria ou false em demais casos.
     */
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

    /**
     * Metodo privado com o intuito de verificar se o Deputado contem algum interesse em comum com o Projeto de Lei votado no Plenario.
     * @param codigo Codigo do Projeto de Lei.
     * @param deputado Deputado a votar.
     * @return retorna true caso tenha interesse em comum ou false em demais casos.
     */
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

