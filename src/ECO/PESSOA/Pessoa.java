package ECO.PESSOA;

/**
 * Classe abstrata para a criacao de uma pessoa, composta por um nome, dni, estado e interesses.
 */
public abstract class Pessoa {

    protected String nome;
    protected String dni;
    protected String estado;
    protected String interesses;

    /**
     * Construtor utilizado para criar uma pessoa composta por nome, dni, estado e interesses.
     * @param nome nome da pessoa.
     * @param dni dni referente a pessoa.
     * @param estado estado do brasil referente a pessoa.
     * @param interesses interesses da pessoa.
     */
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}

	/**
	 * Metodo abstrato para realizar o cadastro de um Deputado.
	 * @param data data de inicio de mandato.
	 * @return retorna true caso consiga realizar o cadastro.
	 */
	public abstract boolean cadastraDeputado(String data);

	/**
	 * Metodo abstrato utilizado para exibir pessoa.
	 * @return retorna a exibição de pessoa.
	 */
	public abstract String exibirPessoa();

	/**
	 * Metodo abstrato para acessar uma funcao.
	 * @return retorna a Função da pessoa.
	 */
	public abstract Funcao getFuncao();

	/**
	 * Metodo abstrato para criar a representacao textual de uma pessoa.
	 */
	@Override
    public abstract String toString();

	/**
	 * Metodo para acessar os interesses de uma pessoa.
	 * @return retorna uma String com os interesses de pessoa.
	 */
	public String getInteresses()
	{
		return interesses;
	}

}
