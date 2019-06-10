package ECO;

import java.text.SimpleDateFormat;

public class Deputado implements Funcao {

    private String data;
    private int leis;

    public Deputado(String data){
        this.data = data;
        this.leis = 0;
    }

    @Override
    public String toString()
    {
        return data.substring(0,2)+"/"+data.substring(2,4)+"/"+data.substring(4,8) + " - " + this.leis + " Leis";
    }
}
