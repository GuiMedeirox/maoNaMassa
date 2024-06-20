import controllers.funcionarioController;
import models.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        //3.1
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        funcionarioController.inserirFuncionarios(listaFuncionarios);
        System.out.println("Funcionarios inseridos com sucesso.");
        System.out.println("--------------------------");
        //3.2
        funcionarioController.removerJoao(listaFuncionarios);
        System.out.println("Joao removido com sucesso.");
        System.out.println("--------------------------");
        //3.3.1 e 3.3.2
        funcionarioController.listarFuncionarios(listaFuncionarios);
        System.out.println("--------------------------");
        //3.4 + listagem para ver novo salário
        funcionarioController.bonusDezPorCento(listaFuncionarios);
        funcionarioController.listarFuncionarios(listaFuncionarios);
        System.out.println("--------------------------");
        //3.5
        Map<String, List<Funcionario>> funcionariosAgrupadosFuncao = funcionarioController.agruparPorFuncao(listaFuncionarios);
        System.out.println("Funcionarios agrupados com sucesso.");
        System.out.println("--------------------------");
        //3.6
        funcionarioController.listarFuncionariosAgrupados(funcionariosAgrupadosFuncao);
        System.out.println("--------------------------");
        //3.8 (não tem 3.6 na lista)
        funcionarioController.listarFuncionariosAniversariantesOutDez(listaFuncionarios);
        System.out.println("--------------------------");
        //3.9
        System.out.println(funcionarioController.listarMaisVelho(listaFuncionarios));
        System.out.println("--------------------------");
        //3.10
        funcionarioController.listarOrdemAlfabetica(listaFuncionarios);
        System.out.println("--------------------------");
        //3.11
        funcionarioController.somatorioSalarioFuncionarios(listaFuncionarios);
        System.out.println("--------------------------");
        //3.12
        funcionarioController.quantosSalariosMinimos(listaFuncionarios);
        System.out.println("--------------------------");
    }
}