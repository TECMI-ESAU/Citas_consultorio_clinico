package com.consultorio.interfaces;

/**
 * Contrato de persistencia para repositorios del sistema.
 */
public interface Persistible {
    void guardar();
    void cargar();
}
