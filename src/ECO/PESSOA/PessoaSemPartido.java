package ECO.PESSOA;
/**
 * Esta classe define uma pessoa sem partido.
 */
public class PessoaSemPartido extends Pessoa {
	/**
	 * Construtor utilizado para inicializar os atributos de uma pessoa
	 * que não possui partido.
	 * @param nome
	 * @param dni
	 * @param estado
	 * @param interesses
	 */
	public PessoaSemPartido(String nome, String dni, String estado, String interesses) {
		super(nome, dni, estado, interesses);
	}
	/**
	 * Método toString que retorna a representação textual.
	 */
	@Override
	public String toString() {
		if ("".equals(this.interesses.trim())){ 
			return this.nome + " - " + this.dni + " (" + this.estado + ")";
		}
		return super.nome + " - " + super.dni + " (" + super.estado + ") - Interesses: " + super.interesses;
	}
	/**
	 * Método boolean para cadastra deputado que retorna falso.
	 */
	@Override
	public boolean cadastraDeputado(String data) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Método utilizado para retornar o toString e exibir uma pessoa.
	 */
	@Override
	public String exibirPessoa() {
		return this.toString();
	}
	/**
	 * Método que retorna nulo do tipo função.
	 */
	@Override
	public Funcao getFuncao() {
		// TODO Auto-generated method stub
		return null;
	}

}
