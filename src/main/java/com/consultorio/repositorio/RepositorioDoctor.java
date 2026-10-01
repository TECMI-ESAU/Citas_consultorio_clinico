package com.consultorio.repositorio;

import com.consultorio.modelo.Doctor;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Repositorio para gestionar la persistencia de doctores.
 */
public class RepositorioDoctor extends RepositorioBase<Doctor> {

    public RepositorioDoctor() {
        super("db/doctores.json");
    }

    @Override
    public Doctor buscarPorId(String id) {
        for (Doctor d : lista) {
            if (d.getId().equals(id)) return d;
        }
        return null;
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Doctor>>(){}.getType();
    }
}
