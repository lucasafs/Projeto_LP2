package ECO;

public class Pessoa {

    private String nome;
    private String dni;
    private String estado;
    private String interesses;
    private String partido;
    private Funcao funcao;

    public Pessoa(String nome, String dni, String estado, String interesses){
        this.nome = nome;
        this.dni = dni;
        this.estado = estado;
        this.interesses = interesses;
        this.partido = "";
    }
    public Pessoa(String nome, String dni, String estado, String interesses, String partido){
        this.nome = nome;
        this.dni = dni;
        this.estado = estado;
        this.interesses = interesses;
        this.partido = partido;
    }

    public boolean cadastraDeputado(String data){
        this.funcao = new Deputado(data);
        return true;
    }

    public String getPartido()
    {
        return partido;
    }

    @Override
    public String toString()
    {
        if (funcao.equals(null)){
            if ("".equals(this.interesses.trim()) && "".equals(this.partido.trim())){
                return this.nome + " - " + this.dni + " (" + this.estado + ")";
            } else if (!"".equals(this.partido.trim()) && "".equals(this.interesses.trim())){
                return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido;
            } else if (!"".equals(interesses) && "".equals(partido.trim())){
                return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.interesses;
            } else {
                return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - Interesses: " + this.interesses;
            }
        } else {
            if ("".equals(interesses.trim())){
                return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - " + this.funcao.toString();
            } else {
                return this.nome + " - " + this.dni + " (" + this.estado + ") - " + this.partido + " - Interesses: " + this.interesses + " - " + this.funcao.toString();
            }
        }
    }
}
