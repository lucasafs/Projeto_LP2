package ECO.PESSOA;
/**
 * Classe utilizada para a criacao de uma pessoa com partido, composta por um nome, dni, estado, interesses e partido.
 */
public class PessoaComPartido extends Pessoa {

	private String partido;
	private Funcao funcao;

	/**
	 * Construtor utilizado para criar uma pessoa composta por nome, dni, estado e interesses.
	 * @param nome nome da pessoa.
	 * @param dni dni referente a pessoa.
	 * @param estado estado do brasil referente a pessoa.
	 * @param interesses interesses da pessoa.
	 * @param partido partido politico de pessoa.
	 */
	public PessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		super(nome, dni, estado, interesses);
		this.partido = partido;
		this.funcao = null;
		}
	/**
	 * Metodo utilizado para realizar o cadastro de um Deputado.
	 * @param data data de inicio de mandato.
	 * @return retorna True caso consiga realizar o cadastro e False em demais casos.
	 */
	public boolean cadastraDeputado(String data) {
		this.funcao = new Deputado(data);
		return true;
	}

	/**
	 * Metodo para acessar o partido de pessoa.
	 * @return retorna o partido da pessoa, no formato String.
	 */
	public String getPartido() {
		return partido;
	}

	/**
	 * Metodo utilizado para exibir pessoa.
	 * @return retorna uma String com a representacao textual de pessoa; adiciona um POL: caso a pessoa seja deputado.
	 */
	public String exibirPessoa() {
		if (!(this.funcao == null)) {
			return "POL: " + toString();
		} else {
			return toString();
		}
	}

	/**
	 * Metodo abstrato para acessar uma funcao.
	 * @return retorna a funcao de pessoa, do tipo Funcao.
	 */
	public Funcao getFuncao() {
		return funcao;
	}

	/**
	 * Metodo para criar a representacao textual de uma pessoa.
	 * @return retorna a representacao textual de pessoa, do tipo String.
	 */
	@Override
	public String toString() {
		if (funcao == null) {
			if ("".equals(this.interesses.trim())) { 
				return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido;
			}
			return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido +  " - Interesses: " + this.interesses;
			
		}
		if ("".equals(this.interesses.trim())){ 
			return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - " + this.funcao.toString();
		}
		return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido +  " - Interesses: " + this.interesses + " - " + this.funcao.toString();
	}

	/**
	 * Metodo para incrementar o contador de Leis criadas por um Deputado.
	 */
	public void criaLei(){
		this.funcao.criaLei();
	}
	

	
}
