package com.projeto.tdsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "avaliacao")
public class avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_avaliacao;

    private String avaliacao_Desc;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id_Usuario")
    private Usuario usuario;

    public Long getIdavaliacao() {
        return id_avaliacao;
    }

    public void setIdavaliacao(Long id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getAvaliacao_Desc() {
        return avaliacao_Desc;
    }

    public void setAvaliacao_Desc(String avaliacao_Desc) {
        this.avaliacao_Desc = avaliacao_Desc;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        avaliacao avaliacao = (avaliacao) o;
        return Objects.equals(id_avaliacao, avaliacao.id_avaliacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_avaliacao);
    }
}
