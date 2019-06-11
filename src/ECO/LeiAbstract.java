package ECO;

public abstract class LeiAbstract implements PropostaLei {

    protected String autorDNI;
    private int ano;
    protected String codigo;
    protected String ementa;
    protected String interesses;
    protected String situacao;
    protected String url;

    public LeiAbstract(String dni, int ano, String codigo, String ementa, String interesses, String url){
        this.autorDNI = dni;
        this.ano = ano;
        this.codigo = codigo;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
        this.situacao = "EM VOTACAO (CCJC)";
    }

    public abstract String exibirProjeto();
}
