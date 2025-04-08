package org.example;

public class Rotas {
    int id;
    String nomeLinha;
    String tipoTransporte;
    String regiao;
    Rotas proximo;
    Rotas anterior;

    public Rotas(int id, String nomeLinha, String tipoTransporte, String regiao) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipoTransporte = tipoTransporte;
        this.regiao = regiao;
        this.proximo = null;
        this.anterior = null;
    }
}

