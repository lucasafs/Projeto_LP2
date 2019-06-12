package Util;

import java.text.*;
import java.util.*;

public class Validador {

    public Validador() {

    }

    public static void validaParametrosCadastrarPessoa(String nome, String dni, String estado){
        if (nome == null || "".equals(nome.trim()))throw new IllegalArgumentException("Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        if (dni == null || "".equals(dni.trim())) throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        if (estado == null || "".equals(estado.trim())) throw new IllegalArgumentException("Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validaDNI(dni, "Erro ao cadastrar pessoa:");
    }
    public static void validaDNICadastrarDeputado(String dni){
        validaDNI(dni, "Erro ao cadastrar deputado:");
    }
    public static void validaDNIExibirPessoa(String dni){
        validaDNI(dni,"Erro ao exibir pessoa:");
    }
    public static void validaDNICadastrarComissao(String dni){
        validaDNI(dni,"Erro ao cadastrar comissao:");
    }
    public static void validaDNICadastroProjeto(String dni){
        validaDNI(dni,"Erro ao cadastrar projeto:");
    }

    public static void validaDNI(String dni, String erro) {
        if (dni == null || "".equals(dni.trim())) throw new IllegalArgumentException(erro + " dni nao pode ser vazio ou nulo");
        if (!dni.matches("^[0-9]{9}-[0-9]{1}")) throw new IllegalArgumentException(erro + " dni invalido");
    }

    public static void validaData(String data) {
        if (data == null || "".equals(data.trim())) throw new IllegalArgumentException("Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date dataFormatada = null;
        try {
            sdf.setLenient(false);
            dataFormatada = sdf.parse(data);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data invalida");
        }
        Date dataAtual = new Date();

        if (!data.matches("^[0-9]{8}")) {
            throw new IllegalArgumentException("Data formatada errada");
        } else if (dataFormatada.after(dataAtual)) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: data futura");
        }
    }
    public static void validaComissao(String tema, String deputados){
        if (tema == null || "".equals(tema.trim())) throw new IllegalArgumentException("Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        if (deputados == null || "".equals(deputados.trim())) throw new IllegalArgumentException("Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
    }

    public static void validaCadastroLei(String dni, int ano, String ementa, String interesses, String url){
        if (dni == null || "".equals(dni.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        if (ementa == null || "".equals(ementa.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        if (interesses == null || "".equals(interesses.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        if (url == null || "".equals(url.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
    }
    public static void validaCadastroLei(String dni, int ano, String ementa, String interesses, String url, String artigos){
        if (dni == null || "".equals(dni.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
        if (ementa == null || "".equals(ementa.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
        if (interesses == null || "".equals(interesses.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
        if (url == null || "".equals(url.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
        if (artigos == null || "".equals(artigos.trim())) throw new IllegalArgumentException("Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
    }
}
