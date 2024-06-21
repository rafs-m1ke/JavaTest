package br.com.protheratest.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

// 2 - Classe funcionário extendendo da classe Pessoa, com os atributos "salário" (BigDecimal) e "função" (String)

@SuppressWarnings("All")
public class Employee extends People {
    private BigDecimal salary;
    private String occupation;

    // Método construtor para a Classe
    public Employee(String name, String birth, String salary, String occupation) {
        super(name, birth);
        this.salary = new BigDecimal(salary);
        this.occupation = occupation;
    }

    // 3.3b - Método getter para retornar o salário ja em seu formado padrão regional
    public String getSalaryFormatted() {
        DecimalFormat formater = new DecimalFormat();
        formater.applyPattern("##,###.00");
        return "Salario " + formater.format(salary);
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getOccupation() {
        return occupation;
    }

    // Método para aumento individual de salário
    public void salaryIncrease(int valor) {
        BigDecimal porcentagem = new BigDecimal(valor / 100.0);
        salary = salary.add(salary.multiply(porcentagem));
    }


    // 3 - toString com os formatos finais solicitados
    @Override
    public String toString() {
        return "\n\tNome: " + getName() + " | Nascimento: " + getBirthFormated() + " | Salario " + getSalaryFormatted();
    }
}
