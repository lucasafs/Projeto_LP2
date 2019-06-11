package ECO;

import java.util.ArrayList;
import java.util.Arrays;

import static Util.Validador.*;

public class ECOntroller {

    private PessoaController pessoaController;
    private ComissaoController comissaoController;
    private PropostaLeiController propostaLeiController;

    public ECOntroller() {
        this.pessoaController = new PessoaController();
        this.comissaoController = new ComissaoController();
        this.propostaLeiController = new PropostaLeiController();
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses);
    }

    public void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
        pessoaController.cadastrarPessoa(nome, dni, estado, interesses, partido);
    }

    public void cadastrarDeputado(String DNI, String dataDeInicio) {
        pessoaController.cadastrarDeputado(DNI, dataDeInicio);
    }

    public String exibirPessoa(String DNI) {
        return pessoaController.exibirPessoa(DNI);
    }

    public void cadastrarPartido(String partido){
        pessoaController.cadastraPartido(partido);
    }

    public String exibirBase(){
        return pessoaController.exibirBase();
    }

    public void cadastrarComissao(String tema, String politicos){
        validaComissao(tema,politicos);
        if (this.comissaoController.contemComissao(tema)){
            throw new IllegalArgumentException("Erro ao cadastrar comissao: tema existente");
        }
        ArrayList<Pessoa> deputados = new ArrayList<>();
        String[] dnis = politicos.split(",");
        for (String dni: dnis){
            validaDNICadastrarComissao(dni);
            deputados.add(this.pessoaController.getDeputadoComissao(dni));
        }
        this.comissaoController.cadastrarComissao(tema,deputados);
    }

    public void cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo){
        validaCadastroLei(dni,ano,ementa,interesses,url);
        validaDNICadastroProjeto(dni);
        this.propostaLeiController.cadastrarPL(dni, ano, ementa, interesses, url, conclusivo);
    }

    public void cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.propostaLeiController.cadastrarPLP(dni, ano, ementa, interesses, url, artigos);
    }

    public void cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos){
        validaCadastroLei(dni, ano, ementa, interesses, url, artigos);
        validaDNICadastroProjeto(dni);
        this.propostaLeiController.cadastrarPEC(dni, ano, ementa, interesses, url, artigos);
    }

    public String exibirProjeto(String codigo){
        return this.propostaLeiController.exibirProjeto(codigo);
    }
}
