package ECO.PROJETOLEI;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Classe abstrata para a criacao de um Projeto de Lei, composta pelo DNI do autor, ano, codigo, ementa, interesses, situacao, comissao que se encontra, artigos e sua tramitacao.
 */
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

    /**
     * Construtor abstrato utilizado para construir um Projeto de Lei.
     * @param dni DNI do autor.
     * @param ano ano de criacao.
     * @param codigo codigo da Lei.
     * @param ementa ementa da Lei.
     * @param interesses interesses da Lei.
     * @param url url do artigo.
     */
    public LeiAbstract(String dni, int ano, String codigo, String ementa, String interesses, String url){
        this.autorDNI = dni;
        this.ano = ano;
        this.codigo = codigo;
        this.ementa = ementa;
        this.interesses = interesses;
        this.url = url;
        this.comissaoAtual = "CCJC";
        this.situacao = "EM VOTACAO";
        this.tramitacao = new LinkedHashMap<>();

    }

    /**
     * Metodo abstrato utilizado para a exibicao do projeto.
     * @return retorna uma String com a exibicao do projeto.
     */
    public abstract String exibirProjeto();

    /**
     * Metodo para acessar a comissao na qual o projeto se encontra atualmente.
     * @return retorna uma String com o tema da comissao atual.
     */
    public String getComissaoAtual() {
        return comissaoAtual;
    }

    /**
     * Metodo para acessar os interesses do projeto.
     * @return retorna uma String com os interesses do projeto.
     */
    public String getInteresses() { return this.interesses; }

    /**
     * Metodo para alterar a comissao que a lei se encontra atualmente.
     * @param comissaoAtual nova comissao.
     */
    public void setComissaoAtual(String comissaoAtual) {
        this.comissaoAtual = comissaoAtual;
    }

    /**
     * Metodo para adicionar a tramitacao a comissao atual e qual seu status.
     * @param localAtual comissao votada.
     * @param status status da Lei em tal comissao, podendo ser EM VOTACAO, APROVADA ou ARQUIVADA.
     */
    public void adicionaTramitacao(String localAtual, String status){
        this.tramitacao.put(localAtual,status);
    }

    /**
     * Metodo abstrato para verificar se o Projeto de Lei e conclusiva.
     * @return retorna true caso seja e false em demais casos.
     */
    public abstract boolean isConclusiva();

    /**
     * Metodo para alterar a situacao atual do Projeto de Lei.
     * @param status Novo status da situacao.
     */
    public void setSituacao(String status){
        this.situacao = status;
    }

    /**
     * Metodo para acessar a situacao na comissao em que se encontra.
     * @return retorna uma String com a situacao e a comissao.
     */
    public String getSituacaoComissao()
    {
        return situacao  + " (" + this.comissaoAtual + ")";
    }

    /**
     * Metodo para acessar a situacao do projeto.
     * @return retorna uma String com a situacao do projeto.
     */
    public String getSituacao()
    {
        return situacao ;
    }

    /**
     * Metodo para acessar o DNI do autor responsavel pelo Projeto de Lei.
     * @return retorna uma String com o DNI do autor.
     */
    public String getAutorDNI() {
        return autorDNI;
    }
    
}
