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

    /**
     * Metodo utilizado para relizar o cadastro de Pessoa.
     * @param nome Nome da pessoa
     * @param dni DNI da pessoa.
     * @param estado Estado no qual a Pessoa se encontra.
     * @param interesses Interesses da pessoa.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses);
    }

    /**
     * Metodo utilizado para relizar o cadastro de Pessoa.
     * @param nome Nome da pessoa
     * @param dni DNI da pessoa.
     * @param estado Estado no qual a Pessoa se encontra.
     * @param interesses Interesses da pessoa.
     * @param partido Partido que a pessoa apoia.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    /**
     * Metodo utilizado para realizar o Cadastro de um Deputado.
     * @param DNI DNI da pessoa.
     * @param dataDeInicio Data de inicio da vida publica.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        pessoaController.cadastrarDeputado(DNI, dataDeInicio);
    }

    /**
     * Metodo utilizado para exibir pessoa.
     * @param DNI DNI da pessoa a ser exibida.
     * @return retorna uma String com a representacao textual de pessoa.
     */
    public String exibirPessoa(String DNI) {
        return pessoaController.exibirPessoa(DNI);
    }

    /**
     * cadastra um partido atravez do seu nome, ignora repetições
     * @param partido String contendo o nome do partido
     */
    public void cadastrarPartido(String partido){
        if(partido == null || partido.equals("")) throw new NullPointerException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        partidoController.cadastraPartido(partido);
    }

    /**
     * nome de todos os partidos ordenados em ordem lexografica
     * @return string contendo o nome de todos os partidos
     */
    public String exibirBase(){
        return partidoController.exibirBase();
    }

    /**
     * Metodo utilizado para realizar o cadastro de uma Comissao.
     * @param tema Tema da comissao.
     * @param politicos Deputados que compoem a comissao.
     */
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

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e se e conclusiva.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param conclusivo Atributo que afirma se e conclusiva.
     * @return retorna o codigo da Lei criada.
     */
    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        validaCadastroLei(dni,ano,ementa,interesses,url);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e os artigos.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param artigos Artigos que a compoem.
     * @return retorna o codigo da Lei criada.
     */
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e os artigos.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param artigos Artigos que a compoem.
     * @return retorna o codigo da Lei criada.
     */
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.pessoaController.verificaDeputado(dni,"Erro ao cadastrar projeto:");
        return this.propostaLeiController.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    /**
     * Metodo utilizado para exibir a representacao textual de um projeto.
     * @param codigo Codigo do projeto de lei a ser exibido.
     * @return retorn a representacao textual do projeto.
     */
    public String exibirProjeto(String codigo){
        return this.propostaLeiController.exibirProjeto(codigo);
    }

    /**
     * Metodo utilizado para realizar a votacao em comissao.
     * @param codigo Codigo dao Projeto de Lei.
     * @param statusGovernista Status de apoio a votacao.
     * @param proximoLocal Local a qual o Projeto sera encaminhado apos votacao.
     * @return retorna true caso aprovada ou false em demais casos.
     */
	public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
		return this.votacaoController.votarComissao(codigo, statusGovernista, proximoLocal);
    }

    /**
     * Metodo utilizado para realizar a votacao no Plenario.
     * @param codigo Codigo do Projeto de Lei.
     * @param statusGovernista Status de apoio a votacao.
     * @param presentes Deputados presentes para a votacao.
     * @return retorna true caso seja aprovada ou false em demais casos.
     */
	public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
		return this.votacaoController.votarPlenario(codigo, statusGovernista, presentes);
	}

}
