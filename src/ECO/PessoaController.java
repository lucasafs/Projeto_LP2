package ECO;


import java.util.HashMap;
import java.util.Map;

import static Util.Validador.*;

public class PessoaController
{
    private Map<String, Pessoa> pessoaMap;

    public PessoaController(){
        this.pessoaMap = new HashMap<>();
    }

    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        validaDNI(dni);
        if (pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        pessoaMap.put(dni, new Pessoa(nome,dni,estado,interesses));
        return true;
    }
    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        validaDNI(dni);
        if (pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        pessoaMap.put(dni, new Pessoa(nome,dni,estado,interesses,partido));
        return true;
    }

    public boolean cadastrarDeputado(String dni, String data)
    {
        validaDNI(dni);

        if (!pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }validaData(data);
        if ("".equals(pessoaMap.get(dni).getPartido().trim())){
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }

        return this.pessoaMap.get(dni).cadastraDeputado(data);

    }

    public String exibirPessoa(String dni){
        validaDNI(dni);
        if (!pessoaMap.containsKey(dni)){
            throw new NullPointerException();
        } else {
            return pessoaMap.get(dni).toString();
        }
    }

}