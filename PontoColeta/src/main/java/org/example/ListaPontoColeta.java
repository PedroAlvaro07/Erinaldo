package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaPontoColeta {
    private PontoColeta inicio;

    public ListaPontoColeta() {
        this.inicio = null;
    }

    public void inserir(int id, String tipo, String endereco) {
        PontoColeta p = new PontoColeta(id, tipo, endereco);

        if (this.inicio == null) {
            this.inicio = p;
        } else {
            PontoColeta aux = this.inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = p;
        }
    }

    public void listar() {
        if (this.inicio == null) {
            System.out.println("Nenhum PontoColeta encontrado");
            return;
        }

        PontoColeta aux = this.inicio;
        while (aux != null) {
            System.out.println("Id: " + aux.id + " Tipo: " + aux.tipo + " Endereco: " + aux.endereco);
            System.out.println("------------------");
            aux = aux.proximo;
        }
    }

    public void listarFiltro(String filtro) {
        if (this.inicio == null) {
            System.out.println("Nenhum PontoColeta encontrado");
            return;
        }

        PontoColeta aux = this.inicio;
        while (aux != null) {
            if (aux.tipo.equals(filtro) || aux.endereco.equals(filtro)) {
                System.out.println("Tipo: " + aux.tipo + " Endereco: " + aux.endereco);
                System.out.println("----------------");
            }
            aux = aux.proximo;
        }
    }

    public void carregarPontos(String caminhoArquivo) {

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0].trim());
                    String tipo = partes[1].trim();
                    String endereco = partes[2].trim();

                    inserir(id, tipo, endereco);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}
