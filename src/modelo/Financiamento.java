package modelo;

public class Financiamento {

    // atributos

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    boolean entradaValida;

    // construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
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
        return  "\n"
                + "========== DADOS DO FINANCIAMENTO =========="
                +"\n"
                +"\n"
                + "VALOR DO IMÓVEL: "
                + valorImovel
                +"\n"
                +"VALOR TOTAL DO FINANCIAMENTO: "
                + String.format("%.2f", totalPago())
                +"\n"
                +"PAGAMENTO MENSAL: "
                + String.format("%.2f", calcularPagamentoMensal())
                +"\n";

    }
}
