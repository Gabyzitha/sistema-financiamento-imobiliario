
package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Financiamento implements Serializable {

    // Atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Construtor principal
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        // Tratamento de exceções no construtor para garantir dados iniciais válidos
        if (valorImovel <= 0) {
            throw new IllegalArgumentException("\n⚠ O valor do imóvel deve ser positivo.\n");

        }
        if (prazoFinanciamento <= 0) {
            throw new IllegalArgumentException("\n⚠ O prazo de financiamento deve ser positivo.\n");
        }
        if (taxaJurosAnual < 0) { // Taxa não pode ser negativa
            throw new IllegalArgumentException("\n⚠ A taxa de juros anual não pode ser negativa.\n");
        }

        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }


    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // método abstrato
    public abstract double calcularPagamentoMensal();


    // Método que calcula o total pago
    public double totalPago() {
        // Verifica se o prazo é válido para evitar ArithmeticException no cálculo total
        if (prazoFinanciamento <= 0) {
            throw new ArithmeticException("\n⚠ Prazo de financiamento inválido!.\n");
        }
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");

        StringBuilder sb = new StringBuilder();
        sb.append("VALOR DO IMÓVEL: $").append(df.format(this.valorImovel)).append("\n");
        sb.append("PRAZO DO FINANCIAMENTO: ").append(this.prazoFinanciamento).append(" anos\n");
        sb.append("TAXA DE JUROS ANUAL: ").append(df.format(this.taxaJurosAnual * 100)).append("%\n");

        // Tratamento de exceções ao chamar métodos de cálculo no toString
        try {
            sb.append("VALOR TOTAL DO FINANCIAMENTO: $").append(df.format(totalPago())).append("\n");
            sb.append("PAGAMENTO MENSAL: $").append(df.format(calcularPagamentoMensal())).append("\n");
        } catch (ArithmeticException e) {
            sb.append("⚠ VALOR TOTAL DO FINANCIAMENTO: Erro de cálculo - ").append(e.getMessage()).append("\n");
            sb.append("⚠ PAGAMENTO MENSAL: Erro de cálculo - ").append(e.getMessage()).append("\n");
        } catch (Exception e) { // Captura outras exceções inesperadas
            sb.append("⚠ Erro inesperado ao exibir detalhes de cálculo: ").append(e.getMessage()).append("\n");
        }

        return sb.toString();
    }
}