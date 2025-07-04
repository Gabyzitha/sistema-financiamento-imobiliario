package modelo;

import java.text.DecimalFormat;

public class Apartamento extends Financiamento {

    // construtor com argumentos da superclasse
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // sobreposição de métodos
    @Override
    public double calcularPagamentoMensal(){
        double taxaMensal = this.taxaJurosAnual / 12.0;
        double totalMeses = this.prazoFinanciamento * 12.0;
        double fatorElevado = Math.pow((1 + taxaMensal), totalMeses);
        double numerador = this.getValorImovel() * fatorElevado;
        double denominador = fatorElevado - 1;
        return numerador / denominador;
    }

    @Override
    public double totalPago(){
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    @Override
    public String toString() {
        return "OPÇÃO: Apartamento\n " +  super.toString();
    }
}
