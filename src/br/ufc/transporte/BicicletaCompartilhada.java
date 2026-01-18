package br.ufc.transporte;

public class BicicletaCompartilhada extends Veiculo {

    private String estacaoOrigem;

    public BicicletaCompartilhada(String estacaoOrigem, double custoOperacional) {
        this.estacaoOrigem = estacaoOrigem;
        this.capacidade = 1;
        this.custoOperacional = custoOperacional;
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
