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
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Pagamento;

    private String Pagamento_status;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id_Usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "local", referencedColumnName = "id_Local")
    private Local local;

    public Long getId_Pagamento() {
        return id_Pagamento;
    }

    public void setId_Pagamento(Long id_Pagamento) {
        this.id_Pagamento = id_Pagamento;
    }

    public String getPagamento_status() {
        return Pagamento_status;
    }

    public void setPagamento_status(String pagamento_status) {
        Pagamento_status = pagamento_status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id_Pagamento, pagamento.id_Pagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Pagamento);
    }
}
