package ECO.Controladores;

import ECO.PROJETOLEI.LeiAbstract;
import ECO.PROJETOLEI.PEC;
import ECO.PROJETOLEI.PL;
import ECO.PROJETOLEI.PLP;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller com metodos e atributos necessarios para criar e cuidar das Propostas de Leis.
 */
public class PropostaLeiController {

    private Map<String, LeiAbstract> propostaLeiMap;
    private Map<Integer,Integer> contLeisPL;
    private Map<Integer,Integer> contLeisPLP;
    private Map<Integer,Integer> contLeisPEC;
    

    /**
     * Construtor que inicializa um HashMap para armazenar as Propostas de Leis,
     * e inicializa os mapas utilizados para armazenar a contagem de Leis criadas em cada tipo.
     */
    public PropostaLeiController(){
        this.propostaLeiMap = new HashMap<>();
        this.contLeisPL = new HashMap<>();
        this.contLeisPLP = new HashMap<>();
        this.contLeisPEC = new HashMap<>();
    }

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e se e conclusiva.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param conclusivo Atributo que afirma se e conclusiva.
     * @return retorna o codigo da Lei criada.
     */
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

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e os artigos.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param artigos Artigos que a compoem.
     * @return retorna o codigo da Lei criada.
     */
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

    /**
     * Metodo utilizado para cadastrar um Projeto de Lei (PL), com base no DNI do autor, ano, ementa, interesses,
     * url e os artigos.
     * @param dni DNI do autor.
     * @param ano Ano de criacao.
     * @param ementa Ementa do projeto.
     * @param interesses Interesses do projeto.
     * @param url Url do artigo.
     * @param artigos Artigos que a compoem.
     * @return retorna o codigo da Lei criada.
     */
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

    /**
     * Metodo utilizado para exibir a representacao textual de um projeto.
     * @param codigo Codigo do projeto de lei a ser exibido.
     * @return retorn a representacao textual do projeto.
     */
    public String exibirProjeto(String codigo){
        return this.propostaLeiMap.get(codigo).exibirProjeto();
    }

    /**
     * Metodo para acessar o local que o PL se encontra atualmente.
     * @param codigo Codigo do PL que quer ser acessado.
     * @return retorna o local atual.
     */
    public String getLocalAtual(String codigo){
        return this.propostaLeiMap.get(codigo).getComissaoAtual();
    }

    /**
     * Metodo para verificar se tal projeto de lei existe.
     * @param codigo Codigo a ser verificado.
     * @return retorna true caso exista ou false em demais casos.
     */
    public boolean contemProspota(String codigo){
        return this.propostaLeiMap.containsKey(codigo);
    }

    /**
     * Metodo utilizado para acessar os interesses de um determinado projeto.
     * @param codigo Codigo da lei.
     * @return retorna os interesses.
     */
    public String getInteresses(String codigo){
        return this.propostaLeiMap.get(codigo).getInteresses();
    }

    public void adicionaTramitacao(String codigo, String localAtual, String status) {
        this.propostaLeiMap.get(codigo).adicionaTramitacao(localAtual,status);
    }

    /**
     * Metodo utilizado para acessar o Projeto de Lei.
     * @param codigo Codigo do projeto.
     * @return retorna o projeto de lei.
     */
    public LeiAbstract getProposta(String codigo){
        return this.propostaLeiMap.get(codigo);
    }

    /**
     * Metodo utilizado para acessar a situacao atual de um projeto.
     * @param codigo Codigo da lei.
     * @return retorna a situacao atual.
     */
    public String getSituacao(String codigo) {
        return this.propostaLeiMap.get(codigo).getSituacao();
    }

    /**
     * Metodo utilizado para alterar a situacao atual de um projeto.
     * @param codigo Codigo da lei.
     * @param situacao Nova situacao em que se encontra.
     */
    public void setSituacao(String codigo, String situacao){
        this.propostaLeiMap.get(codigo).setSituacao(situacao);
    }

    /**
     * Metodo utilizado para acessar o autor do projeto.
     * @param codigo Codigo da lei.
     * @return retorna o DNI do autor do projeto de lei.
     */
    public String getAutorDNI(String codigo){
        return this.propostaLeiMap.get(codigo).getAutorDNI();
    }

    /**
     * Metodo utilizado para alterar a comissao que o projeto se encontra.
     * @param codigo Codigo da lei.
     * @param comissaoAtual Nova comissao.
     */
    public void setComissaoAtual(String codigo, String comissaoAtual){
        this.propostaLeiMap.get(codigo).setComissaoAtual(comissaoAtual);
    }
    
    public void setSituacaoComissao(String codigo) {
    	String situacao = this.propostaLeiMap.get(codigo).getSituacao();
    	String comissao = this.propostaLeiMap.get(codigo).getComissaoAtual();
    	this.propostaLeiMap.get(codigo).adicionaTramitacao(situacao, comissao);
    }
    
    public String exibirTramitacao(String codigo) {
    	return this.propostaLeiMap.get(codigo).exibirTramitacao();
    }
}
