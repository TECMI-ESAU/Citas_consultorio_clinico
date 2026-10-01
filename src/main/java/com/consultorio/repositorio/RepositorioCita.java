package com.consultorio.repositorio;

import com.consultorio.modelo.Cita;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Repositorio para gestionar la persistencia de citas.
 */
public class RepositorioCita extends RepositorioBase<Cita> {

    public RepositorioCita() {
        super("db/citas.json");
    }

    @Override
    public Cita buscarPorId(String id) {
        for (Cita c : lista) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Cita>>(){}.getType();
    }
}
