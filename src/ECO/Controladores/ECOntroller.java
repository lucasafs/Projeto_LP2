package ECO.Controladores;

import ECO.PESSOA.Pessoa;

import java.util.ArrayList;

import static Util.Validador.*;

public class ECOntroller {

    private PessoaController pessoaController;
    private ComissaoController comissaoController;
    private PropostaLeiController propostaLeiController;
    private Votacao votacaoController;
    private PartidoController partidoController;

    public ECOntroller() {
        this.pessoaController = new PessoaController();
        this.comissaoController = new ComissaoController();
        this.propostaLeiController = new PropostaLeiController();
        this.partidoController = new PartidoController();
        this.votacaoController = new Votacao(this.propostaLeiController,this.comissaoController,this.partidoController,this.pessoaController);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        pessoaController.cadastrarDeputado(DNI, dataDeInicio);
    }

    public String exibirPessoa(String DNI) {
        return pessoaController.exibirPessoa(DNI);
    }

    public void cadastrarPartido(String partido){
        partidoController.cadastraPartido(partido);
    }

    public String exibirBase(){
        return partidoController.exibirBase();
    }

    public void cadastrarComissao(String tema, String politicos){
        validaComissao(tema,politicos);
        if (this.comissaoController.contemComissao(tema)){
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }
        ArrayList<Pessoa> deputados = new ArrayList<>();
        String[] dnis = politicos.split(",");
        for (String dni: dnis){
            validaDNICadastrarComissao(dni);
            deputados.add(this.pessoaController.getDeputadoComissao(dni));
        }
        this.comissaoController.cadastrarComissao(tema,deputados);
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        validaCadastroLei(dni,ano,ementa,interesses,url);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo){
        return this.propostaLeiController.exibirProjeto(codigo);
    }

	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		validaVotarComissao(codigo, statusGovernista, proximoLocal);

		return this.votacaoController.votarComissao(codigo, statusGovernista, proximoLocal);

    }

	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		return this.votacaoController.votarPlenario(codigo, statusGovernista, presentes);
	}

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
        if (!this.comissaoController.contemComissao(this.propostaLeiController.getLocalAtual(codigo))){
            throw new NullPointerException("Erro ao votar proposta: " + this.propostaLeiController.getLocalAtual(codigo) + " nao cadastrada");
        }

        String situacao = this.propostaLeiController.getSituacao(codigo);
        if(situacao.equals("APROVADA") || situacao.equals("ARQUIVADA")){
            throw new RuntimeException("Erro ao votar proposta: tramitacao encerrada");
        }
        if (situacao.equals("plenario") || situacao.equals("Plenario - 1o turno")
                || situacao.equals("Plenario - 2o turno")){
            throw new RuntimeException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }
    }
}
