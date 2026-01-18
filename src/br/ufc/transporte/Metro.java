package br.ufc.transporte;

public class Metro extends Veiculo {

    private boolean subterraneo;

    public Metro(int id, String nome, boolean subterraneo, int capacidade, double custoOperacional) {
        super(id, nome, capacidade, custoOperacional);
        this.subterraneo = subterraneo;
    }

    @Override
    public double calcularTarifa() {
        return subterraneo ? 5.00 : 4.75;
    }

    @Override
    public void mover() {
        System.out.println("Metrô funcionando");
    }
}
