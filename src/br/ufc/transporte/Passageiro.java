package br.ufc.transporte;

public class Passageiro extends EntidadeUrbana {

    private String cartao;
    private double saldo;
    private static int totalPassageirosGlobais = 0;

    public Passageiro(int id, String nome, String cartao, double saldoInicial) {
        super(id, nome);
        this.cartao = cartao;
        this.saldo = saldoInicial;
        totalPassageirosGlobais++;
    }

    public String getCartao() {
        return cartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitarSaldo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }
        if (saldo < valor) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }

    public void carregarSaldo(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void usarRota(Rota r, Veiculo veiculo) {
        System.out.println(
            "Passageiro " + getNome() + " iniciando jornada na rota: " + r.getDescricao()
        );

        double tarifa = veiculo.calcularTarifa();

        if (saldo >= tarifa) {
            debitarSaldo(tarifa);
            System.out.println(
                "Tarifa de R$ " + tarifa + " debitada. Saldo restante: R$ " + saldo
            );
        } else {
            System.out.println("Saldo insuficiente para usar a rota.");
        }
    }

    public static int getTotalPassageiros() {
        return totalPassageirosGlobais;
    }

    @Override
    public String getDescricao() {
        return "Passageiro: " + getNome() +
               " | Cartão: " + cartao +
               " | Saldo: R$ " + saldo;
    }
}
