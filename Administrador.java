package com.consultorio.modelo;

import com.consultorio.interfaces.Autenticable;

/**
 * Usuario administrador con control de acceso al sistema.
 */
public class Administrador implements Autenticable {

    private String id;
    private String contrasena;

    public Administrador() {}

    public Administrador(String id, String contrasena) {
        this.id = id;
        this.contrasena = contrasena;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    @Override
    public boolean autenticar(String id, String contrasena) {
        return this.id.equals(id) && this.contrasena.equals(contrasena);
    }
}
