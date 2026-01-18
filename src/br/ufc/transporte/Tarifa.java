package br.ufc.transporte;

public class Tarifa {

    private double valorBase;

    public Tarifa(double valorBase) {
        this.valorBase = valorBase;
    }

    public double calcularFinal(Passageiro p) {
        return valorBase;
    }
}
