package ECO.COMISSAO;

import ECO.PESSOA.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria uma comissao com deputados especialistas ao tema da comissao.
 */
public class Comissao {

    private String tema;
    private ArrayList<Pessoa> deputados;

    /**
     * Construtor utilizado para construir uma comissão, a partir dos parâmetros passados: tema e deputados.
     * @param tema Tema de interesse da comissao.
     * @param deputados um ArrayList contendo os deputados participantes da comissao.
     */
    public Comissao(String tema, ArrayList<Pessoa> deputados){
        this.tema = tema;
        this.deputados = deputados;
    }

    /**
     * Metodo utilizado para pegar o tema da comissao.
     * @return retorna o tema da comissao do tipo String.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Metodo desenvolvido com o intuito de contar quantos deputados compoem a comissao.
     * @return retorna a quantidade de deputados da comissao, do tipo int.
     */
    public int getTamanhoComissao(){
        return deputados.size();
    }

    /**
     * Metodo desenvolvido para coletar todos os interesses de cada deputado da comissao.
     * @return retorna uma lista de String com os interesses de cada deputado.
     */
    public List<String> interessesDeputados(){
        List<String> interesses = new ArrayList<>();
        for (Pessoa pessoa: deputados){
            interesses.add(pessoa.getInteresses());
        }
        return interesses;
    }

    /**
     * Metodo desenvolvido para pegar os deputados que compoem a comissao.
     * @return retorna um ArrayList de deputados.
     */
    public ArrayList<Pessoa> getDeputados(){
        return this.deputados;
    }

}
