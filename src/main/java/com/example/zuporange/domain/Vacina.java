package com.example.zuporange.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Vacina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nome não dever ser nulo ou em branco")
    private String nomeVacina;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "Campo ID do usuario não pode ser nulo")
    private Usuario usuarioID;

    @JsonFormat(pattern = "dd/MM/yyyy",timezone = "GMT-3")
    @NotNull
    private Date dataVacina;

    public Vacina() {
    }

    public Vacina(Integer id, String nomeVacina, Usuario usuarioID, Date dataVacina) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.usuarioID = usuarioID;
        this.dataVacina = dataVacina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public Usuario getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Usuario usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacina vacina = (Vacina) o;
        return Objects.equals(id, vacina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
