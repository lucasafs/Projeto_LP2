package ECO.PESSOA;

/**
 * Classe utilizada para a criacao de uma pessoa sem partido, composta por um nome, dni, estado, interesses e partido.
 */
public class PessoaSemPartido extends Pessoa {

	/**
	 * Construtor utilizado para criar uma pessoa composta por nome, dni, estado e interesses.
	 * @param nome nome da pessoa.
	 * @param dni dni referente a pessoa.
	 * @param estado estado do brasil referente a pessoa.
	 * @param interesses interesses da pessoa.
	 */
	public PessoaSemPartido(String nome, String dni, String estado, String interesses) {
		super(nome, dni, estado, interesses);
	}

	/**
	 * Metodo para criar a representacao textual de uma pessoa.
	 * @return retorna a representacao textual de pessoa, do tipo String.
	 */
	@Override
	public String toString() {
		if ("".equals(this.interesses.trim())){ 
			return this.nome + " - " + this.dni + " (" + this.estado + ")";
		}
		return super.nome + " - " + super.dni + " (" + super.estado + ") - Interesses: " + super.interesses;
	}

	/**
	 * Metodo utilizado para realizar o cadastro de um Deputado.
	 * @param data data de inicio de mandato.
	 * @return retorna True caso consiga realizar o cadastro e False em demais casos.
	 */
	@Override
	public boolean cadastraDeputado(String data) {
		return false;
	}

	/**
	 * Metodo utilizado para exibir pessoa.
	 * @return retorna uma String com a representacao textual de pessoa.
	 */
	@Override
	public String exibirPessoa() {
		return this.toString();
	}

	/**
	 * Metodo abstrato para acessar uma funcao.
	 * @return retorna a funcao de pessoa, do tipo Funcao.
	 */
	@Override
	public Funcao getFuncao() {
		return null;
	}

}
