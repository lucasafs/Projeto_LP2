package ECO.Controladores;

import ECO.PROJETOLEI.LeiAbstract;
import ECO.PROJETOLEI.PEC;
import ECO.PROJETOLEI.PL;
import ECO.PROJETOLEI.PLP;

import java.util.HashMap;
import java.util.Map;

public class PropostaLeiController {

    private Map<String, LeiAbstract> propostaLeiMap;
    private Map<Integer,Integer> contLeisPL;
    private Map<Integer,Integer> contLeisPLP;
    private Map<Integer,Integer> contLeisPEC;


    public PropostaLeiController(){
        this.propostaLeiMap = new HashMap<>();
        this.contLeisPL = new HashMap<>();
        this.contLeisPLP = new HashMap<>();
        this.contLeisPEC = new HashMap<>();
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        if (this.contLeisPL.containsKey(ano)){
            Integer contador = this.contLeisPL.get(ano);
            contador++;
            this.contLeisPL.put(ano,contador);
        } else {
            this.contLeisPL.put(ano,1);
        }
        String codigo = "PL " + this.contLeisPL.get(ano) + "/" + ano;
        this.propostaLeiMap.put(codigo,new PL(dni,ano,codigo,ementa,interesses,url,conclusivo));
        return codigo;
    }
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        if (this.contLeisPLP.containsKey(ano)){
            Integer contador = this.contLeisPLP.get(ano);
            contador++;
            this.contLeisPLP.put(ano,contador);
        } else {
            this.contLeisPLP.put(ano,1);
        }
        String codigo = "PLP " + this.contLeisPLP.get(ano) + "/" + ano;
        this.propostaLeiMap.put(codigo,new PLP(dni,ano,codigo,ementa,interesses,url,artigos));
        return codigo;
    }
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        if (this.contLeisPEC.containsKey(ano)){
            Integer contador = this.contLeisPEC.get(ano);
            contador++;
            this.contLeisPEC.put(ano,contador);
        } else {
            this.contLeisPEC.put(ano,1);
        }
        String codigo = "PEC " + this.contLeisPEC.get(ano) + "/" + ano;
        this.propostaLeiMap.put(codigo,new PEC(dni,ano,codigo,ementa,interesses,url,artigos));
        return codigo;
    }


    public String exibirProjeto(String codigo){
        return this.propostaLeiMap.get(codigo).exibirProjeto();
    }

    public String getLocalAtual(String codigo){
        return this.propostaLeiMap.get(codigo).getComissaoAtual();
    }

    public boolean contemProspota(String codigo){
        return this.propostaLeiMap.containsKey(codigo);
    }

    public String getInteresses(String codigo){
        return this.propostaLeiMap.get(codigo).getInteresses();
    }

    public void proximoLocal(String codigo, String proximoLocal) {
        this.propostaLeiMap.get(codigo).setComissaoAtual(proximoLocal);
    }

    public void adicionaTramitacao(String codigo, String localAtual, String status) {
        this.propostaLeiMap.get(codigo).adicionaTramitacao(localAtual,status);
    }

    public LeiAbstract getProposta(String codigo){
        return this.propostaLeiMap.get(codigo);
    }

    public String getSituacao(String codigo) {
        return this.propostaLeiMap.get(codigo).getSituacao();
    }

    public void setSituacao(String codigo, String situacao){
        this.propostaLeiMap.get(codigo).setSituacao(situacao);
    }

    public String getAutorDNI(String codigo){
        return this.propostaLeiMap.get(codigo).getAutorDNI();
    }

    public void setComissaoAtual(String codigo, String comissaoAtual){
        this.propostaLeiMap.get(codigo).setComissaoAtual(comissaoAtual);
    }
}
