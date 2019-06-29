package ECO.Controladores;

import ECO.COMISSAO.Comissao;
import ECO.PESSOA.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller que contem metodos e atributos utilizados para criar e cuidar das Comissoes.
 */
public class ComissaoController {

    private Map<String, Comissao> comissaoMap;

    /**
     * Construtor que inicializa um HashMap que ira armazenar as comissoes cadastradas.
     */
    public ComissaoController(){
        this.comissaoMap = new HashMap<>();
    }

    /**
     * Metodo utilizado para realizar o cadastro de uma Comissao.
     * @param tema Tema da comissao.
     * @param deputados Deputados que compoem a comissao.
     */
    public void cadastrarComissao(String tema, ArrayList<Pessoa> deputados){
        this.comissaoMap.put(tema,new Comissao(tema,deputados));
    }

    /**
     * Metodo utilizado para verificar se tal comissao existe.
     * @param tema tema da comissao a ser verificada.
     * @return retorna true caso exista ou false em demais casos.
     */
    public boolean contemComissao(String tema){
        return this.comissaoMap.containsKey(tema);
    }

    /**
     * Metodo utilizado para acessar a comissao.
     * @param tema comissao a ser acessada.
     * @return retorna a comissao.
     */
    public Comissao getComissao(String tema){
        return this.comissaoMap.get(tema);
    }

}
