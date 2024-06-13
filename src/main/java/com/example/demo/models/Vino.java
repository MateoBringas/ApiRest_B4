package com.example.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Vino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer aniada;
    private String imagenEtiqueta;
    private String nombre;
    private String notaDeCataBodega;
    private Double precioARS;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Bodega bodega;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Resenia> resenia;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Varietal> varietal;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Maridaje> maridaje;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAniada() {
        return aniada;
    }

    public void setAniada(Integer aniada) {
        this.aniada = aniada;
    }

    public String getImagenEtiqueta() {
        return imagenEtiqueta;
    }

    public void setImagenEtiqueta(String imagenEtiqueta) {
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNotaDeCataBodega() {
        return notaDeCataBodega;
    }

    public void setNotaDeCataBodega(String notaDeCataBodega) {
        this.notaDeCataBodega = notaDeCataBodega;
    }

    public Double getPrecioARS() {
        return precioARS;
    }

    public void setPrecioARS(Double precioARS) {
        this.precioARS = precioARS;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Resenia> getResenia() {
        return resenia;
    }

    public void setResenia(List<Resenia> resenia) {
        this.resenia = resenia;
    }

    public List<Varietal> getVarietal() {
        return varietal;
    }

    public void setVarietal(List<Varietal> varietal) {
        this.varietal = varietal;
    }

    public List<Maridaje> getMaridaje() {
        return maridaje;
    }

    public void setMaridaje(List<Maridaje> maridaje) {
        this.maridaje = maridaje;
    }
}


