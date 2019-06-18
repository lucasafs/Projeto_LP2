package ECO;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class LeiAbstract{

    protected String autorDNI;
    private int ano;
    protected String codigo;
    protected String ementa;
    protected String interesses;
    protected String situacao;
    protected String comissaoAtual;
    protected String url;
    protected Map<String,String> tramitacao;
    protected boolean trami;

    public LeiAbstract(String dni, int ano, String codigo, String ementa, String interesses, String url){
        this.autorDNI = dni;
        this.ano = ano;
        this.codigo = codigo;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
        this.comissaoAtual = "CCJC";
        this.situacao = "EM VOTACAO (" + this.comissaoAtual + ")";
        this.tramitacao = new LinkedHashMap<>();
        this.trami = true;

    }

    public abstract String exibirProjeto();

    public String getComissaoAtual() {
        return comissaoAtual;
    }

    public String getInteresses() { return this.interesses; }

    public void setComissaoAtual(String comissaoAtual) {
        this.comissaoAtual = comissaoAtual;
    }

    public void adicionaTramitacao(String localAtual, String status){
        this.tramitacao.put(localAtual,status);
    }

    public abstract boolean isConclusiva();

    public void setSituacao(String status){
        this.situacao = status + " (" + this.comissaoAtual + ")";
    }

    public void setTrami(boolean trami)
    {
        this.trami = trami;
    }

    public boolean isTrami()
    {
        return trami;
    }

    //public boolean votarComissao(String statusGovernista, String proximoLocal) {
    	
    
}
