package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o critério de filtro:");
        System.out.println("1 - Dia da semana");
        System.out.println("2 - Final da placa");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o critério: ");
        String criterio = scanner.nextLine();

        lista.carregarArquivo("rodizio_de_veiculos.txt", criterio, opcao);

        System.out.println("\nVeículos com restrição:");
        lista.exibir();

        lista.navegar();

        System.out.println("Programa finalizado.");
    }
}
