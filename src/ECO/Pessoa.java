package ECO;

public abstract class Pessoa {

	protected String nome;
	protected String dni;
	protected String estado;
	protected String interesses;

	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}

	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}

	public abstract boolean cadastraDeputado(String data);

	public abstract String getPartido();

	public abstract String exibirPessoa();
	

	public abstract Funcao getFuncao();
	
	
	@Override
    public abstract String toString();
}
