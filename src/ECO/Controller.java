package ECO;

import java.util.Map;

public class Controller
{
    private Map<String, Pessoa> pessoaMap;

    public String exibirPessoa(String dni){
        if (!dni.matches("^[0-9]{9}-[0-9]{1}")){
            throw new IllegalArgumentException("DNI Invalido!");
        } else if (!pessoaMap.containsKey(dni)){
            throw new NullPointerException();
        } else {
            return pessoaMap.get(dni).toString();
        }
    }

}
