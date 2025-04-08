package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filtro;

        String url = "C:\\Users\\joaop\\Desktop\\Erinaldo\\PontoColeta\\src\\main\\ponto_coleta.txt";

        while(true) {
            System.out.println("Digite o tipo de material que deseja buscar (ex: Plástico, Vidro, Eletrônicos)");
            System.out.println("Digite 'sair' para encerar o programa");
            System.out.print("Opção: ");
            filtro = scanner.nextLine();

            if(filtro.equalsIgnoreCase("sair")){
                System.out.println("Encerrando o Programa...");
                break;
            }

            ListaPontoColeta listaPontoColeta  = new ListaPontoColeta();
            listaPontoColeta.carregarPontos(url);
            listaPontoColeta.listarFiltro(filtro);
        }
    }
}