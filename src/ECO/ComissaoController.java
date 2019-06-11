package ECO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComissaoController {

    private Map<String, Comissao> comissaoMap;

    public ComissaoController(){
        this.comissaoMap = new HashMap<>();
    }

    public void cadastrarComissao(String tema, ArrayList<Pessoa> deputados){
        this.comissaoMap.put(tema,new Comissao(tema,deputados));
    }

    public boolean contemComissao(String tema){
        return this.comissaoMap.containsKey(tema);
    }
}
