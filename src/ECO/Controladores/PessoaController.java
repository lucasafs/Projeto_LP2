package ECO.Controladores;

import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import ECO.PESSOA.PessoaSemPartido;

import java.util.*;

import static Util.Validador.*;

/**
 * Controller que contem metodos e atributos utilizados para criar e cuidar de Pessoa.
 */
public class PessoaController {
    private Map<String, Pessoa> pessoaMap;

    /**
     * Construtor que inicializa o Mapa de Pessoas.
     */
    public PessoaController(){
        this.pessoaMap = new TreeMap<>();
    }

    /**
     * Metodo utilizado para relizar o cadastro de Pessoa.
     * @param nome Nome da pessoa
     * @param dni DNI da pessoa.
     * @param estado Estado no qual a Pessoa se encontra.
     * @param interesses Interesses da pessoa.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (this.pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoaMap.put(dni, new PessoaSemPartido(nome,dni,estado,interesses));
        return true;
    }

    /**
     * Metodo utilizado para relizar o cadastro de Pessoa.
     * @param nome Nome da pessoa
     * @param dni DNI da pessoa.
     * @param estado Estado no qual a Pessoa se encontra.
     * @param interesses Interesses da pessoa.
     * @param partido Partido que a pessoa apoia.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (this.pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoaMap.put(dni, new PessoaComPartido(nome,dni,estado,interesses,partido));
        return true;
    }

    /**
     * Metodo utilizado para realizar o Cadastro de um Deputado.
     * @param dni DNI da pessoa.
     * @param data Data de inicio da vida publica.
     * @return retorna true caso consiga realizar o cadastro.
     */
    public boolean cadastrarDeputado(String dni, String data)
    {
        validaDNICadastrarDeputado(dni);
        if (!this.pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }validaData(data);
        if (this.pessoaMap.get(dni) instanceof PessoaSemPartido){
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }
        return this.pessoaMap.get(dni).cadastraDeputado(data);
    }

    /**
     * Metodo utilizado para exibir pessoa.
     * @param dni DNI da pessoa a ser exibida.
     * @return retorna uma String com a representacao textual de pessoa.
     */
    public String exibirPessoa(String dni){
        validaDNIExibirPessoa(dni);
        if (!pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao exibir pessoa: pessoa nao encontrada");
        }
        return this.pessoaMap.get(dni).exibirPessoa();
    }

    /**
     * Metodo para acessar um Deputado.
     * @param dni DNI do deputado.
     * @return retorna o Deputado.
     */
    public Pessoa getDeputadoComissao(String dni){
        verificaDeputado(dni,"Erro ao cadastrar comissao:");
        return this.pessoaMap.get(dni);
    }

    /**
     * Metodo utilizado para verificar se tal pessoa e um Deputado.
     * @param dni DNI da pessoa a ser verificada.
     * @param erro Mensagem de erro a ser repassado, caso venha a acontecer.
     */
    public void verificaDeputado(String dni,String erro){
        if (!this.pessoaMap.containsKey(dni)){
            throw new NullPointerException(erro + " pessoa inexistente");
        }
        if (this.pessoaMap.get(dni).getFuncao() == (null)){
            throw new IllegalArgumentException(erro + " pessoa nao eh deputado");
        }
    }

    /**
     * Metodo para incrementar o contador de Leis criadas por um Deputado.
     * @param autorDNI DNI do autor da Lei.
     */
    public void criaLeis(String autorDNI) {
        Pessoa pessoa = this.pessoaMap.get(autorDNI);
        PessoaComPartido pessoaComPartido = (PessoaComPartido) pessoa;
        pessoaComPartido.criaLei();
    }

    /**
     * Metodo para contabilizar quantos Deputados existe cadastrado atualmente.
     * @return retorna o numero total de deputados cadastrados.
     */
    public int totalDeputados(){
        int cont = 0;
        for (Pessoa pessoa: this.pessoaMap.values()){
            if (pessoa.getFuncao() != null){
                cont++;
            }
        }
        return cont;
    }
}
