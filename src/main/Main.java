package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;


public class Main {

    // Método para salvar os financiamentos em um arquivo de texto
    private static void salvarFinanciamentosTexto(List<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento f : financiamentos) {
                String linha = "";
                if (f instanceof Casa) {
                    Casa casa = (Casa) f;
                    linha = String.format("Casa,%.2f,%d,%.4f,%.2f,%.2f",
                            casa.getValorImovel(), casa.getPrazoFinanciamento(), casa.getTaxaJurosAnual(),
                            casa.getTamanhoAreaConstruida(), casa.getTamanhoTerreno());
                } else if (f instanceof Apartamento) {
                    Apartamento apto = (Apartamento) f;
                    linha = String.format("Apartamento,%.2f,%d,%.4f,%d,%d",
                            apto.getValorImovel(), apto.getPrazoFinanciamento(), apto.getTaxaJurosAnual(),
                            apto.getNumeroAndar(), apto.getNumeroVagasGaragem());
                } else if (f instanceof Terreno) {
                    Terreno terreno = (Terreno) f;
                    linha = String.format("Terreno,%.2f,%d,%.4f,%s",
                            terreno.getValorImovel(), terreno.getPrazoFinanciamento(), terreno.getTaxaJurosAnual(),
                            terreno.getTipoZona());
                }
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("\n Dados dos financiamentos salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("⚠ Erro ao salvar financiamentos em texto: " + e.getMessage());
        }
    }

    // Método para ler os financiamentos de um arquivo de texto
    private static List<Financiamento> lerFinanciamentosTexto(String nomeArquivo) {
        List<Financiamento> financiamentosLidos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                double valorImovel = Double.parseDouble(partes[1]);
                int prazoFinanciamento = Integer.parseInt(partes[2]);
                double taxaJurosAnual = Double.parseDouble(partes[3]);

                Financiamento f = null;
                switch (tipo) {
                    case "Casa":
                        double tamanhoAreaConstruida = Double.parseDouble(partes[4]);
                        double tamanhoTerreno = Double.parseDouble(partes[5]);
                        f = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
                        break;
                    case "Apartamento":
                        int numeroAndar = Integer.parseInt(partes[4]);
                        int numeroVagasGaragem = Integer.parseInt(partes[5]);
                        f = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroAndar, numeroVagasGaragem);
                        break;
                    case "Terreno":
                        String tipoZona = partes[4];
                        f = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
                        break;
                }
                if (f != null) {
                    financiamentosLidos.add(f);
                }
            }
            System.out.println(" Dados dos financiamentos lidos do arquivo de texto: " + nomeArquivo);
        } catch (FileNotFoundException e) {
            System.err.println("⚠ Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("⚠ Erro de leitura do arquivo de texto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("⚠ Erro de formato numérico ao ler do arquivo de texto: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("⚠ Erro de dados inválidos ao reconstruir financiamento do texto: " + e.getMessage());
        }
        return financiamentosLidos;
    }

    // Método para salvar a lista de financiamentos usando serialização
    private static void salvarFinanciamentosSerializados(List<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
            System.out.println("Lista de financiamentos serializada e salva em: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("⚠ Erro ao serializar financiamentos: " + e.getMessage());
        }
    }

    // Método para ler a lista de financiamentos usando desserialização
    private static List<Financiamento> lerFinanciamentosSerializados(String nomeArquivo) {
        List<Financiamento> financiamentosDesserializados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                financiamentosDesserializados = (List<Financiamento>) obj;
                System.out.println(" Lista de financiamentos desserializada de: " + nomeArquivo);
            }
        } catch (FileNotFoundException e) {
            System.err.println(" Arquivo serializado não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println(" Erro de leitura ou escrita ao desserializar: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(" Classe do objeto serializado não encontrada: " + e.getMessage());
        }
        return financiamentosDesserializados;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Criação da lista de financiamentos
        List<Financiamento> listaFinanciamento = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(sc);

        System.out.println("==================================================\n");

        int N = 0;
        boolean inputValidoN = false;
        do {
            try {
                System.out.print("    Quantos financiamentos você deseja fazer? ");
                N = sc.nextInt();
                if (N < 1) {
                    System.out.println("\n===================================================================");
                    System.out.println("⚠ O número de financiamentos deve ser maior que zero. Tente novamente.");
                    System.out.println("=====================================================================\n");

                    inputValidoN = false;
                } else {
                    inputValidoN = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n==========================================================================================");
                System.out.println("⚠ Entrada inválida. Por favor, digite um número inteiro para a quantidade de financiamentos.");
                System.out.println("===========================================================================================\n");

                sc.nextLine();
                inputValidoN = false;
            }
        } while (!inputValidoN);

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.println("\n        ★★★★★ [FINANCIAMENTO] #" + (i + 1) + " ★★★★★\n");

            Financiamento novoFinanc = null;
            boolean financCriadoComSucesso = false;

            do {
                try {
                    novoFinanc = interfaceUsuario.criarFinanciamentoEspecifico();
                    financCriadoComSucesso = true;
                } catch (InputMismatchException e) {

                    System.out.println("⚠ Erro de entrada de dados ao criar o financiamento. Por favor, tente novamente com valores válidos.");
                    sc.nextLine();
                } catch (ArithmeticException e) {
                    System.out.println("⚠ Erro de cálculo no financiamento: " + e.getMessage() + ". Por favor, revise os dados.");
                } catch (Exception e) {
                    System.out.println("⚠ Ocorreu um erro inesperado ao criar o financiamento: " + e.getMessage());
                    e.printStackTrace();
                }
            } while (!financCriadoComSucesso);

            if (novoFinanc != null) {
                listaFinanciamento.add(novoFinanc);
            }
        }

        // Exibe com o toString
        System.out.println("\n        --- DETALHES DE TODOS OS FINANCIAMENTOS ---\n");
        // Verifica se a lista não está vazia antes de tentar exibir
        if (listaFinanciamento.isEmpty()) {
            System.out.println("Nenhum financiamento foi registrado.");
        } else {
            for (int i = 0; i < listaFinanciamento.size(); i++) {
                System.out.println("[DADOS DO FINANCIAMENTO] #" + (i + 1));

                try {
                    System.out.println(listaFinanciamento.get(i));
                } catch (ArithmeticException e) {
                    System.out.println("⚠ Erro ao exibir detalhes do financiamento #" + (i + 1) + ": " + e.getMessage());
                    System.out.println("⚠ Detalhes incompletos para este financiamento.");
                } catch (Exception e) {
                    System.out.println("⚠ Erro inesperado ao exibir financiamento #" + (i + 1) + ": " + e.getMessage());
                    e.printStackTrace();
                }
                System.out.println("------------------------------------------\n");
            }
        }

        // Iniciando as somas com 0
        double somaTotalImoveis = 0.0;
        double somaTotalFinanciamento = 0.0;

        // Calcula os totais com tratamento de exceção para garantir que um cálculo falho não pare
        for (Financiamento financiamento : listaFinanciamento) {
            try {
                somaTotalImoveis += financiamento.getValorImovel();
                somaTotalFinanciamento += financiamento.totalPago();
            } catch (ArithmeticException e) {
                System.out.println("⚠ Erro de cálculo em um financiamento ao somar totais. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("⚠ Erro inesperado ao somar totais de um financiamento. " + e.getMessage());
            }
        }

        // Formatador para a saída dos totais
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("Total de todos os imóveis: $" + df.format(somaTotalImoveis));
        System.out.println("Total de todos os financiamentos: $" + df.format(somaTotalFinanciamento));
        System.out.println("\n------------------------------------------\n");

        // --- REQUISITO 2: SALVAR E LER EM ARQUIVO DE TEXTO ---
        System.out.println("\n=== Salvando e Lendo Dados em Arquivo de Texto ===\n");
        String arquivoTexto = "financiamentos.txt";
        salvarFinanciamentosTexto(listaFinanciamento, arquivoTexto);

        List<Financiamento> financiamentosLidosTexto = lerFinanciamentosTexto(arquivoTexto);
        if (!financiamentosLidosTexto.isEmpty()) {
            System.out.println("\n--- Detalhes dos Financiamentos Lidos do Arquivo de Texto ---\n");
            for (int i = 0; i < financiamentosLidosTexto.size(); i++) {
                System.out.println("[FINANCIAMENTO LIDO DO TEXTO] #" + (i + 1));
                System.out.println(financiamentosLidosTexto.get(i));
                System.out.println("------------------------------------------\n");
            }
        } else {
            System.out.println("Nenhum financiamento foi lido do arquivo de texto.");
        }


        // --- REQUISITO 3: SALVAR E LER POR SERIALIZAÇÃO ---
        System.out.println("\n=== Salvando e Lendo Dados por Serialização ===\n");
        String arquivoSerializado = "financiamentos.ser";
        salvarFinanciamentosSerializados(listaFinanciamento, arquivoSerializado);

        List<Financiamento> financiamentosDesserializados = lerFinanciamentosSerializados(arquivoSerializado);
        if (!financiamentosDesserializados.isEmpty()) {
            System.out.println("\n--- Detalhes dos Financiamentos Desserializados ---\n");
            for (int i = 0; i < financiamentosDesserializados.size(); i++) {
                System.out.println("[FINANCIAMENTO DESSERIALIZADO] #" + (i + 1));
                System.out.println(financiamentosDesserializados.get(i));
                System.out.println("------------------------------------------\n");
            }
        } else {
            System.out.println("Nenhum financiamento foi desserializado.");
        }


        sc.close();
    }
}