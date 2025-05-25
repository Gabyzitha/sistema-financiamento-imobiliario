package util;

public class Financiamento {

    // atributos

    public double valorImovel;
    public int prazoFinanciamento;
    public double taxaJurosAnual;

    // construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // metodos
    public double calcularPagamentoMensal(){
        return (this.valorImovel / (prazoFinanciamento * 12)) * (1 + taxaJurosAnual / 12);
    }

    public double totalPago(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public String toString() {
        return "Pamento mensal: "
                + String.format("%.4f", calcularPagamentoMensal())
                + "\nTotal pago: "
                + String.format("%.4f", totalPago());

    }
}
