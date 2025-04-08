package org.example;

public class Veiculo {
    String placa;
    String dia;
    String horario;
    Veiculo prox;

    public Veiculo(String placa, String dia, String horario) {
        this.placa = placa;
        this.dia = dia;
        this.horario = horario;
        this.prox = null;
    }
}

