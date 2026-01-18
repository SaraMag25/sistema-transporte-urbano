package br.ufc.transporte;
//dando erro a espera do allan
public class Metro extends Veiculo {

    private boolean subterraneo;

    public Metro(boolean subterraneo, int capacidade, double custoOperacional) {
        this.subterraneo = subterraneo;
        this.capacidade = capacidade;
        this.custoOperacional = custoOperacional;
    }

    @Override
    public double calcularTarifa() {
        return subterraneo ? 5.00 : 4.75;
    }

    @Override
    public void mover() {
        System.out.println("Metrô em operação");
    }
}
