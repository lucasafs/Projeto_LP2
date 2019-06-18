package ECO.Controladores;

import ECO.Pessoa;

import java.util.ArrayList;

import static Util.Validador.*;

public class ECOntroller {

    private PessoaController pessoaController;
    private ComissaoController comissaoController;
    private PropostaLeiController propostaLeiController;
    private Votacao votacaoController;

    public ECOntroller() {
        this.pessoaController = new PessoaController();
        this.comissaoController = new ComissaoController();
        this.propostaLeiController = new PropostaLeiController();
        this.votacaoController = new Votacao(this.propostaLeiController,this.comissaoController);
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
        pessoaController.cadastraPartido(partido);
    }

    public String exibirBase(){
        return pessoaController.exibirBase();
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

		return this.votacaoController.votarComissao(codigo,statusGovernista,proximoLocal);
	}

	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		// TODO Auto-generated method stub
		return false;
	}

	private void validaVotarComissao(String codigo, String statusGovernista, String proximoLocal){
        if (!this.comissaoController.contemComissao(this.propostaLeiController.getLocalAtual(codigo))){
            throw new NullPointerException("Erro ao votar proposta: " + this.propostaLeiController.getLocalAtual(codigo) + " nao cadastrada");
        }
        if (!this.propostaLeiController.contemProspota(codigo)){
            throw new NullPointerException("Erro ao votar proposta: projeto inexistente");
        }validaVotacao(proximoLocal,statusGovernista);
    }
}
