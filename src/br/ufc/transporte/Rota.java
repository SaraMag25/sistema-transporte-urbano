package br.ufc.transporte;

import java.util.List;
import java.util.ArrayList;

public class Rota {

    private List<String> pontosParada;
    private String nome;
    private double distanciaKm;

    public Rota(String nome, double distanciaKm) {
        this.nome = nome;
        this.distanciaKm = distanciaKm;
        this.pontosParada = new ArrayList<>();
    }

    public void adicionarPontoParada(String ponto) {
        pontosParada.add(ponto);
    }

    public void removerPontoParada(String ponto) {
        pontosParada.remove(ponto);
    }

    public List<String> getPontosParada() {
        return new ArrayList<>(pontosParada);
    }

    public String getNome() {
        return nome;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void otimizarRotas() {
        System.out.println(
            "Calculando caminho mais curto entre " + pontosParada.size() + " pontos."
        );
    }

    public String getDescricao() {
        return "Rota: " + nome +
               " | Distância: " + distanciaKm + "km" +
               " | Paradas: " + pontosParada.size();
    }

    public boolean podeSerUsadaPor(Veiculo veiculo) {
        return veiculo.getCapacidade() > 0;
    }
}
