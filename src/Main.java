import br.com.protheratest.models.Employee;
import br.com.protheratest.service.Services;

import java.util.*;
import java.util.function.DoublePredicate;

@SuppressWarnings("All")
public class Main {
    public static void main(String[] args) {


        //OBS: Separei métodos na classe serviço, para poluir o menos possível o Main
        Services operacoes = new Services();


        // 3.1 - Instanciando todos os funcionários na ordem da tabela
        List<Employee> employees = operacoes.instantiateEmployees();



        // 3.2 - Removendo o funcionário joão
        operacoes.removeEmployee(employees, "João");


        // 3.3 - Imprimindo os funcionários da lista com as informações formatadas
        operacoes.printEmployees(employees);
        System.out.println();


        // 3.4 - Aumento Salarial de 10%
        operacoes.salaryIncrease(employees, 10);
        operacoes.printEmployees(employees);
        System.out.println();


        // 3.6 - Imprimindo funcionarios agrupados por função
        //OBS: Após ordenar, não estou conseguindo formatar da mesma maneira que uma List, para impressão.
        operacoes.groupByFunction(employees);
        System.out.println();


        // 3.8 - Imprimindo funcionários que fazem aniversário no mês 10 e 12
        operacoes.printBirthdays(employees, 10);
        operacoes.printBirthdays(employees, 12);
        System.out.println();


        // 3.9 - Imprimindo funcionário com a maior idade
        operacoes.printEmployeeOldestAge(employees);
        System.out.println();


        // 3.10 - Imprimindo lista de funcionários por ordem alfabética
        operacoes.sortEmployeesByName(employees);
        System.out.println();


        // 3.11 - Imprimindo soma dos salarios dos funcionários
        operacoes.printTotalSalaries(employees);
        System.out.println();


        // 3.12 - Imprimindo quantos salários mínimos cada funcionário ganha
        operacoes.printMinimumSalaries(employees);
        System.out.println();


    }

}
