package br.ufc.transporte;

public abstract class EntidadeUrbana {
    private int id;
        private String nome;

            public EntidadeUrbana(int id, String nome) {
                    if (id <= 0) {
                                throw new IllegalArgumentException("ID deve ser um número positivo.");
                                        }
                                                
                                                        if (nome == null) {
                                                                    throw new IllegalArgumentException("Nome não pode ser nulo.");
                                                                            }
                                                                                    
                                                                                            this.id = id;
                                                                                                    this.nome = nome;
                                                                                                        }

                                                                                                            public int getId() {
                                                                                                                    return id;
                                                                                                                        }

                                                                                                                            public String getNome() {
                                                                                                                                    return nome;
                                                                                                                                        }

                                                                                                                                            public String getDescricao() {
                                                                                                                                                    return "Entidade Urbana: " + nome + " (ID: " + id + ")";
                                                                                                                                                        }
                                                                                                                                                        }