package ECO.Controladores;


import ECO.Pessoa;
import ECO.PessoaComPartido;
import ECO.PessoaSemPartido;

import java.util.*;

import static Util.Validador.*;

public class PessoaController
{
    private Map<String, Pessoa> pessoaMap;
    private Set<String> partidoMap;

    public PessoaController(){
        this.pessoaMap = new TreeMap<>();
        this.partidoMap = new TreeSet<>();
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

    /**
     * cadastra um partido atravez do seu nome, ignora repetições
     * @param partido String contendo o nome do partido
     */
    public void cadastraPartido(String partido){
        if(partido == null || partido.equals("")) throw new NullPointerException("Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
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

    public Pessoa getDeputadoComissao(String dni){
        verificaDeputado(dni,"Erro ao cadastrar comissao:");
        return this.pessoaMap.get(dni);
    }

    public void verificaDeputadoProjeto(String dni){
        verificaDeputado(dni,"Erro ao cadastrar projeto:");
    }

    private void verificaDeputado(String dni,String erro){
        if (!this.pessoaMap.containsKey(dni)){
            throw new NullPointerException(erro + " pessoa inexistente");
        }
        if (this.pessoaMap.get(dni).getFuncao() == (null)){
            throw new IllegalArgumentException(erro + " pessoa nao eh deputado");
        }
    }

}
