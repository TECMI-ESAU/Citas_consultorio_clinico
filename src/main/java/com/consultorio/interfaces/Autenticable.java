package com.consultorio.interfaces;

/**
 * Contrato de autenticación para entidades con control de acceso.
 */
public interface Autenticable {
    boolean autenticar(String id, String contrasena);
}
