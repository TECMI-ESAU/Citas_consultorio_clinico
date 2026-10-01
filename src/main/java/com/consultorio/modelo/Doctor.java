package com.consultorio.modelo;

/**
 * Representa a un doctor del consultorio médico.
 */
public class Doctor extends Persona {

    private String especialidad;

    public Doctor() {}

    public Doctor(String id, String nombreCompleto, String especialidad) {
        super(id, nombreCompleto);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String mostrarInfo() {
        return "Doctor [" + id + "] " + nombreCompleto + " - Especialidad: " + especialidad;
    }
}
