package ECO;


import ECO.Controladores.ECOntroller;
import easyaccept.EasyAccept;

public class Facade {

    private ECOntroller econtroller;

    public Facade() {
        this.econtroller = new ECOntroller();
    }

    public static void main(String[] args) {
        args = new String[]{"ECO.Facade", "Projeto_LP2/acceptance_test/use_case_1.txt", "Projeto_LP2/acceptance_test/use_case_2.txt", "Projeto_LP2/acceptance_test/use_case_3.txt", "Projeto_LP2/acceptance_test/use_case_4.txt", "Projeto_LP2/acceptance_test/use_case_5.txt", "Projeto_LP2/acceptance_test/use_case_6.txt"};
        EasyAccept.main(args);
    }
//    public static void main(String[] args) {
//        args = new String[]{"ECO.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt", "acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt","acceptance_test/use_case_5.txt","acceptance_test/use_case_6.txt"};
//        EasyAccept.main(args);
//    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        econtroller.cadastrarPessoa(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        econtroller.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        econtroller.cadastrarDeputado(DNI, dataDeInicio);
    }

    public String exibirPessoa(String DNI) {
        return econtroller.exibirPessoa(DNI);
    }

    public void limparSistema() {
    }

    public void salvarSistema() {
    }

    public void carregarSistema(){}

    public void cadastrarPartido(String partido){
        econtroller.cadastrarPartido(partido);
    }

    public String exibirBase(){
        return econtroller.exibirBase();
    }

    public void cadastrarComissao(String tema, String politicos){
        this.econtroller.cadastrarComissao(tema,politicos);
    }

    public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        return this.econtroller.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        return this.econtroller.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        return this.econtroller.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo){
        return this.econtroller.exibirProjeto(codigo);
    }
    
    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal) {
    	return this.econtroller.votarComissao(codigo, statusGovernista, proximoLocal);
    }
    
    public boolean votarPlenario(String codigo, String statusGovernista, String presentes) {
    	return this.econtroller.votarPlenario(codigo, statusGovernista, presentes);
    }
}
