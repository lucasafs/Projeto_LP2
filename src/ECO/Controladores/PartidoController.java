package ECO.Controladores;

import java.util.Set;
import java.util.TreeSet;

public class PartidoController {

    private Set<String> partidoMap;

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

    public boolean contemPartido(String partido){
        return this.partidoMap.contains(partido);
    }
}
