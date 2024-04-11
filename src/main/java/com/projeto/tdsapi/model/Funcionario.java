package com.projeto.tdsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Funcionario;

    private String Funcionario_CPF;

    private String Funcionario_End;

    private int Funcionario_Cel;

    @ManyToOne
    @JoinColumn(name = "evento", referencedColumnName = "id_Evento")
    private Evento evento;

    public Long getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(Long id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public String getFuncionario_CPF() {
        return Funcionario_CPF;
    }

    public void setFuncionario_CPF(String funcionario_CPF) {
        Funcionario_CPF = funcionario_CPF;
    }

    public String getFuncionario_End() {
        return Funcionario_End;
    }

    public void setFuncionario_End(String funcionario_End) {
        Funcionario_End = funcionario_End;
    }

    public int getFuncionario_Cel() {
        return Funcionario_Cel;
    }

    public void setFuncionario_Cel(int funcionario_Cel) {
        Funcionario_Cel = funcionario_Cel;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id_Funcionario, that.id_Funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Funcionario);
    }
}
