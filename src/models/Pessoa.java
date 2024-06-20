package models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String formatarDataNascimento(LocalDate data){
        return dataNascimento.getDayOfMonth()+"/"+dataNascimento.getMonthValue()+"/"+dataNascimento.getYear();
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
    }

    public Pessoa(String nome, String dataNascimento){
        this.nome=nome;
        this.setDataNascimento(dataNascimento);
    }
}

