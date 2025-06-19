package main;

import modelo.Financiamento;
import util.InterfaceUsuario;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // criação da lista de financiamentos
        List<Financiamento> listaFinanciamento = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        System.out.println("==================================================\n");
        System.out.print("    Quantos financiamentos você deseja fazer? ");
        int N = sc.nextInt();
        System.out.println("\n=================================================");


        for(int i=0; i<N; i++){

            // coleta os dados
            System.out.println("\n          ★★★★★ [FINANCIAMENTO] #" + (i + 1) + " ★★★★★\n");
            interfaceUsuario.obterValorImovel();
            interfaceUsuario.obterPrazoFinanciamento();
            interfaceUsuario.obterTaxaAnual();

            // cria o objeto financiamento
            Financiamento financ = interfaceUsuario.criarFinanciamento();
            // add na listaFinanciamento
            listaFinanciamento.add(financ);
        }

        // exibe com o toString
        System.out.println("\n        --- DETALHES DE TODOS OS FINANCIAMENTOS ---\n");
        for (int i = 0; i < listaFinanciamento.size(); i++) {
            System.out.println("[DADOS DO FINANCIAMENTO] #" + (i + 1));
            System.out.println(listaFinanciamento.get(i));
            System.out.println("------------------------------------------\n");
        }

        // iniciando as somas com 0
        double somaTotalImoveis = 0.0;
        double somaTotalFinanciamento = 0.0;

        for (Financiamento financiamento : listaFinanciamento) {
            somaTotalImoveis += financiamento.getValorImovel();
            somaTotalFinanciamento += financiamento.totalPago();
        }

        // Formatador para a saída dos totais
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("Total de todos os imóveis: $" + df.format(somaTotalImoveis));
        System.out.println("Total de todos os financiamentos: $" + df.format(somaTotalFinanciamento));
        System.out.println("\n------------------------------------------\n");





        sc.close();

    }


}
