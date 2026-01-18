package br.ufc.transporte;
//dando erro a espera do allan
public class Onibus extends Veiculo {

    private String linha;

    public Onibus(String linha, int capacidade, double custoOperacional) {
        this.linha = linha;
        this.capacidade = capacidade;
        this.custoOperacional = custoOperacional;
    }

    @Override
    public double calcularTarifa() {
        return 4.50;
    }

    @Override
    public void mover() {
        System.out.println("Ônibus da linha " + linha + " em movimento ");
    }
}
