package br.com.protheratest.service;

import br.com.protheratest.models.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// Classe para operações e manipulações gerais

@SuppressWarnings("all")
public class Services {


//     Instanciando funcinarios da lista
    public List<Employee> instantiateEmployees(){
        Employee maria = new Employee("Maria", "18/10/2000", "2009.44", "Operador");
        Employee joao = new Employee("João", "12/05/1990", "2284.38", "Operador");
        Employee caio = new Employee("Caio", "02/05/1961", "9836.14", "Coordenador");
        Employee miguel = new Employee("Miguel", "14/10/1988", "19119.88", "Diretor");
        Employee alice = new Employee("Alice", "05/01/1995", "2234.68", "Recepcionista");
        Employee heitor = new Employee("Heitor", "19/11/1999", "1582.72", "Operador");
        Employee arthur = new Employee("Arthur", "31/03/1993", "4071.84", "Contador");
        Employee laura = new Employee("Laura", "08/07/1994", "3017.45", "Gerente");
        Employee heloisa = new Employee("Heloisa", "24/05/2003", "1606.85", "Eletricista");
        Employee helena = new Employee("Helena", "02/09/1996", "2799.93", "Gerente");


        // 3.1 - Atribuindo os funcionários à uma lista, na ordem da tabela
//        List<Employee> employees = Arrays.asList(
//                maria, joao, caio, miguel, alice, heitor,                ----> Tentei desta maneira, sem sucesso na hora de remover o joão
//                arthur, laura, heloisa, helena
//        );

        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees, maria, joao, caio, miguel, alice, heitor,
                arthur, laura, heloisa, helena);

        return employees;
    }



    // 3.2 - Remoção de funcionário da lista
    public void removeEmployee(List<Employee> employees, String name) {
        employees.removeIf(employee -> employee.getName().equalsIgnoreCase(name));
    }



    // 3.3 Método para impressão dos funcionarios, com formatação regional
    public static void printEmployees(List<Employee> employees) {
        System.out.println("Lista de Funcionários:");
        for (Employee employee : employees) {
            System.out.println("\tNome: " + employee.getName());
            System.out.println("\tData de Nascimento: " + employee.getBirthFormated());
            System.out.println("\tSalário: R$ " + employee.getSalaryFormatted());
            System.out.println("\tFunção: " + employee.getOccupation());
            System.out.println("\t===================================");
        }
    }



    // 3.4 - Método para fazer aumento de salário para todos os funcionários
    public void salaryIncrease(List<Employee> employees, int percentage){
        for(Employee pessoa: employees){
            pessoa.salaryIncrease(percentage);
        }
    }



    // 3.5/3.6 - Método para agrupar os funcionários por função em um Map
    public void groupByFunction(List<Employee> employees) {
        Map<String, List<Employee>> byFunction = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOccupation));
        System.out.println(byFunction);
    }



    // 3.8 - Método para imprimir os funcionários que fazem aniversário em um certo mês
    public static void printBirthdays(List<Employee> employees, int month) {
        System.out.println("Funcionários que fazem aniversário no mês " + month + ":");
        for (Employee employee : employees) {
            if (employee.getBirth().getMonthValue() == month) {
                System.out.println("\tNome: " + employee.getName() + " - Data de Nascimento: " + employee.getBirthFormated());
            }
        }
        System.out.println("===================================");
    }



    // 3.9 - Método para imprimir o funcionário com a maior idade
    public static void printEmployeeOldestAge(List<Employee> employees) {
        Employee oldest = employees.stream()
                .min(Comparator.comparing(Employee::getBirth))
                .orElseThrow();

        LocalDate today = LocalDate.now();
        long age = oldest.getBirth().until(today).getYears();

        System.out.println("Funcionário mais velho:");
        System.out.println("\tNome: " + oldest.getName() + " - Idade: " + age + " anos");
        System.out.println();
    }



    // 3.10 - Método para ordenar os funcionários por nome e imprimir
    public static void sortEmployeesByName(List<Employee> employees) {
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

        System.out.println("Lista de Funcionários ordenada por nome:");
        for (Employee employee : sortedEmployees) {
            System.out.println("\tNome: " + employee.getName());
        }
        System.out.println();
    }



    // 3.11 - Método para imprimir o total dos salários dos funcionários
    public static void printTotalSalaries(List<Employee> employees) {
        BigDecimal totalSalaries = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Soma total dos salários dos funcionários: R$ " + String.format("%,.2f", totalSalaries));
        System.out.println();
    }




    // 3.12 - Método para imprimir quantos salários mínimos ganha cada funcionário
    public static void printMinimumSalaries(List<Employee> employees) {
        BigDecimal valueMinimunSalary = BigDecimal.valueOf(1212.00);

        System.out.println("Quantos salários mínimos cada funcionário ganha:");
        for (Employee employee : employees) {
            BigDecimal minimumSalaries = employee.getSalary().divide(valueMinimunSalary, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println("\tNome: " + employee.getName() + " - Salários Mínimos: " + minimumSalaries);
        }
        System.out.println();
    }
}
