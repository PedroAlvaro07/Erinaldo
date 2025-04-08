package org.example;
import java.io.*;

public class ListaDupla {
    private Rotas inicio;

    public ListaDupla() {
        this.inicio = null;
    }

    public void inserir(int id, String nomeLinha, String tipoTransporte, String regiao) {
        Rotas novo = new Rotas(id, nomeLinha, tipoTransporte, regiao);

        if (inicio == null) {
            inicio = novo;
        } else {
            Rotas temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
            novo.anterior = temp;
        }
    }

    public void exibirEmOrdem() {
        if (inicio == null) {
            System.out.println("\nNenhuma rota encontrada!");
            return;
        }

        Rotas temp = inicio;
        while (temp != null) {
            System.out.printf("%d - %s (%s) - %s\n", temp.id, temp.nomeLinha, temp.tipoTransporte, temp.regiao);
            temp = temp.proximo;
        }
    }

    public void exibirEmOrdemInversa() {
        if (inicio == null) {
            System.out.println("\nNenhuma rota encontrada!");
            return;
        }

        Rotas temp = inicio;
        while (temp.proximo != null) {
            temp = temp.proximo;
        }

        while (temp != null) {
            System.out.printf("%d - %s (%s) - %s\n", temp.id, temp.nomeLinha, temp.tipoTransporte, temp.regiao);
            temp = temp.anterior;
        }
    }

    public void carregarRotas(String nomeArquivo, String filtro) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nomeLinha = partes[1];
                    String tipoTransporte = partes[2];
                    String regiao = partes[3];

                    if (tipoTransporte.contains(filtro) || regiao.contains(filtro)) {
                        inserir(id, nomeLinha, tipoTransporte, regiao);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void limpar() {
        inicio = null;
    }
}

