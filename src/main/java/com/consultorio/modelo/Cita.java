package com.consultorio.modelo;

/**
 * Representa una cita médica con fecha, hora, motivo, doctor y paciente.
 */
public class Cita {

    private String id;
    private String fechaHora;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita() {}

    public Cita(String id, String fechaHora, String motivo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public String mostrarInfo() {
        String doc = (doctor != null) ? doctor.getNombreCompleto() : "Sin asignar";
        String pac = (paciente != null) ? paciente.getNombreCompleto() : "Sin asignar";
        return "Cita [" + id + "] " + fechaHora + " | Motivo: " + motivo
                + " | Doctor: " + doc + " | Paciente: " + pac;
    }
}
