package ECO.PESSOA;

/**
 * Esta classe define uma Pessoa.
 */
public abstract class Pessoa {
	/**
	 * Este atributo representa o nome de uma Pessoa.
	 */
    protected String nome;

    /**
     * Este atributo representa o DNI de uma Pessoa.
     */
    protected String dni;

    /**
     * Este atributo representa o estado de uma Pessoa.
     */
    protected String estado;

	/**
     * Este atributo representa os interesses de uma Pessoa.
     */
    protected String interesses;
    /**
     * Construtor utilizado para inicializar os atributos de uma pessoa sem partido.
     * @param nome
     * @param dni
     * @param estado
     * @param interesses
     */
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}
    /**
     * Construtor utilizado para inicializar os atributos de uma Pessoa que
     * possui partido, logo será um deputado.
     * @param nome
     * @param dni
     * @param estado
     * @param interesses
     * @param partido
     */
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}
	/**
	 * Método boolean para o cadastro de deputado.
	 * @param data
	 * @return
	 */
	public abstract boolean cadastraDeputado(String data);
	/**
	 * Representção textual de uma pessoa.
	 * @return
	 */
	public abstract String exibirPessoa();

	/**
	 * Método para pegar uma função.
	 * @return
	 */
	public abstract Funcao getFuncao();

	/**
	 * Método que trata o toString de uma pessoa.
	 */
	@Override
    public abstract String toString();

	public String getInteresses()
	{
		return interesses;
	}

}
