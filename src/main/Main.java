package main;

import modelo.Financiamento;
import util.InterfaceUsuario;


import java.util.Scanner;
import java.util.Locale;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // coleta os dados
        interfaceUsuario.obterValorImovel();
        interfaceUsuario.obterPrazoFinanciamento();
        interfaceUsuario.obterTaxaAnual();

        // cria o financiamento
        Financiamento financiamento = interfaceUsuario.criarFinanciamento();
        // exibe o com o toString
        System.out.println(financiamento);

        sc.close();

    }


}
