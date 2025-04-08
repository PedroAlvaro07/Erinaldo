package org.example;

import java.io.*;
import java.util.Scanner;

public class ListaCircular {
    private Veiculo inicio = null;

    public void inserir(String placa, String dia, String horario) {
        Veiculo novo = new Veiculo(placa, dia, horario);
        if (inicio == null) {
            inicio = novo;
            inicio.prox = inicio;
        } else {
            Veiculo atual = inicio;
            while (atual.prox != inicio) {
                atual = atual.prox;
            }
            atual.prox = novo;
            novo.prox = inicio;
        }
    }

    public void carregarArquivo(String caminho, String criterio, int tipo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String placa = partes[0];
                    String dia = partes[1];
                    String horario = partes[2];

                    if ((tipo == 1 && dia.equalsIgnoreCase(criterio)) ||
                            (tipo == 2 && placa.endsWith(criterio))) {
                        inserir(placa, dia, horario);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        Veiculo atual = inicio;
        do {
            System.out.println("Placa: " + atual.placa + " | Dia: " + atual.dia + " | Horário: " + atual.horario);
            atual = atual.prox;
        } while (atual != inicio);
    }

    public void navegar() {
        if (inicio == null) return;
        Scanner scanner = new Scanner(System.in);
        Veiculo atual = inicio;
        String comando;

        System.out.println("\nNavegação (a: próximo, s: sair)");
        do {
            System.out.println("→ Placa: " + atual.placa + " | Dia: " + atual.dia + " | Horário: " + atual.horario);
            System.out.print("Comando: ");
            comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("a")) {
                atual = atual.prox;
            }
        } while (!comando.equalsIgnoreCase("s"));
    }
}

