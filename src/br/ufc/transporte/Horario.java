package br.ufc.transporte;

import java.util.Date;

public class Horario {

    private Date saida;
    private Date chegada;

    public Horario(Date saida, Date chegada) {

        if (saida == null || chegada == null) {
            throw new IllegalArgumentException("Horários não podem ser nulos.");
        }

        if (chegada.before(saida)) {
            throw new IllegalArgumentException(
                "Horário de chegada não pode ser antes da saída."
            );
        }

        this.saida = saida;
        this.chegada = chegada;
    }

    public Date getSaida() {
        return (Date) saida.clone();
    }

    public Date getChegada() {
        return (Date) chegada.clone();
    }

    public long getDuracaoMinutos() {
        long diferencaMs = chegada.getTime() - saida.getTime();
        return diferencaMs / (60 * 1000);
    }

    public boolean verificarAtraso(Date horarioRealChegada) {
        return horarioRealChegada.after(chegada);
    }

    public boolean verificarAtraso() {
        Date agora = new Date();
        return agora.after(chegada);
    }

    public String getDescricao() {
        return "Saída: " + saida +
               " | Chegada: " + chegada +
               " | Duração: " + getDuracaoMinutos() + " min";
    }
}
