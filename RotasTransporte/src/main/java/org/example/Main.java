package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um tipo de transporte ou região para filtrar: ");
        String filtro = scanner.nextLine();

        lista.carregarRotas("rotas_de_transportes.txt", filtro);

        System.out.println("\nRotas encontradas:");
        lista.exibirEmOrdem();

        System.out.println("\nRotas em ordem inversa:");
        lista.exibirEmOrdemInversa();

        lista.limpar();
        System.out.println("\nLista liberada.");
    }
}
