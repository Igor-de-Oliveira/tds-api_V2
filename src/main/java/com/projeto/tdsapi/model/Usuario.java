package com.projeto.tdsapi.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuario;

    @NotNull
    @Size(min = 0, max = 45)
    private String Usuario_name;

    private int Usuario_idade;

    @NotNull
    @Size(min = 0, max = 45)
    private String Usuario_pass;

    @NotNull
    @Size(min = 0, max = 45)
    private String Usuario_end;

    @NotNull
    @Size(min = 0, max = 45)
    private String Usuario_email;

    @NotNull
    private Date Usuario_nasc;

    @OneToOne
    @JoinColumn(name = "id_Reserva", referencedColumnName = "id_Reserva")
    private Reserva reserva;

    public Long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getUsuario_name() {
        return Usuario_name;
    }

    public void setUsuario_name(String usuario_name) {
        Usuario_name = usuario_name;
    }

    public int getUsuario_idade() {
        return Usuario_idade;
    }

    public void setUsuario_idade(int usuario_idade) {
        Usuario_idade = usuario_idade;
    }

    public String getUsuario_pass() {
        return Usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        Usuario_pass = usuario_pass;
    }

    public String getUsuario_end() {
        return Usuario_end;
    }

    public void setUsuario_end(String usuario_end) {
        Usuario_end = usuario_end;
    }

    public String getUsuario_email() {
        return Usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        Usuario_email = usuario_email;
    }

    public Date getUsuario_nasc() {
        return Usuario_nasc;
    }

    public void setUsuario_nasc(Date usuario_nasc) {
        Usuario_nasc = usuario_nasc;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id_Usuario, usuario.id_Usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Usuario);
    }
}
