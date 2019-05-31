package Util;

import java.text.*;
import java.util.*;

public class Validador {

    public Validador(){
        Validador validador = new Validador();
    }

    public static void validaParametrosCadastrarPessoa(String nome, String dni, String estado){
        if ("".equals(nome.trim()) || "".equals(dni.trim()) || "".equals(estado.trim())){
            throw new IllegalArgumentException("Parametro vazio!");
        }
    }

    public static boolean validaDNI(String dni){
        return dni.matches("^[0-9]{9}-[0-9]{1}");
    }

    public static boolean validaData(String data)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("DDMMAAAA");
        Date dataFormatada = null;
        try
        {
            dataFormatada = sdf.parse(data);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        Date dataAtual = new Date();

        if(!data.matches("^[0-9]{8}")){
            return false;
        } else if (dataFormatada.after(dataAtual)){
            return false;
        } else {
            return true;
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("DDMMAAAA");
//        Date dataFormatada = sdf.parse(data);
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(dataFormatada);
//        GregorianCalendar dataAtual = new GregorianCalendar();
//
//        if(!data.matches("^[0-9]{8}")){
//            return false;
//        } else if (cal.after(dataAtual)){
//            return false;
//        } else {
//            return true;
//        }
    }
}
