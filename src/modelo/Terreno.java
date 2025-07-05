package modelo;

import java.io.Serializable; // Importar Serializable

public class Terreno extends Financiamento implements Serializable { // Implementar Serializable

    private String tipoZona;

    // Construtor com argumentos da superclasse e atributos específicos de Terreno
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        // Tratamento de exceções para atributo específico de Terreno
        if (tipoZona == null || tipoZona.trim().isEmpty()) {
            throw new IllegalArgumentException("\n ⚠ O tipo de zona não pode ser vazio.\n");
        }
        this.tipoZona = tipoZona.trim();
    }

    // Getters e Setters
    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        if (tipoZona == null || tipoZona.trim().isEmpty()) {
            throw new IllegalArgumentException("\n ⚠ O tipo de zona não pode ser vazio.\n");
        }
        this.tipoZona = tipoZona.trim();
    }

    // Sobreposição de métodos
    @Override
    public double calcularPagamentoMensal(){
        double taxaMensal = this.taxaJurosAnual / 12.0;
        double totalMeses = this.prazoFinanciamento * 12.0;

        // Tratamento para evitar divisão por zero
        if (totalMeses == 0) {
            throw new ArithmeticException("\n ⚠ Prazo de financiamento inválido.\n");
        }
        if (taxaMensal == 0) {
            return this.valorImovel / totalMeses;
        }

        double fatorElevado = Math.pow((1 + taxaMensal), totalMeses);
        double denominador = fatorElevado - 1;

        if (denominador == 0) {
            throw new ArithmeticException("\n⚠ Erro de cálculo: Denominador zero. Revise os dados.\n");
        }

        double numerador = this.valorImovel * fatorElevado;
        return numerador / denominador;
    }


    @Override
    public String toString() {
        // Chama o toString da superclasse para obter os detalhes básicos do financiamento
        return "OPÇÃO: TERRENO\n" +
                super.toString() +
                String.format("TIPO DE ZONA: %s%n", tipoZona);
    }
}