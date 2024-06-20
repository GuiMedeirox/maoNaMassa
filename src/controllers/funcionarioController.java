package controllers;
import models.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


public class funcionarioController {

    public static void inserirFuncionarios(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.add(new Funcionario("Maria", "18/10/2000", "Operador", "2009.44"));
        listaFuncionarios.add(new Funcionario("João", "12/05/1990", "Operador", "2284.38"));
        listaFuncionarios.add(new Funcionario("Caio", "02/05/1961", "Coordenador", "9836.14"));
        listaFuncionarios.add(new Funcionario("Miguel", "14/10/1988", "Diretor", "19119.88"));
        listaFuncionarios.add(new Funcionario("Alice", "05/01/1995", "Recepcionista", "2234.68"));
        listaFuncionarios.add(new Funcionario("Heitor", "19/11/1999", "Operador", "1582.72"));
        listaFuncionarios.add(new Funcionario("Arthur", "31/03/1993", "Contador", "4071.84"));
        listaFuncionarios.add(new Funcionario("Laura", "08/07/1994", "Gerente", "3017.45"));
        listaFuncionarios.add(new Funcionario("Heloísa", "24/05/2003", "Eletricista", "1606.85"));
        listaFuncionarios.add(new Funcionario("Helena", "02/09/1996", "Gerente", "2799.93"));
    }

    public static void removerJoao(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.removeIf(f -> f.getNome().equals("João"));
    }


    public static void listarFuncionarios(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.forEach(System.out::println);
    }

    public static void bonusDezPorCento(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.forEach(f ->{
            //110% = salario + (10% * salario)
            BigDecimal novoSalario = f.getSalario().add(
                    f.getSalario().multiply(new BigDecimal("0.1"))
            );
            f.setSalario(novoSalario);
        });
    }

    public static Map<String, List<Funcionario>> agruparPorFuncao(ArrayList<Funcionario> listaFuncionarios) {
        return listaFuncionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public static void listarFuncionariosAgrupados(Map<String, List<Funcionario>> mapFuncionarios) {
        mapFuncionarios.forEach((funcao, lista) -> {
            System.out.println("Nome da funcao: " + funcao);
            lista.forEach(f ->
                    System.out.println( f.getNome() )
            );
        });
    }

    public static void listarFuncionariosAniversariantesOutDez(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.forEach(f -> {
            if(f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12){
                System.out.println(f.getNome() +" data: " +f.formatarDataNascimento(f.getDataNascimento()));
            }
        });
    }

    public static Optional<Funcionario> listarMaisVelho(ArrayList<Funcionario> listaFuncionarios) {
        return listaFuncionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));
    }

    public static void listarOrdemAlfabetica (ArrayList<Funcionario> listaFuncionarios) {
           listaFuncionarios.stream()
                   .sorted(Comparator.comparing(Funcionario::getNome))
                   .forEach(System.out::println);
    }

    public static void somatorioSalarioFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        System.out.println( "Somatorio dos salarios: " +listaFuncionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add));

    }

    public static void quantosSalariosMinimos(ArrayList<Funcionario> listaFuncionarios){
        listaFuncionarios.forEach(f->{
            System.out.println("Funcionario: " +f.getNome());
            System.out.println("Quantos salarios minimos recebe aproximadamente: "+f.getSalario().divide(new BigDecimal("1212.00"),2, RoundingMode.UP));
        });
    }
}