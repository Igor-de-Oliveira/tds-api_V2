package com.projeto.tdsapi.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Local;

    @NotNull
    @Size(min = 1, max = 45)
    private String Local_Name;



    private int Local_Cap;

    @NotNull
    @Size(min = 0, max = 45)
    private String Local_End;

    @NotNull
    @Size(min = 0, max = 45)
    private String Local_disp;

    public Long getId_Local() {
        return id_Local;
    }

    public void setId_Local(Long id_Local) {
        this.id_Local = id_Local;
    }

    public String getLocal_Name() {
        return Local_Name;
    }

    public void setLocal_Name(String local_Name) {
        Local_Name = local_Name;
    }

    public int getLocal_Cap() {
        return Local_Cap;
    }

    public void setLocal_Cap(int local_Cap) {
        Local_Cap = local_Cap;
    }

    public String getLocal_End() {
        return Local_End;
    }

    public void setLocal_End(String local_End) {
        Local_End = local_End;
    }

    public String getLocal_disp() {
        return Local_disp;
    }

    public void setLocal_disp(String local_disp) {
        Local_disp = local_disp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local local = (Local) o;
        return Objects.equals(id_Local, local.id_Local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Local);
    }
}
