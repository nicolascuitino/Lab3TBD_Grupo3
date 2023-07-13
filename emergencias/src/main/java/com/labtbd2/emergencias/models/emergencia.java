package com.labtbd2.emergencias.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class emergencia {
    @Id
    Integer id;
    String nombre;
    String descripcion;
    Date fecha_inicio;
    Date fecha_termino;

    public emergencia(Integer id, String nombre, String descripcion, Date fecha_inicio, Date fecha_termino) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    public emergencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }
}
