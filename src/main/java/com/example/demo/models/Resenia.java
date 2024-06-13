package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Resenia {

    @Id
    @GeneratedValue
    private Long id;
    private String comentario;
    private Boolean esPremium;
    private Date fechaResenia;
    private Integer puntaje;

    @OneToOne
    private Vino vino;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String contenido) {
        this.comentario = contenido;
    }

    public Boolean getEsPremium() {
        return esPremium;
    }

    public void setEsPremium(Boolean esPremium) {
        this.esPremium = esPremium;
    }

    public Date getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(Date fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }
}
