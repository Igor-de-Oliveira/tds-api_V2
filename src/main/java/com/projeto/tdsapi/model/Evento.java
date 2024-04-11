package com.projeto.tdsapi.model;

import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Evento;

    private Time Evento_D_H;

    private int Evento_Dur;

    private int Evento_Num_Conv;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "id_Local")
    private Local local;

    public Long getId_Evento() {
        return id_Evento;
    }

    public void setId_Evento(Long id_Evento) {
        this.id_Evento = id_Evento;
    }

    public Time getEvento_D_H() {
        return Evento_D_H;
    }

    public void setEvento_D_H(Time evento_D_H) {
        Evento_D_H = evento_D_H;
    }

    public int getEvento_Dur() {
        return Evento_Dur;
    }

    public void setEvento_Dur(int evento_Dur) {
        Evento_Dur = evento_Dur;
    }

    public int getEvento_Num_Conv() {
        return Evento_Num_Conv;
    }

    public void setEvento_Num_Conv(int evento_Num_Conv) {
        Evento_Num_Conv = evento_Num_Conv;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id_Evento, evento.id_Evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Evento);
    }
}
