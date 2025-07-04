package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

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

            System.out.print("Digite o valor do imóvel (Mínimo de $100.000,00): ");
            valorImovel = sc.nextDouble();
            if (valorImovel < 100000.00) {
                System.out.println("\n===========================================================================");
                System.out.println(   "⚠ Valor do imóvel abaixo do nível permitido! Por favor, digite novamente!");sc.nextLine();
                System.out.println("============================================================================\n");

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
                System.out.println("\n===================================================================");
                System.out.println("       ⚠ Prazo de financiamento inválido, tente novamente!");
                System.out.println("=================================================================\n");

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
                System.out.println("\n================================================================");
                System.out.println("        ⚠ Taxa de juros anual inválida, tente novamente!");
                System.out.println("=================================================================\n");

                entradaValida = false;
            }
        }while (!entradaValida);

    }
    // método para criar o financiamento com base na opção do usuário
    public Financiamento criarFinanciamentoEspecifico(){
        char opcao;
        boolean opcaoValida;

        do {
            opcaoValida = true;

            System.out.println("a- Casa");
            System.out.println("b- Apartamento");
            System.out.println("c- Terreno\n");
            System.out.print("     Qual dessas opções desaja fazer um financiamento? ");
            opcao = sc.next().charAt(0);
            sc.nextLine();

            if (opcao != 'a' && opcao != 'b' && opcao != 'c') {
                System.out.println("\n================================================================");
                System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
                System.out.println("=================================================================\n");
                opcaoValida = false;
            }
        } while (!opcaoValida);

        System.out.println();
        obterValorImovel();
        obterPrazoFinanciamento();
        obterTaxaAnual();

            if (opcao == 'a') {
                return new Casa(this.valorImovel, this.prazoFinanciamento, this.taxaJurosAnual);
            } else if (opcao == 'b') {
                return new Apartamento(this.valorImovel, this.prazoFinanciamento, this.taxaJurosAnual);
            } else {
                return new Terreno(this.valorImovel, this.prazoFinanciamento, this.taxaJurosAnual);
            }
    }



}


