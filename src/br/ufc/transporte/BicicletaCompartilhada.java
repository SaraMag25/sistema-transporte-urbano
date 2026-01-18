package br.ufc.transporte;

public class BicicletaCompartilhada extends Veiculo {

    private String estacaoOrigem;

    public BicicletaCompartilhada(
            int id,
            String nome,
            String estacaoOrigem,
            double custoOperacional
    ) {
        super(id, nome, 1, custoOperacional);
        this.estacaoOrigem = estacaoOrigem;
    }

    @Override
    protected int getCapacidadeMaxima() {
        return 1;
    }

    @Override
    public double calcularTarifa() {
        return 2.00;
    }

    @Override
    public void mover() {
        System.out.println("Bicicleta retirada da " + estacaoOrigem);
    }
}
