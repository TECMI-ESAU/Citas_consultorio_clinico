package com.consultorio.repositorio;

import com.consultorio.interfaces.Persistible;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase base genérica para todos los repositorios del sistema.
 */
public abstract class RepositorioBase<T> implements Persistible {

    protected List<T> lista = new ArrayList<>();
    protected String rutaArchivo;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public RepositorioBase(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public List<T> listarTodos() {
        return lista;
    }

    public abstract T buscarPorId(String id);

    protected abstract Type getTipoLista();

    @Override
    public void guardar() {
        try {
            File archivo = new File(rutaArchivo);
            archivo.getParentFile().mkdirs();
            try (Writer writer = new FileWriter(archivo)) {
                gson.toJson(lista, writer);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public void cargar() {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                archivo.getParentFile().mkdirs();
                archivo.createNewFile();
                try (Writer writer = new FileWriter(archivo)) {
                    writer.write("[]");
                }
            }
            try (Reader reader = new FileReader(archivo)) {
                List<T> cargada = gson.fromJson(reader, getTipoLista());
                if (cargada != null) lista = cargada;
            }
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
}
