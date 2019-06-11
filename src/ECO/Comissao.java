package ECO;

import java.util.ArrayList;

public class Comissao {

    private String tema;
    private ArrayList<Pessoa> deputados;

    public Comissao(String tema, ArrayList<Pessoa> deputados){
        this.tema = tema;
        this.deputados = deputados;
    }
}
