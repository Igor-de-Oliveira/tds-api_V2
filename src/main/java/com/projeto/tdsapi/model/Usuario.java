package com.projeto.tdsapi.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Usuario;

    private String Usuario_name;

    private int Usuario_idade;

    private String Usuario_pass;

    private String Usuario_end;

    private String Usuario_email;

    private Date Usuario_nasc;

    /*@OneToMany
    @JoinColumn(name = "reserva", referencedColumnName = "idReserva")
    private List<Reserva> idreservas;*/

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

    /*public List<Reserva> getIdreservas() {
        return idreservas;
    }

    public void setIdreservas(List<Reserva> idreservas) {
        this.idreservas = idreservas;
    }*/

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
