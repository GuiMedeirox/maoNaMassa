package models;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa{

    private String funcao;
    private BigDecimal salario;
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal valor) {
        this.salario = valor;
    }

    public Funcionario(String nome, String dataNascimento, String funcao, String valor){
        super(nome,dataNascimento);
        this.funcao = funcao;
        this.salario = new BigDecimal(valor);
    }

    @Override
    public String toString() {
        return "NOME " +super.getNome() +" NASCIMENTO " +super.formatarDataNascimento(getDataNascimento())
                +" SALARIO " +formatarSalario(getSalario()) +" FUNCAO " +getFuncao() +"\n";
    }

    private String formatarSalario(BigDecimal salario) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMANY); //a notação da alemanha atende à ideia pedida
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(salario);
    }
}