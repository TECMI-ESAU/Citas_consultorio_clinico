package com.consultorio.modelo;

/**
 * Representa a un paciente que acude al consultorio.
 */
public class Paciente extends Persona {

    public Paciente() {}

    public Paciente(String id, String nombreCompleto) {
        super(id, nombreCompleto);
    }

    @Override
    public String mostrarInfo() {
        return "Paciente [" + id + "] " + nombreCompleto;
    }
}
