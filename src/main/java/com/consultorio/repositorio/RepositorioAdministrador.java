package com.consultorio.repositorio;

import com.consultorio.modelo.Administrador;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Repositorio para gestionar la persistencia de administradores.
 * Si no existe ninguno, crea el administrador por defecto (admin/1234).
 */
public class RepositorioAdministrador extends RepositorioBase<Administrador> {

    public RepositorioAdministrador() {
        super("db/administradores.json");
    }

    @Override
    public void cargar() {
        super.cargar();
        if (lista.isEmpty()) {
            lista.add(new Administrador("admin", "1234"));
            guardar();
        }
    }

    @Override
    public Administrador buscarPorId(String id) {
        for (Administrador a : lista) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Administrador>>(){}.getType();
    }
}
