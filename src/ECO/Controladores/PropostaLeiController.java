package ECO.Controladores;

import ECO.*;

import java.util.HashMap;
import java.util.Map;

public class PropostaLeiController {

    private Map<String, LeiAbstract> propostaLeiMap;
    private int contLeiPL;
    private int contLeiPLP;
    private int contLeiPEC;
    private int ano;

    public PropostaLeiController(){
        this.propostaLeiMap = new HashMap<>();
        this.contLeiPL = 1;
        this.contLeiPLP = 1;
        this.contLeiPEC = 1;
        this.ano = 2019;
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
//        if (ano > this.ano){
//            novoAno(ano);
//        }
        String codigo = "PL " + this.contLeiPL++ + "/" + ano;
        this.propostaLeiMap.put(codigo,new PL(dni,ano,codigo,ementa,interesses,url,conclusivo));
        return codigo;
    }
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
//        if (ano > this.ano){
//            novoAno(ano);
//        }
        String codigo = "PLP " + this.contLeiPLP++ + "/" + ano;
        this.propostaLeiMap.put(codigo,new PLP(dni,ano,codigo,ementa,interesses,url,artigos));
        return codigo;
    }
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
//        if (ano > this.ano){
//            novoAno(ano);
//        }
        String codigo = "PEC " + this.contLeiPEC++ + "/" + ano;
        this.propostaLeiMap.put(codigo,new PEC(dni,ano,codigo,ementa,interesses,url,artigos));
        return codigo;
    }

    private void novoAno(int ano){
        this.ano = ano;
        this.contLeiPL = 1;
        this.contLeiPLP = 1;
        this.contLeiPEC = 1;
    }

    public String exibirProjeto(String codigo){
        return this.propostaLeiMap.get(codigo).exibirProjeto();
    }

    public String getLocalAtual(String codigo){
        return this.propostaLeiMap.get(codigo).getComissaoAtual();
    }

    public boolean contemProspota(String codigo){ return this.propostaLeiMap.containsKey(codigo);}

    public String getInteresses(String codigo){
        return this.propostaLeiMap.get(codigo).getInteresses();
    }

    public void proximoLocal(String codigo, String proximoLocal) {
        this.propostaLeiMap.get(codigo).setComissaoAtual(proximoLocal);
    }

    public void adicionaTramitacao(String codigo, String localAtual, String status)
    {
        this.propostaLeiMap.get(codigo).adicionaTramitacao(localAtual,status);
    }

    public LeiAbstract getProposta(String codigo){
        return this.propostaLeiMap.get(codigo);
    }
    
    /*public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
    	this.propostaLeiMap.get(codigo).
    }*/
}
