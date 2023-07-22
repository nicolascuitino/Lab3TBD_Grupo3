package com.labtbd2.emergencias.models;

import org.springframework.data.annotation.Id;

public class Tarea {
    @Id
    Integer id;
    String nombre;
    String descripcion;
    Integer cantidad_requeridos;
    Integer cantidad_inscritos;
    Integer id_emergencia;
    Integer id_estado;

    public Tarea() {
    }

    public Tarea(Integer id, String nombre, String descripcion, Integer cantidad_requeridos, Integer cantidad_inscritos, Integer id_emergencia, Integer id_estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad_requeridos = cantidad_requeridos;
        this.cantidad_inscritos = cantidad_inscritos;
        this.id_emergencia = id_emergencia;
        this.id_estado = id_estado;
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

    public Integer getCantidad_requeridos() {
        return cantidad_requeridos;
    }

    public void setCantidad_requeridos(Integer cantidad_requeridos) {
        this.cantidad_requeridos = cantidad_requeridos;
    }

    public Integer getCantidad_inscritos() {
        return cantidad_inscritos;
    }

    public void setCantidad_inscritos(Integer cantidad_inscritos) {
        this.cantidad_inscritos = cantidad_inscritos;
    }

    public Integer getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
}
