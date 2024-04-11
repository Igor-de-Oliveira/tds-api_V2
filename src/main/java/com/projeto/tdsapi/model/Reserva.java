package com.projeto.tdsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Reserva;

    private String Reserva_status;

    private String Reserva_Data;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "id_Local")
    private Local local;

    /*@OneToMany
    @JoinColumn(name = "funcionario", referencedColumnName = "id_Funcionario")
    private List<Funcionario> funcionario;*/

    public Long getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(Long id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public String getReserva_status() {
        return Reserva_status;
    }

    public void setReserva_status(String reserva_status) {
        Reserva_status = reserva_status;
    }

    public String getReserva_Data() {
        return Reserva_Data;
    }

    public void setReserva_Data(String reserva_Data) {
        Reserva_Data = reserva_Data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    /*public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id_Reserva, reserva.id_Reserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Reserva);
    }
}
