package com.consultorio;

import com.consultorio.modelo.*;
import com.consultorio.repositorio.*;

import java.util.Scanner;

/**
 * Clase principal que coordina el flujo del sistema de citas.
 */
public class SistemaCitas {

    private RepositorioDoctor repoDoctor = new RepositorioDoctor();
    private RepositorioPaciente repoPaciente = new RepositorioPaciente();
    private RepositorioCita repoCita = new RepositorioCita();
    private RepositorioAdministrador repoAdmin = new RepositorioAdministrador();
    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        repoDoctor.cargar();
        repoPaciente.cargar();
        repoCita.cargar();
        repoAdmin.cargar();

        if (autenticar()) {
            menuPrincipal();
        } else {
            System.out.println("Acceso denegado. Demasiados intentos fallidos.");
        }
    }

    private boolean autenticar() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.println("======================================");
            System.out.println(" SISTEMA DE CITAS - CONSULTORIO CLINICO");
            System.out.println("======================================");
            System.out.print("Ingrese su ID de administrador: ");
            String id = scanner.nextLine().trim();
            System.out.print("Ingrese su contrasena: ");
            String pass = scanner.nextLine().trim();

            Administrador admin = repoAdmin.buscarPorId(id);
            if (admin != null && admin.autenticar(id, pass)) {
                System.out.println("Acceso concedido. Bienvenido, " + id + ".");
                return true;
            }
            intentos++;
            System.out.println("Credenciales incorrectas. Intentos restantes: " + (3 - intentos));
        }
        return false;
    }

    private void menuPrincipal() {
        int opcion = -1;
        while (opcion != 5) {
            System.out.println("\n======================================");
            System.out.println("         MENU PRINCIPAL");
            System.out.println("======================================");
            System.out.println("  1. Dar de alta doctor");
            System.out.println("  2. Dar de alta paciente");
            System.out.println("  3. Crear cita");
            System.out.println("  4. Relacionar cita con doctor y paciente");
            System.out.println("  5. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1: altaDoctor(); break;
                    case 2: altaPaciente(); break;
                    case 3: crearCita(); break;
                    case 4: relacionarCita(); break;
                    case 5: guardarTodo(); break;
                    default: System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero valido.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void altaDoctor() {
        try {
            System.out.println("\n-- Alta de Doctor --");
            System.out.print("ID del doctor: ");
            String id = scanner.nextLine().trim();
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine().trim();
            repoDoctor.agregar(new Doctor(id, nombre, especialidad));
            System.out.println("Doctor registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar doctor: " + e.getMessage());
        }
    }

    private void altaPaciente() {
        try {
            System.out.println("\n-- Alta de Paciente --");
            System.out.print("ID del paciente: ");
            String id = scanner.nextLine().trim();
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine().trim();
            repoPaciente.agregar(new Paciente(id, nombre));
            System.out.println("Paciente registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
        }
    }

    private void crearCita() {
        try {
            System.out.println("\n-- Crear Cita --");
            System.out.print("ID de la cita: ");
            String id = scanner.nextLine().trim();
            System.out.print("Fecha y hora (DD/MM/AAAA HH:MM): ");
            String fechaHora = scanner.nextLine().trim();
            System.out.print("Motivo de la cita: ");
            String motivo = scanner.nextLine().trim();
            repoCita.agregar(new Cita(id, fechaHora, motivo));
            System.out.println("Cita creada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear cita: " + e.getMessage());
        }
    }

    private void relacionarCita() {
        try {
            System.out.println("\n-- Relacionar Cita --");
            System.out.print("ID de la cita: ");
            String idCita = scanner.nextLine().trim();
            System.out.print("ID del doctor: ");
            String idDoctor = scanner.nextLine().trim();
            System.out.print("ID del paciente: ");
            String idPaciente = scanner.nextLine().trim();

            Cita cita = repoCita.buscarPorId(idCita);
            Doctor doctor = repoDoctor.buscarPorId(idDoctor);
            Paciente paciente = repoPaciente.buscarPorId(idPaciente);

            if (cita == null) { System.out.println("No se encontro la cita con ID: " + idCita); return; }
            if (doctor == null) { System.out.println("No se encontro el doctor con ID: " + idDoctor); return; }
            if (paciente == null) { System.out.println("No se encontro el paciente con ID: " + idPaciente); return; }

            cita.setDoctor(doctor);
            cita.setPaciente(paciente);
            System.out.println("Cita relacionada correctamente.");
            System.out.println(cita.mostrarInfo());
        } catch (Exception e) {
            System.out.println("Error al relacionar cita: " + e.getMessage());
        }
    }

    private void guardarTodo() {
        try {
            repoDoctor.guardar();
            repoPaciente.guardar();
            repoCita.guardar();
            repoAdmin.guardar();
            System.out.println("Datos guardados correctamente. Hasta luego.");
        } catch (Exception e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}
