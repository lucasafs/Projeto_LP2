package ECO.Controladores;

import java.util.Set;
import java.util.TreeSet;

/**
 * Controller que contem metodos e atributos necessarios para cuidar dos Partidos.
 */
public class PartidoController {

    private Set<String> partidoMap;

    /**
     * Construtor que inicializa um TreeSet para armazenar os partidos cadastrados.
     */
    public PartidoController() {
        this.partidoMap = new TreeSet<>();
    }

    /**
     * cadastra um partido atravez do seu nome, ignora repetições
     * @param partido String contendo o nome do partido
     */
    public void cadastraPartido(String partido){
        if(partido == null || partido.equals("")) throw new NullPointerException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        partidoMap.add(partido);
    }

    /**
     * nome de todos os partidos ordenados em ordem lexografica
     * @return string contendo o nome de todos os partidos
     */
    public String exibirBase(){
        String ans = "";
        for(String it : partidoMap){
            ans += it + ",";
        }
        return (ans.length() > 0 ? ans.substring(0, ans.length()-1) : ans);
    }

    /**
     * Metodo utilizado para verificar se tal partido existe.
     * @param partido Partido a ser verificado.
     * @return retorna true caso exista ou false em demais casos.
     */
    public boolean contemPartido(String partido){
        return this.partidoMap.contains(partido);
    }
}
