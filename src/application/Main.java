package application;

import util.Financiamento;
import util.InterfaceUsuario;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        Financiamento financiamento = interfaceUsuario.obterDados();

        System.out.println(financiamento);

        sc.close();

    }


}
