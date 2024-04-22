package com.projeto.tdsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Reserva;

    @NotNull
    @Size(min = 0, max = 45)
    private String Reserva_status;

    @NotNull
    @Size(min = 0, max = 45)
    private String Reserva_Data;

    @OneToOne
    @JoinColumn(name = "id_local", referencedColumnName = "id_Local")
    private Local local;

    @OneToOne
    @JoinColumn(name = "id_Funcionario", referencedColumnName = "id_Funcionario")
    private Funcionario funcionario;

   /* @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;*/
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
