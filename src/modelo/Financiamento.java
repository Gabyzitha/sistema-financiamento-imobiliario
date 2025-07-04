package modelo;
import java.text.DecimalFormat;

public class Financiamento {

    // atributos

    private double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    boolean entradaValida;

    // construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public Financiamento() {
    }

    // getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }


    // metodos
    public double calcularPagamentoMensal(){
        return (this.valorImovel / (prazoFinanciamento * 12)) * (1 + taxaJurosAnual / 12);
    }

    public double totalPago(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public String toString() {

        // formatador de números com 2 casas decimais e separador de milhares
        DecimalFormat df = new DecimalFormat("#,##0.00");

        StringBuilder sb = new StringBuilder();
        sb.append("VALOR DO IMÓVEL: $").append(df.format(this.valorImovel)).append("\n");
        sb.append("VALOR TOTAL DO FINANCIAMENTO: $").append(df.format(totalPago())).append("\n");
        sb.append("PAGAMENTO MENSAL: $").append(df.format(calcularPagamentoMensal())).append("\n");
        return sb.toString();

    }
}
