package ECO.PROJETOLEI;

/**
 * Esta classe define um Projeto de Lei Complementar (PLP), que extende a classa abstract LeiAbstract.
 */
public class PLP extends LeiAbstract{

    private String artigos;

    /**
     * Construtor utilizado para construir um Projeto de Lei Complementar, com base no DNI do autor, ano, codigo,
     * ementa, interesses, url e os artigos.
     * @param dni DNI do autor.
     * @param ano ano de criacao.
     * @param codigo codigo da Lei.
     * @param ementa ementa da Lei.
     * @param interesses interesses da Lei.
     * @param url url do artigo.
     * @param artigos artigos que a compoem.
     */
    public PLP(String dni, int ano, String codigo, String ementa, String interesses, String url, String artigos){
        super(dni,ano,codigo,ementa,interesses,url);
        this.artigos = String.join(", ",artigos.split(","));
    }

    /**
     * Metodo utilizado para a exibicao do projeto.
     * @return retorna uma String com a exibicao do projeto.
     */
    @Override
    public String exibirProjeto() {
        if (this.situacao.equals("EM VOTACAO")){
            return "Projeto de Lei Complementar - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.artigos + " - " + super.getSituacaoComissao();
        }
        return "Projeto de Lei Complementar - " + this.codigo + " - " + this.autorDNI + " - " + this.ementa + " - " + this.artigos + " - " + super.getSituacao();
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
