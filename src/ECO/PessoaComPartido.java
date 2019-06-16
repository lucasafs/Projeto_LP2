package ECO;
/**
 * Esta classe define uma pessoa que possui partido.
 */
public class PessoaComPartido extends Pessoa {
	/**
	 * Atributo que representa a string partido.
	 */
	private String partido;
	/**
	 * Atributo representa uma função do tipo função.
	 */
	private Funcao funcao;
	/**
	 * Construtor utilizado para inicializar os atributos de uma pessoa com partido.
	 * @param nome
	 * @param dni
	 * @param estado
	 * @param interesses
	 * @param partido
	 */
	public PessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		super(nome, dni, estado, interesses);
		this.partido = partido;
		this.funcao = null;
		}
	/**
	 * Método é um boolean para cadastro de um deputado.
	 */
	public boolean cadastraDeputado(String data) {
		this.funcao = new Deputado(data);
		return true;
	}
	/**
	 * Método utilizado para retornar a string partido.
	 * @return
	 */
	public String getPartido() {
		return partido;
	}
	/**
	 * Método utilizado para exibir pessoa, caso tenha função ou não.
	 */
	public String exibirPessoa() {
		if (!(this.funcao == null)) {
			return "POL: " + toString();
		} else {
			return toString();
		}
	}
	/**
	 * Método utilizado para retornar uma função do tipo função.
	 */
	public Funcao getFuncao() {
		return funcao;
	}
	/**
	 * Método é a representação textual.
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
	

	
}
