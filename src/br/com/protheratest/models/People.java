package br.com.protheratest.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


// 1 - Classe Pessoa com os atributos "nome" (String) e "data de nascimento" (LocalDate)

@SuppressWarnings("All")
public class People {
    private String name;
    private LocalDate birth;


    // Método constrututor para a classe
    public People(String name, String birth) {
        this.name = name;
        setBirth(birth);
    }

    public String getName() {
        return name;
    }


     //3.3a Método para obter a data no formado solicitado
    public String getBirthFormated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birth.format(formatter);
    }

    public LocalDate getBirth() {
        return birth;
    }

    // Método para atribuir a data com o formato padrão da região
    public void setBirth(String birth) {
        this.birth = LocalDate.parse(birth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
