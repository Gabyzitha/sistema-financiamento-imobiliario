package util;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    public Financiamento obterDados() {

        System.out.print("Digite o valor do imovel: ");
        double valorImovel = sc.nextDouble();

        System.out.print("Digite o prazo de financiamento: ");
        int prazoFinanciamento = sc.nextInt();

        System.out.print("Digite a taxa de juros anual: ");
        double taxaJurosAnual = sc.nextDouble();

        return new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

    }
}


