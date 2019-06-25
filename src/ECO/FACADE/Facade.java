package ECO.FACADE;


import ECO.Controladores.ECOntroller;
import easyaccept.EasyAccept;
/**
 * Esta classe define a fachada do sistema.
 */
public class Facade {
	/**
	 * Atributo que representa o Econtroller do tipo ECOntroller.
	 */
    private ECOntroller econtroller;
    /**
     * Construtor que inicializa o ECOntroller.
     */
    public Facade() {
        this.econtroller = new ECOntroller();
    }
    /**
     * Main para determinar o caminho para os casos de teste.
     * @param args
     */
    public static void main(String[] args) {
        args = new String[]{"ECO.FACADE.Facade", "Projeto_LP2/acceptance_test/use_case_1.txt", "Projeto_LP2/acceptance_test/use_case_2.txt", "Projeto_LP2/acceptance_test/use_case_3.txt", "Projeto_LP2/acceptance_test/use_case_4.txt", "Projeto_LP2/acceptance_test/use_case_5.txt", "Projeto_LP2/acceptance_test/use_case_6.txt","Projeto_LP2/acceptance_test/use_case_7.txt"};
        EasyAccept.main(args);
    }
//    public static void main(String[] args) {
//        args = new String[]{"ECO.FACADE.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt","acceptance_test/use_case_5.txt","acceptance_test/use_case_6.txt","acceptance_test/use_case_7.txt"};
//        EasyAccept.main(args);
//    }
    /**
     * Método utilizado para o cadastro de pessoa que não possui um partido.
     * @param nome
     * @param dni
     * @param estado
     * @param interesses
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        econtroller.cadastrarPessoa(nome, dni, estado, interesses);
    }
    /**
     * Método utilizado para cadastro de pessoa que possui partido.
     * @param nome
     * @param dni
     * @param estado
     * @param interesses
     * @param partido
     */
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        econtroller.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }
    /**
     * Método utilizado para o cadastrode deputados.
     * @param DNI
     * @param dataDeInicio
     */
    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        econtroller.cadastrarDeputado(DNI, dataDeInicio);
    }
    /**
     * Métodp utilizado para exibir pessoa a partir de seu DNI.
     * @param DNI
     * @return
     */
    public String exibirPessoa(String DNI) {
        return econtroller.exibirPessoa(DNI);
    }
    /**
     * Método para limpar o sistema.
     */
    public void limparSistema() {
    }
    /**
     * Método utilizado para salval o sistema.
     */
    public void salvarSistema() {
    }
    /**
     * Método utilizado para carregar o sistema.
     */
    public void carregarSistema(){}
    /**
     * Método utilizado para cadastrar um partido.
     * @param partido
     */
    public void cadastrarPartido(String partido){
        econtroller.cadastrarPartido(partido);
    }
    /**
     * Método utilizado para exibir Base.
     * @return
     */
    public String exibirBase(){
        return econtroller.exibirBase();
    }
    /**
     * Método utilizado para cadastrar uma comissão a partir do seu tema e deputados.
     * @param tema
     * @param politicos
     */
    public void cadastrarComissao(String tema, String politicos){
        this.econtroller.cadastrarComissao(tema,politicos);
    }
    /**
     * Método utilizado para cadstrar uma PL a partir desses parâmetros passados.
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param conclusivo
     * @return
     */
    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        return this.econtroller.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }
    /**
     * Método utilizado para cadstrar PLP.
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param artigos
     * @return
     */
    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        return this.econtroller.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }
    /**
     * Método utilizado para cadastrar PEC.
     * @param dni
     * @param ano
     * @param ementa
     * @param interesses
     * @param url
     * @param artigos
     * @return
     */
    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        return this.econtroller.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }
    /**
     * Método utilizado para exibir projeto.
     * @param codigo
     * @return
     */
    public String exibirProjeto(String codigo){
        return this.econtroller.exibirProjeto(codigo);
    }
    /**
     * Método utilizado para os votos de uma comissão.
     * @param codigo
     * @param statusGovernista
     * @param proximoLocal
     * @return
     */
    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
    	return this.econtroller.votarComissao(codigo, statusGovernista, proximoLocal);
    }
    /**
     * Método utilizado para votos no plenário.
     * @param codigo
     * @param statusGovernista
     * @param presentes
     * @return
     */
    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
    	return this.econtroller.votarPlenario(codigo, statusGovernista, presentes);
    }
}
