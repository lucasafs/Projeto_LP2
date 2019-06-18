package ECO;

public class PL extends LeiAbstract{

    private boolean conclusiva;

    public PL(String dni, int ano, String codigo, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, codigo, ementa, interesses, url);
        this.conclusiva = conclusivo;
    }

    @Override
    public String exibirProjeto() {
        if (this.conclusiva){
            return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - Conclusiva - " + this.situacao;
        } else {
            return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.situacao;
        }
    }

    @Override
    public boolean isConclusiva()
    {
        return this.conclusiva;
    }
}
