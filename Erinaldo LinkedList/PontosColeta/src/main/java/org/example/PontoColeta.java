package org.example;

public class PontoColeta {
    int id;
    String tipo;
    String endereco;

    public PontoColeta(int id, String tipo, String endereco) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tipo: " + tipo + " | Endereço: " + endereco;
    }
}

