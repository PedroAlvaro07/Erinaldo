package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ListaPontoColeta {

    public static List<PontoColeta> carregarPontos(String caminhoArquivo, String filtro) {
        List<PontoColeta> lista = new LinkedList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0].trim());
                    String tipo = partes[1].trim();
                    String endereco = partes[2].trim();

                    if (tipo.toLowerCase().contains(filtro.toLowerCase())) {
                        lista.add(new PontoColeta(id, tipo, endereco));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return lista;
    }

    public static void exibirLista(List<PontoColeta> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum ponto de coleta encontrado.");
        } else {
            System.out.println("\nPontos de Coleta:");
            for (PontoColeta p : lista) {
                System.out.println(p);
                System.out.println();
            }
        }
    }
}

