package com.consultorio.modelo;

/**
 * Clase base abstracta para Doctor, Paciente y Administrador.
 */
public abstract class Persona {

    protected String id;
    protected String nombreCompleto;

    public Persona() {}

    public Persona(String id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public abstract String mostrarInfo();
}
