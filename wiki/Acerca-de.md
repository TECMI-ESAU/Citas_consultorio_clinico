# Acerca de

## ¿Qué es este proyecto?

El **Sistema de Administración de Citas** es una aplicación de consola desarrollada en Java como parte de una evidencia universitaria. El objetivo del proyecto es simular el funcionamiento básico de un consultorio médico, permitiendo gestionar doctores, pacientes y citas de manera organizada.

El sistema fue desarrollado aplicando los principios de la **Programación Orientada a Objetos (POO)**, incluyendo herencia, polimorfismo, abstracción e interfaces.

---

## ¿Qué puede hacer el sistema?

- Controlar el acceso al sistema mediante un usuario administrador con contraseña.
- Registrar doctores con su identificador, nombre completo y especialidad médica.
- Registrar pacientes con su identificador y nombre completo.
- Crear citas médicas con identificador, fecha, hora y motivo de consulta.
- Vincular cada cita con un doctor y un paciente previamente registrados.
- Guardar toda la información de forma persistente en archivos JSON.
- Recuperar automáticamente los datos al volver a ejecutar el programa.
- Continuar funcionando aunque ocurra algún error, mostrando el mensaje correspondiente en pantalla.

---

## Tecnologías utilizadas

| Tecnología | Versión | ¿Para qué se usa? |
|---|---|---|
| Java | 11 o superior | Lenguaje principal de programación |
| Gradle | 8.5 | Herramienta para compilar y empaquetar el proyecto |
| Shadow Plugin | 8.1.1 | Genera el archivo JAR con todas las dependencias incluidas |
| Gson | 2.10.1 | Convierte los objetos Java a formato JSON y viceversa |

---

## Estructura del proyecto

```
Citas_consultorio_clinico/
├── src/                    — Código fuente Java
├── avance1/                — Diagramas y pseudocódigo (Avance 1)
├── wiki/                   — Contenido de la documentación Wiki
├── build.gradle            — Configuración de compilación
├── gradlew.bat             — Ejecutar Gradle en Windows
└── README.md               — Documentación principal
```

---

## Autor

| Campo | Detalle |
|---|---|
| Nombre | Manuel Esau Noriega Rodriguez |
| Institución | Tecmilenio |
| Proyecto | Evidencia — Sistema de Administración de Citas |
