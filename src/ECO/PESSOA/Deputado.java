package ECO.PESSOA;

/**
 * Classe utilizada para a criacao de um Deputado, que implementa a interface Funcao, que contem a data de inicio da vida publica e o numero de leis que ele criou.
 */
public class Deputado implements Funcao {

    private String data;
    private int leis;
    
    /**
     * Construtor utilizado para criar um Deputado com a data de inicio de sua vida publica.
     * @param data Data de inicio da sua vida publica.
     */
    public Deputado(String data){
        this.data = data;
        this.leis = 0;
    }

    /**
     * Metodo para criar a representacao textual de um Deputado.
     * @return retorna a representacao textual de deputado, do tipo String.
     */
    @Override
    public String toString()
    {
        return data.substring(0,2)+"/"+data.substring(2,4)+"/"+data.substring(4,8) + " - " + this.leis + " Leis";
    }

    /**
     * Metodo para incrementar o contador de Leis criadas por Deputado.
     */
    public void criaLei(){
        this.leis++;
    }
}