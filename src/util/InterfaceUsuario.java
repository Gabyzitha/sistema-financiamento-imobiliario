package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner sc;

    // Variáveis de instância para armazenar os dados coletados
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;
    private int numeroVagasGaragem;
    private int numeroAndar;
    private String tipoZona;


    // Construtor que recebe o Scanner do Main
    public InterfaceUsuario(Scanner scanner) {
        this.sc = scanner;
    }


    // Método para obter o valor do imóvel
    public void obterValorImovel() {
        boolean entradaValida;
        do {
            entradaValida = true;
            try { // Tratamento de exceção para tipo de entrada
                System.out.print("Digite o valor do imóvel (Mínimo de $100.000,00): ");
                valorImovel = sc.nextDouble();
                if (valorImovel < 100000.00) {
                    System.out.println("\n===========================================================================");
                    System.out.println("   ⚠ Valor do imóvel abaixo do nível permitido! Por favor, digite novamente!");
                    System.out.println("============================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n===========================================================================");
                System.out.println("   ⚠ Entrada inválida! Digite um número para o valor do imóvel.");
                System.out.println("============================================================================\n");
                sc.nextLine(); // Limpa o buffer do scanner
                entradaValida = false;
            }
        } while (!entradaValida);
        sc.nextLine();
    }

    // Método para obter o prazo de financiamento
    public void obterPrazoFinanciamento(){
        boolean entradaValida;
        do{
            entradaValida = true;
            try { // Tratamento de exceção para tipo de entrada
                System.out.print("Digite o prazo de financiamento (mínimo 5 anos e máximo 35 anos): ");
                prazoFinanciamento = sc.nextInt();
                if (prazoFinanciamento < 5 || prazoFinanciamento > 35) {
                    System.out.println("\n===================================================================");
                    System.out.println("       ⚠ Prazo de financiamento inválido, tente novamente!");
                    System.out.println("=================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n===================================================================");
                System.out.println("       ⚠ Entrada inválida! Digite um número inteiro para o prazo.");
                System.out.println("=================================================================\n");
                sc.nextLine();
                entradaValida = false;
            }
        }while (!entradaValida);
        sc.nextLine();
    }

    // Método para obter a taxa anual
    public void obterTaxaAnual(){
        boolean entradaValida;
        do{
            entradaValida = true;
            try { // Tratamento de exceção para tipo de entrada
                System.out.print("Digite a taxa de juros anual (mínimo 8.5% e máximo 12.0%): ");
                taxaJurosAnual = sc.nextDouble();
                if (taxaJurosAnual < 8.5 || taxaJurosAnual > 12.0) {
                    System.out.println("\n================================================================");
                    System.out.println("        ⚠ Taxa de juros anual inválida, tente novamente!");
                    System.out.println("=================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n================================================================");
                System.out.println("        ⚠ Entrada inválida! Digite um número para a taxa.");
                System.out.println("=================================================================\n");
                sc.nextLine();
                entradaValida = false;
            }
        }while (!entradaValida);
        sc.nextLine();
    }

    // método para obter tamanho da área construída
    public void obterTamanhoAreaConstruida(){
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o tamanho da área construída (m²): ");
                tamanhoAreaConstruida = sc.nextDouble();
                if (tamanhoAreaConstruida <= 0) {
                    System.out.println("\n================================================================");
                    System.out.println("⚠ Tamanho da área construída deve ser positivo. Tente novamente!");
                    System.out.println("================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n================================================================");
                System.out.println("⚠ Entrada inválida! Digite um número para a área construída.");
                System.out.println("================================================================\n");
                sc.nextLine();
                entradaValida = false;
            }
        } while (!entradaValida);
        sc.nextLine();
    }

    // método para obter tamanho do terreno
    public void obterTamanhoTerreno(){
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o tamanho do terreno (m²): ");
                tamanhoTerreno = sc.nextDouble();
                if (tamanhoTerreno <= 0) {
                    System.out.println("\n================================================================");
                    System.out.println("⚠ Tamanho do terreno deve ser positivo. Tente novamente!");
                    System.out.println("================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n================================================================");
                System.out.println("⚠ Entrada inválida! Digite um número para o tamanho do terreno.");
                System.out.println("================================================================\n");
                sc.nextLine();
                entradaValida = false;
            }
        } while (!entradaValida);
        sc.nextLine();
    }

    // método para obter número de vagas
    public void obterNumeroVagasGaragem() {
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número de vagas da garagem (>= 0): ");
                numeroVagasGaragem = sc.nextInt();
                if (numeroVagasGaragem < 0) {
                    System.out.println("\n================================================================");
                    System.out.println("⚠ Número de vagas não pode ser negativo. Tente novamente!");
                    System.out.println("================================================================\n");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n================================================================");
                System.out.println("⚠ Entrada inválida! Digite um número inteiro para as vagas.");
                System.out.println("================================================================\n");
                sc.nextLine();
                entradaValida = false;
            }
        } while (!entradaValida);
        sc.nextLine();
    }

    //  MÉTODO: obter número do andar
    public void obterNumeroAndar(){
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número do andar (>= 0 para térreo): ");
                numeroAndar = sc.nextInt();
                if (numeroAndar < 0) {
                    System.out.println("⚠ Número do andar não pode ser negativo. Tente novamente!");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠ Entrada inválida! Digite um número inteiro para o andar.");
                sc.nextLine();
                entradaValida = false;
            }
        } while (!entradaValida);
        sc.nextLine();
    }

    //  MÉTODO: obter tipo de zona
    public void obterTipoZona(){
        boolean entradaValida;
        do {
            entradaValida = true;
            System.out.print("Digite o tipo de zona (ex: Residencial, Comercial): ");
            tipoZona = sc.nextLine();
            if (tipoZona.isEmpty()) {
                System.out.println("⚠ O tipo de zona não pode ser vazio. Tente novamente!");
                entradaValida = false;
            }
        } while (!entradaValida);
    }

    // Método para criar o financiamento com base na opção do usuário
    public Financiamento criarFinanciamentoEspecifico(){
        char opcao;
        boolean opcaoValida;

        do {
            opcaoValida = true;

            System.out.println("a- Casa");
            System.out.println("b- Apartamento");
            System.out.println("c- Terreno\n");
            System.out.print("     Qual dessas opções desaja fazer um financiamento? ");

            try { // Tratamento de exceção para a leitura do char da opção
                opcao = sc.next().charAt(0);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Entrada inválida para a opção. Por favor, digite 'a', 'b' ou 'c'.");
                sc.nextLine();
                opcao = ' ';
                opcaoValida = false;
            }

            if (opcaoValida && opcao != 'a' && opcao != 'b' && opcao != 'c') {
                System.out.println("\n================================================================");
                System.out.println("      ⚠ Opção inválida. Por favor, escolha 'a', 'b' ou 'c'.");
                System.out.println("=================================================================\n");
                opcaoValida = false;
            }
        } while (!opcaoValida);

        System.out.println();

        // Coleta os dados financeiros básicos para QUALQUER tipo de financiamento
        obterValorImovel();
        obterPrazoFinanciamento();
        obterTaxaAnual();

        double taxaJurosAnualDecimal = this.taxaJurosAnual / 100.0;

        // Coleta dados específicos e cria o objeto da subclasse
        if (opcao == 'a') {
            obterTamanhoAreaConstruida();
            obterTamanhoTerreno();
            return new Casa(this.valorImovel, this.prazoFinanciamento, taxaJurosAnualDecimal, this.tamanhoAreaConstruida, this.tamanhoTerreno);
        } else if (opcao == 'b') {
            obterNumeroVagasGaragem();
            obterNumeroAndar();
            return new Apartamento(this.valorImovel, this.prazoFinanciamento, taxaJurosAnualDecimal, this.numeroAndar, this.numeroVagasGaragem);
        } else {
            obterTipoZona();
            System.out.println();
            return new Terreno(this.valorImovel, this.prazoFinanciamento, taxaJurosAnualDecimal, this.tipoZona);
        }
    }
}