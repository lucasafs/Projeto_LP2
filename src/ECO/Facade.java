package ECO;


import easyaccept.EasyAccept;

public class Facade {
    private PessoaController controller;

    public Facade() {
        this.controller = new PessoaController();
    }

    public static void main(String[] args) {
        args = new String[]{"ECO.Facade", "Projeto_LP2/acceptance_test/use_case_1.txt", "Projeto_LP2/acceptance_test/use_case_2.txt", "Projeto_LP2/acceptance_test/use_case_3.txt", "Projeto_LP2/acceptance_test/use_case_4.txt"};
        EasyAccept.main(args);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        controller.cadastrarPessoa(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        controller.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        controller.cadastrarDeputado(DNI, dataDeInicio);
    }

    public String exibirPessoa(String DNI) {
        return controller.exibirPessoa(DNI);
    }

    public void limparSistema() {
    }

    public void salvarSistema() {
    }

    public void carregarSistema(){}
}
