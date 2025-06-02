package util;

import modelo.Financiamento;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    // variáveis de instancia
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;


    // método para obter o prazo de financiamento
    public void obterValorImovel() {

        boolean entradaValida;

        do {
            entradaValida = true;

            System.out.print("Digite o valor do imovel (Mínimo de 100.000,00): ");
            valorImovel = sc.nextDouble();
            if (valorImovel < 100000.00) {
                System.out.println("Valor do imóvel abaixo do nível permitido! Por favor, digite novamente!");sc.nextLine();
                entradaValida = false;
            }
        }while (!entradaValida);

    }

    // método para obter o prazo de financiamento
    public void obterPrazoFinanciamento(){

        boolean entradaValida;

        do{
            entradaValida = true;

            System.out.print("Digite o prazo de financiamento (mínimo 5 anos e máximo 35 anos): ");
            prazoFinanciamento = sc.nextInt();
            if (prazoFinanciamento < 5 || prazoFinanciamento > 35) {
                System.out.println("Prazo de financiamento inválido, tente novamente!");
                entradaValida = false;
            }
        }while (!entradaValida);
    }

    // método para obter a taxa anual
    public void obterTaxaAnual(){

        boolean entradaValida;

        do{
            entradaValida = true;

            System.out.print("Digite a taxa de juros anual (mínimo 8.5% e máximo 12.0%): ");
            taxaJurosAnual = sc.nextDouble();
            if (taxaJurosAnual < 8.5 || taxaJurosAnual > 12.0) {
                System.out.println("Taxa de juros anual inálida, tente novamente!");
                entradaValida = false;
            }
        }while (!entradaValida);

    }

    // método para retornar o objeto financiamento
    public Financiamento criarFinanciamento(){
        return new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

    }
}


