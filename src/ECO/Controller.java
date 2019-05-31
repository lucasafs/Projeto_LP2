package ECO;


import java.util.HashMap;
import java.util.Map;

import static Util.Validador.*;

public class Controller
{
    private Map<String, Pessoa> pessoaMap;

    public Controller(){
        this.pessoaMap = new HashMap<>();
    }

    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (!validaDNI(dni)){
            throw new IllegalArgumentException("DNI Invalido!");
        }
        if (pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("DNI já cadastrado!");
        }
        pessoaMap.put(dni, new Pessoa(nome,dni,estado,interesses));
        return true;
    }
    public boolean cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido){
        validaParametrosCadastrarPessoa(nome,dni,estado);
        if (!validaDNI(dni)){
            throw new IllegalArgumentException("DNI Invalido!");
        }
        if (pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("DNI já cadastrado!");
        }
        pessoaMap.put(dni, new Pessoa(nome,dni,estado,interesses,partido));
        return true;
    }

    public boolean cadastrarDeputado(String dni, String data)
    {
        if (!validaDNI(dni)){
            throw new IllegalArgumentException("DNI Invalido!");
        }
        if (!pessoaMap.containsKey(dni)){
            throw new IllegalArgumentException("DNI não cadastrado!");
        }
        if ("".equals(pessoaMap.get(dni).getPartido().trim())){
            throw new IllegalArgumentException("Pessoa sem partido!");
        }
        if (!validaData(data)){
            throw new IllegalArgumentException("Data irregular!");
        }
        return this.pessoaMap.get(dni).cadastraDeputado(data);

    }

    public String exibirPessoa(String dni){
        if (!validaDNI(dni)){
            throw new IllegalArgumentException("DNI Invalido!");
        } else if (!pessoaMap.containsKey(dni)){
            throw new NullPointerException();
        } else {
            return pessoaMap.get(dni).toString();
        }
    }

}
