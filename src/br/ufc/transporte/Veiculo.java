package br.ufc.transporte;

public abstract class Veiculo extends EntidadeUrbana implements Transportavel {
    private int capacidade;
        private double custoOperacional;
            
                private static final int CAPACIDADE_MAXIMA_PADRAO = 1000;
                    private static final double CUSTO_MAXIMO_PADRAO = 1000000.0;

                        public Veiculo(int id, String nome, int capacidade, double custoOperacional) {
                                super(id, nome);
                                        
                                                if (capacidade <= 0) {
                                                            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
                                                                    }
                                                                            
                                                                                    if (capacidade > getCapacidadeMaxima()) {
                                                                                                throw new IllegalArgumentException("Capacidade não pode exceder " + getCapacidadeMaxima() + ".");
                                                                                                        }
                                                                                                                
                                                                                                                        if (custoOperacional < 0) {
                                                                                                                                    throw new IllegalArgumentException("Custo operacional não pode ser negativo.");
                                                                                                                                            }
                                                                                                                                                    
                                                                                                                                                            if (custoOperacional > getCustoMaximo()) {
                                                                                                                                                                        throw new IllegalArgumentException("Custo operacional excede o limite permitido de " + getCustoMaximo() + ".");
                                                                                                                                                                                }
                                                                                                                                                                                        
                                                                                                                                                                                                this.capacidade = capacidade;
                                                                                                                                                                                                        this.custoOperacional = custoOperacional;
                                                                                                                                                                                                            }

                                                                                                                                                                                                                @Override
                                                                                                                                                                                                                    public void mover() {
                                                                                                                                                                                                                            System.out.println(getNome() + " está em movimento.");
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                        public int getCapacidade() {
                                                                                                                                                                                                                                                return capacidade;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                        public double getCustoOperacional() {
                                                                                                                                                                                                                                                                return custoOperacional;
                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                                                                            public String getDescricao() {
                                                                                                                                                                                                                                                                                    return "Veículo: " + getNome() +
                                                                                                                                                                                                                                                                                                   " | Capacidade: " + capacidade +
                                                                                                                                                                                                                                                                                                                  " | Custo Operacional: " + custoOperacional;
                                                                                                                                                                                                                                                                                                                      }

                                                                                                                                                                                                                                                                                                                          public abstract double calcularTarifa();
                                                                                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                                                                                                                                  protected int getCapacidadeMaxima() {
                                                                                                                                                                                                                                                                                                                                          return CAPACIDADE_MAXIMA_PADRAO;
                                                                                                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                                                                                                  
                                                                                                                                                                                                                                                                                                                                                      protected double getCustoMaximo() {
                                                                                                                                                                                                                                                                                                                                                              return CUSTO_MAXIMO_PADRAO;
                                                                                                                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                                                                                                                  }