package ECO;

import java.util.ArrayList;

/**
 * Esta classe define uma comissão para permitir um discussão mais profunda 
 * sobre um determinado tema.
 */
public class Comissao {
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
}
