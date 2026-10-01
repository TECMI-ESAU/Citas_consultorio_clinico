# Sistema de Administración de Citas — Consultorio Clínico

Este proyecto es una aplicación de consola desarrollada en Java que simula el sistema de administración de citas de un consultorio médico. Permite registrar doctores y pacientes, crear citas médicas y asignarlas a un doctor y paciente específicos. El acceso al sistema está protegido por un usuario administrador con contraseña.

---

## Instalación y Configuración

### Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente en tu computadora:

- **Java JDK 11 o superior** — Es el entorno necesario para ejecutar programas en Java. [Descargar aquí](https://adoptium.net/)
- **Git** — Herramienta para clonar el repositorio desde GitHub. [Descargar aquí](https://git-scm.com/)

> El proyecto incluye el **Gradle Wrapper**, por lo que **no es necesario instalar Gradle** por separado. El wrapper lo descarga automáticamente la primera vez que se usa.

Para verificar que Java está correctamente instalado, abre una terminal y ejecuta:

```bash
java -version
```

Deberías ver una línea como `java version "11.x.x"` o superior.

### Obtener el proyecto

Clona el repositorio desde GitHub con el siguiente comando:

```bash
git clone https://github.com/TECMI-ESAU/Citas_consultorio_clinico.git
cd Citas_consultorio_clinico
```

### Compilar el proyecto

El proyecto se compila usando Gradle con el plugin **Shadow**, que empaqueta el código y todas sus dependencias en un solo archivo JAR ejecutable.

En **Windows**:
```bat
gradlew.bat shadowJar
```

En **macOS o Linux**:
```bash
./gradlew shadowJar
```

Después de compilar, el archivo ejecutable se encuentra en:
```
build/libs/citas-1.0-all.jar
```

---

## Uso del Programa

### Cómo ejecutar la aplicación

Una vez compilado, ejecuta el programa con el siguiente comando:

```bash
java -jar build/libs/citas-1.0-all.jar
```

La aplicación funciona completamente desde la consola (terminal). No requiere interfaz gráfica ni instalaciones adicionales — solo Java.

### Inicio de sesión

Al arrancar el programa, se solicita un identificador y una contraseña de administrador. Si las credenciales son incorrectas, el sistema permite hasta **3 intentos** antes de cerrarse automáticamente.

Las credenciales por defecto son:

| Campo | Valor |
|-------|-------|
| ID de administrador | `admin` |
| Contraseña | `1234` |

### Menú principal

Una vez autenticado correctamente, aparece el menú con las siguientes opciones:

| Opción | Acción |
|--------|--------|
| 1 | Dar de alta un doctor |
| 2 | Dar de alta un paciente |
| 3 | Crear una cita |
| 4 | Relacionar una cita con un doctor y un paciente |
| 5 | Guardar y salir |

### Descripción de cada opción

1. **Dar de alta doctor** — Registra un nuevo doctor ingresando su ID único, nombre completo y especialidad médica.
2. **Dar de alta paciente** — Registra un nuevo paciente ingresando su ID único y nombre completo.
3. **Crear cita** — Crea una nueva cita ingresando su ID único, fecha y hora (formato `DD/MM/AAAA HH:MM`) y el motivo de la consulta.
4. **Relacionar cita** — Vincula una cita ya creada con un doctor y un paciente existentes. El sistema valida que los tres IDs existan antes de hacer la vinculación.
5. **Salir** — Guarda todos los datos en archivos JSON y cierra el programa.

### Almacenamiento de datos

Todos los datos registrados se guardan automáticamente en archivos con formato JSON dentro de la carpeta `db/`. Esta carpeta se crea sola la primera vez que se ejecuta el programa. Los archivos son los siguientes:

```
db/
├── administradores.json   — Credenciales de acceso
├── doctores.json          — Lista de doctores registrados
├── pacientes.json         — Lista de pacientes registrados
└── citas.json             — Lista de citas creadas
```

> Esta carpeta no se incluye en el repositorio de GitHub por motivos de privacidad.

### Archivos del Avance 1

Los diagramas y el pseudocódigo desarrollados en la primera etapa del proyecto se encuentran en la carpeta `avance1/`:

```
avance1/
├── diagrama-clases.drawio   — Diagrama UML de clases
├── diagrama-clases.jpg
├── diagrama-flujo.drawio    — Diagrama de flujo del programa
├── diagrama-flujo.jpg
└── pseudocodigo.psc         — Pseudocódigo ejecutable en PSeInt
```

---

## Estructura de Ramas en Git

El repositorio sigue una estrategia de ramas organizada por funcionalidades:

| Rama | Descripción |
|------|-------------|
| `master` | Versión final y estable del proyecto — etiquetada como `v1.0` |
| `develop` | Rama de integración donde se consolidan todas las funcionalidades |
| `feature/configuracion_gradle` | Configuración inicial del proyecto con Gradle |
| `feature/clases_dominio` | Clases del modelo de datos (Doctor, Paciente, Cita, Persona) |
| `feature/repositorios` | Capa de persistencia y lectura/escritura de archivos JSON |
| `feature/autenticacion` | Clase Administrador y control de acceso |
| `feature/sistema_citas` | Lógica principal del sistema y punto de entrada |

---

## Documentación adicional

La documentación completa del proyecto está disponible en la [Wiki del repositorio](https://github.com/TECMI-ESAU/Citas_consultorio_clinico/wiki). Incluye las siguientes secciones:

- **Acerca de** — Descripción general del sistema y las tecnologías utilizadas.
- **Proyecto** — Diagramas de flujo y de clases, con descripción detallada de cada clase y sus métodos.
- **Guías** — Instrucciones paso a paso para configurar, compilar y ejecutar el programa.

---

## Créditos

| Campo | Detalle |
|-------|---------|
| Autor | Manuel Esau Noriega Rodriguez |
| Institución | Tecmilenio |
| Proyecto | Evidencia — Sistema de Administración de Citas |

---

## Licencia

MIT License — Copyright (c) 2025 Manuel Esau Noriega Rodriguez

Se otorga permiso para usar, copiar, modificar, fusionar, publicar, distribuir y/o vender copias de este software de forma gratuita, siempre que se incluya el aviso de copyright en todas las copias o partes sustanciales del mismo.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO.
