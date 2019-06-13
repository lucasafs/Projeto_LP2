package ECO;

public class PessoaSemPartido extends Pessoa {

	public PessoaSemPartido(String nome, String dni, String estado, String interesses) {
		super(nome, dni, estado, interesses);
	}
	
	@Override
	public String toString() {
		if ("".equals(this.interesses.trim())){ 
			return this.nome + " - " + this.dni + " (" + this.estado + ")";
		}
		return super.nome + " - " + super.dni + " (" + super.estado + ") - Interesses: " + super.interesses;
	}

	@Override
	public boolean cadastraDeputado(String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String exibirPessoa() {
		return this.toString();
	}

	@Override
	public Funcao getFuncao() {
		// TODO Auto-generated method stub
		return null;
	}

}
