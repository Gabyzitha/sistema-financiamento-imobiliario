package modelo;

import java.text.DecimalFormat;

public class Casa extends Financiamento{


    // construtor com argumentos da superclasse
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // sobreposição de métodos
    @Override
    public double calcularPagamentoMensal(){
      return super.calcularPagamentoMensal() + 80.0;
    }

    @Override
    public double totalPago(){
        return super.totalPago();
    }

    @Override
    public String toString() {
        return "OPÇÃO: CASA\n" + super.toString();
    }


}
