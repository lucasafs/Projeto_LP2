package ECO;

/**
 * Esta classe define os projetos de lei, tendo como base
 * a classe LeiAbstract.
 */
public class PL extends LeiAbstract{
	/**
	 * Atributo que irá representar se o projeto de Lei 
	 * é conclusivo.
	 */
    private boolean conclusiva;
    /**
     * Cosntrutor que inicializa os atributos relacionados aos
     * projetos de lei, utilizando super para os atributos vindos
     * da classe abstract.
     * @param dni
     * @param ano
     * @param codigo
     * @param ementa
     * @param interesses
     * @param url
     * @param conclusivo
     */
    public PL(String dni, int ano, String codigo, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, codigo, ementa, interesses, url);
        this.conclusiva = conclusivo;
    }
    /**
     * Este método é utilizado para exibir os projetos de lei,
     * é sua representação textual.
     */
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
