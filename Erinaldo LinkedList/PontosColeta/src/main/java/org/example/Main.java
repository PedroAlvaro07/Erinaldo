package org.example;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filtro;

        while(true) {
            System.out.println("Digite o tipo de material que deseja buscar (ex: Plástico, Vidro, Eletrônicos)");
            System.out.println("Digite 'sair' para encerar o programa");
            System.out.print("Opção: ");
            filtro = scanner.nextLine();

            if(filtro.equalsIgnoreCase("sair")){
                System.out.println("Encerrando o Programa...");
                break;
            }

            List<PontoColeta> lista = ListaPontoColeta.carregarPontos("pontos_de_descartes.txt", filtro);
            ListaPontoColeta.exibirLista(lista);
        }
    }
}
