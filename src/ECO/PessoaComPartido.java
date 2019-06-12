package ECO;

public class PessoaComPartido extends Pessoa {
	
	private String partido;
	private Funcao funcao;

	public PessoaComPartido(String nome, String dni, String estado, String interesses, String partido) {
		super(nome, dni, estado, interesses);
		this.partido = partido;
		this.funcao = null;
		}
	
	public boolean cadastraDeputado(String data) {
		this.funcao = new Deputado(data);
		return true;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public String exibirPessoa() {
		if (!(this.funcao == null)) {
			return "POL: " + toString();
		} else {
			return toString();
		}
	}
	
	public Funcao getFuncao() {
		return funcao;
	}
	
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
