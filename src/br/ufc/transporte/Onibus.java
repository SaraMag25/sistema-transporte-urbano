package br.ufc.transporte;
//dando erro a espera do allan
public class Onibus extends Veiculo {

    private String linha;

    public Onibus(int id, String nome, String linha, int capacidade, double custoOperacional) {
            super(id, nome, capacidade, custoOperacional);  // Chama super() primeiro
                this.linha = linha;
                }
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
