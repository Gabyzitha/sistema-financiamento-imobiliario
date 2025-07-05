package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    private int numeroVagasGaragem;
    private int numeroAndar;

    // Construtor com argumentos da superclasse e atributos específicos de Apartamento
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroAndar, int numeroVagasGaragem) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        // Tratamento de exceções para os atributos específicos de Apartamento
        if (numeroAndar < 0) { // Assumindo que andar pode ser 0 (térreo)
            throw new IllegalArgumentException("\n⚠ O número do andar não pode ser negativo.\n");
        }
        if (numeroVagasGaragem < 0) {
            throw new IllegalArgumentException("\n⚠ O número de vagas de garagem não pode ser negativo.\n");
        }
        this.numeroAndar = numeroAndar;
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    // Getters e Setters
    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public void setNumeroVagasGaragem(int numeroVagasGaragem) {
        if (numeroVagasGaragem < 0) {
            throw new IllegalArgumentException("\n⚠ O número de vagas de garagem não pode ser negativo.\n");
        }
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        if (numeroAndar < 0) {
            throw new IllegalArgumentException("\n⚠ O número do andar não pode ser negativo.\n");
        }
        this.numeroAndar = numeroAndar;
    }

    // Sobreposição de métodos
    @Override
    public double calcularPagamentoMensal(){

        double taxaMensal = this.taxaJurosAnual / 12.0;
        double totalMeses = this.prazoFinanciamento * 12.0;

        // Tratamento para evitar divisão por zero ou resultados matematicamente inválidos
        if (totalMeses == 0) {
            throw new ArithmeticException("\n⚠ Prazo de financiamento inválido.\n");
        }
        if (taxaMensal == 0) {
            return (this.valorImovel / totalMeses) * 1.02;
        }

        double fatorElevado = Math.pow((1 + taxaMensal), totalMeses);
        double denominador = fatorElevado - 1;

        if (denominador == 0) {
            throw new ArithmeticException("\n⚠ Erro de cálculo: Denominador zero. Revise os dados.\n");
        }

        double numerador = this.valorImovel * fatorElevado;
        double parcelaBase = numerador / denominador;

        return parcelaBase * 1.02;
    }

    @Override
    public String toString() {
        // Chama o toString da superclasse para obter os detalhes básicos do financiamento
        return "OPÇÃO: APARTAMENTO\n" +
                super.toString() +
                String.format("VAGAS NA GARAGEM: %d%n" +
                                "NUMERO DO ANDAR: %d%n",
                        numeroVagasGaragem, numeroAndar);
    }
}