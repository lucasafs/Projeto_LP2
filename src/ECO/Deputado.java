package ECO;

import java.text.SimpleDateFormat;

public class Deputado implements Funcao {

    private String data;

    public Deputado(String data){
        this.data = data;
    }

    @Override
    public String toString()
    {
        return data.substring(0,1)+"/"+data.substring(2,3)+"/"+data.substring(4,7);
    }
}
