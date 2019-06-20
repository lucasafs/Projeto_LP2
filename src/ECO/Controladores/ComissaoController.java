package ECO.Controladores;

import ECO.COMISSAO.Comissao;
import ECO.PESSOA.Pessoa;

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

    public Comissao getComissao(String tema){
        return this.comissaoMap.get(tema);
    }

    public int totalDeputados(){
        ArrayList<Integer> valores = new ArrayList<>();
        int sum = 0;
        this.comissaoMap.values().stream().map(comissao -> valores.add(comissao.getTamanhoComissao()));

        for (int valor: valores){
            sum += valor;
        }
        return sum;
    }
}
