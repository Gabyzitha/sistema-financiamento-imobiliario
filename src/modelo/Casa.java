package modelo;

import util.AumentoMaiorDoQueJurosException;
import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    // Construtor com argumentos da superclasse e atributos específicos de Casa
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        // Tratamento de exceção para os atributos
        if (tamanhoAreaConstruida <= 0) {
            throw new IllegalArgumentException("\n⚠ O tamanho da área construída deve ser positivo.\n");

        }
        if (tamanhoTerreno <= 0) {
            throw new IllegalArgumentException("\n⚠ O tamanho do terreno deve ser positivo.\n");
        }
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public void setTamanhoAreaConstruida(double tamanhoAreaConstruida) {
        if (tamanhoAreaConstruida <= 0) {
            throw new IllegalArgumentException("\n⚠ O tamanho da área construída deve ser positivo.\n");
        }
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void setTamanhoTerreno(double tamanhoTerreno) {
        if (tamanhoTerreno <= 0) {
            throw new IllegalArgumentException("\n⚠ O tamanho do terreno deve ser positivo.\n");
        }
        this.tamanhoTerreno = tamanhoTerreno;
    }

    // Sobreposição de métodos
    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {

        double taxaMensal = this.taxaJurosAnual / 12.0;
        double totalMeses = this.prazoFinanciamento * 12.0;

        // Tratamento para evitar divisão por zero
        if (totalMeses == 0) {
            throw new ArithmeticException("\n⚠ Prazo de financiamento inválido para cálculo mensal.\n");
        }
        if (taxaMensal == 0) {
            return (this.valorImovel / totalMeses) + 80.0;
        }

        double fatorElevado = Math.pow((1 + taxaMensal), totalMeses);
        double denominador = fatorElevado - 1;

        if (denominador == 0) {
            throw new ArithmeticException("\n⚠ Erro de cálculo: Denominador zero na fórmula. Revise os dados.\n");
        }

        double numerador = this.valorImovel * fatorElevado;
        double parcelaBase = numerador / denominador;

        return parcelaBase + 80.0;
    }

    @Override
    public String toString() {
        // Chama o toString da superclasse para obter os detalhes básicos do financiamento
        return "OPÇÃO: CASA\n" +
                super.toString() +
                String.format("ÁREA CONSTRUÍDA: %.2f m²%n" +
                                "TAMANHO DO TERRENO: %.2f m²%n",
                        tamanhoAreaConstruida, tamanhoTerreno);
    }
}