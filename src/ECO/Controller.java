package ECO;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static Util.Validador.*;

public class Controller
{
    private Map<String, Pessoa> pessoaMap;
    private Set<String> partidoMap;

    public Controller(){
        this.pessoaMap = new HashMap<>();
        this.partidoMap = new TreeSet<>();
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

    /**
     * cadastra um partido atravez do sei nome, ignora repeticoes
     * @param partido String contendo o nome do partido
     */
    public void cadastraPartido(String partido){
        if(partido == null || partido.equals("")) throw new IllegalArgumentException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        partidoMap.add(partido);
    }

    /**
     * nome de todos os partidos ordenados em ordem lexografica
     * @return string contendo o nome de todos os partidos
     */
    public String exibirBase(){
        String ans = "";
        for(String it : partidoMap){
            ans += it + ",";
        }
        return (ans.length() > 0 ? ans.substring(0, ans.length()-1) : ans);
    }

}
