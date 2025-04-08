package org.example;

public class PontoColeta {
    int id;
    String tipo;
    String endereco;
    PontoColeta proximo;

    public PontoColeta(int id, String tipo, String endereco) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.proximo = null;
    }
}
