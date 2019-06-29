package ECO.PROJETOLEI;

/**
 * Esta classe define uma Proposta de Emenda a Constituicao (PEC), que extende a classa abstract LeiAbstract.
 */
public class PEC extends LeiAbstract {

    private String artigos;

    /**
     * Construtor utilizado para construir uma Proposta de Emenda a Constituicao, com base no DNI do autor, ano, codigo,
     * ementa, interesses, url e os artigos.
     * @param dni DNI do autor.
     * @param ano ano de criacao.
     * @param codigo codigo da Lei.
     * @param ementa ementa da Lei.
     * @param interesses interesses da Lei.
     * @param url url do artigo.
     * @param artigos artigos que a compoem.
     */
    public PEC(String dni, int ano, String codigo, String ementa, String interesses, String url, String artigos) {
        super(dni, ano, codigo, ementa, interesses, url);
        this.artigos = String.join(", ",artigos.split(","));
    }

    /**
     * Metodo utilizado para a exibicao do projeto.
     * @return retorna uma String com a exibicao do projeto.
     */
    @Override
    public String exibirProjeto() {
        if (this.situacao.equals("EM VOTACAO")){
            return "Projeto de Emenda Constitucional - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.artigos + " - " + super.getSituacaoComissao();
        }
        return "Projeto de Emenda Constitucional - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.artigos + " - " + super.getSituacao();
    }

    /**
     * Metodo para verificar se o Projeto de Lei e conclusiva.
     * @return retorna true caso seja e false em demais casos.
     */
    @Override
    public boolean isConclusiva()
    {
        return false;
    }
}
