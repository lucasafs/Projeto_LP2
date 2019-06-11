package ECO;

public class PEC extends LeiAbstract {

    private String artigos;

    public PEC(String dni, int ano, String codigo, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, codigo, ementa, interesses, url);
        this.artigos = artigos;
    }

    @Override
    public String exibirProjeto() {
        return "Projeto de Emenda Constitucional - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.artigos + " - " + this.situacao;
    }
}
