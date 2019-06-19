package ECO;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe define uma comissão para permitir um discussão mais profunda 
 * sobre um determinado tema.
 */
public class Comissao {
    public String[][] interessesDeputados;
    /**
	 * Este atributo define o tema da comissão.
	 */
    private String tema;
    /**
     * Este atributo organiza os deputados para uma comissão.
     */
    private ArrayList<Pessoa> deputados;
    /**
     * Construtor utilizado para construir uma comissão,
     * a partir dos parâmetros passados: tema e deputados.
     * @param tema
     * @param deputados
     */
    public Comissao(String tema, ArrayList<Pessoa> deputados){
        this.tema = tema;
        this.deputados = deputados;
    }
    /**
     * Método utilizado para pegar o tema da comissão.
     * @return
     */
    public String getTema() {
        return tema;
    }

    public int contaVotos(String status)
    {
        int contador = 0;
        boolean comparador = "GOVERNISTA".equals(status);
        for (Pessoa deputado: deputados){
            PessoaComPartido deputadoc = (PessoaComPartido) deputado;
            if (comparador && ){
                    contador++;
            }
        }
        return contador;
    }
    public int getTamanhoComissao(){
        return deputados.size();
    }
    public List<String> interessesDeputados(){
        List<String> interesses = new ArrayList<>();
        for (Pessoa pessoa: deputados){
            interesses.add(pessoa.getInteresses());
        }
        return interesses;
    }
}
