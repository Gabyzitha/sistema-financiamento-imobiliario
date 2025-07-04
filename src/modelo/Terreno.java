package modelo;

import java.text.DecimalFormat;

public class Terreno extends Financiamento{

    // construtor com argumentos da superclasse
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // sobreposição de métodos

    @Override
    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02;
    }

    @Override
    public double totalPago(){
        return super.totalPago();
    }

    @Override
    public String toString() {
        return "OPÇÃO: Terreno\n" + super.toString();

    }
}
