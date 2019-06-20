package ECO.Controladores;


import ECO.PESSOA.Pessoa;
import ECO.PESSOA.PessoaComPartido;
import ECO.PESSOA.PessoaSemPartido;

import java.util.*;

import static Util.Validador.*;

public class PessoaController
{
    private Map<String, Pessoa> pessoaMap;

    public PessoaController(){
        this.pessoaMap = new TreeMap<>();
    }

    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (this.pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoaMap.put(dni, new PessoaSemPartido(nome,dni,estado,interesses));
        return true;
    }
    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (this.pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        this.pessoaMap.put(dni, new PessoaComPartido(nome,dni,estado,interesses,partido));
        return true;
    }

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

    public String exibirPessoa(String dni){
        validaDNIExibirPessoa(dni);
        if (!pessoaMap.containsKey(dni)){
            throw new NullPointerException("Erro ao exibir pessoa: pessoa nao encontrada");
        }
        return this.pessoaMap.get(dni).exibirPessoa();
    }

    public Pessoa getDeputadoComissao(String dni){
        verificaDeputado(dni,"Erro ao cadastrar comissao:");
        return this.pessoaMap.get(dni);
    }

    public void verificaDeputadoProjeto(String dni){
        verificaDeputado(dni,"Erro ao cadastrar projeto:");
    }

    public void verificaDeputado(String dni,String erro){
        if (!this.pessoaMap.containsKey(dni)){
            throw new NullPointerException(erro + " pessoa inexistente");
        }
        if (this.pessoaMap.get(dni).getFuncao() == (null)){
            throw new IllegalArgumentException(erro + " pessoa nao eh deputado");
        }
    }

    public boolean contemPessoa(String dni) {
        return this.pessoaMap.containsKey(dni);
    }

    public void criaLeis(String autorDNI) {
        Pessoa pessoa = this.pessoaMap.get(autorDNI);
        PessoaComPartido pessoaComPartido = (PessoaComPartido) pessoa;
        pessoaComPartido.criaLei();
    }
}
