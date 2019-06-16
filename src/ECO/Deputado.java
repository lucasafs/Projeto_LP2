package ECO;

import java.text.SimpleDateFormat;

/**
 * Esta classe define um deputado.
 */
public class Deputado implements Funcao {
	
	/**
	 * Este atributo representa uma data.
	 */
    private String data;
    
    /**
     * Este atributo representa a quantidade de leis.
     */
    private int leis;
    
    /**
     * Construtor que inicializa os atributos: data e leis;
     * @param data
     */
    public Deputado(String data){
        this.data = data;
        this.leis = 0;
    }
    
    /**
     * Este é o método toString de Deputado que retorna
     * a representação textual do mesmo.
     */
    @Override
    public String toString()
    {
        return data.substring(0,2)+"/"+data.substring(2,4)+"/"+data.substring(4,8) + " - " + this.leis + " Leis";
    }
}