package ECO.PROJETOLEI;

/**
 * Esta classe define um Projeto de Lei (PL), que extende a classa abstract LeiAbstract.
 */
public class PL extends LeiAbstract{

    private boolean conclusiva;

    /**
     * Construtor utilizado para construir uma Proposta de Emenda a Constituicao, com base no DNI do autor, ano, codigo,
     * ementa, interesses, url e os artigos.
     * @param dni DNI do autor.
     * @param ano ano de criacao.
     * @param codigo codigo da Lei.
     * @param ementa ementa da Lei.
     * @param interesses interesses da Lei.
     * @param url url do artigo.
     * @param conclusivo parametro booleano que informa se a PL e conclusiva ou nao.
     */
    public PL(String dni, int ano, String codigo, String ementa, String interesses, String url, boolean conclusivo){
        super(dni, ano, codigo, ementa, interesses, url);
        this.conclusiva = conclusivo;
    }

    /**
     * Metodo utilizado para a exibicao do projeto.
     * @return retorna uma String com a exibicao do projeto.
     */
    @Override
    public String exibirProjeto() {
        if (this.conclusiva){
            if (this.situacao.equals("EM VOTACAO")){
                return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - Conclusiva - " + super.getSituacaoComissao();
            }
            return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - Conclusiva - " + super.getSituacao();
        } else {
            if (this.situacao.equals("EM VOTACAO")){
                return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + super.getSituacaoComissao();
            }
            return "Projeto de Lei - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + super.getSituacao();
        }
    }

    /**
     * Metodo para verificar se o Projeto de Lei e conclusiva.
     * @return retorna true caso seja e false em demais casos.
     */
    @Override
    public boolean isConclusiva()
    {
        return this.conclusiva;
    }
}
