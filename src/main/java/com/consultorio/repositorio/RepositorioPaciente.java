package com.consultorio.repositorio;

import com.consultorio.modelo.Paciente;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Repositorio para gestionar la persistencia de pacientes.
 */
public class RepositorioPaciente extends RepositorioBase<Paciente> {

    public RepositorioPaciente() {
        super("db/pacientes.json");
    }

    @Override
    public Paciente buscarPorId(String id) {
        for (Paciente p : lista) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    @Override
    protected Type getTipoLista() {
        return new TypeToken<List<Paciente>>(){}.getType();
    }
}
