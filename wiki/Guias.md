# Guías

En esta sección se explica paso a paso cómo configurar, compilar y ejecutar el proyecto en tu computadora.

---

## Requisitos previos

Antes de comenzar, necesitas tener instalado lo siguiente:

| Herramienta | Versión mínima | Enlace de descarga |
|---|---|---|
| Java JDK | 11 | [adoptium.net](https://adoptium.net/) |
| Git | Cualquier versión reciente | [git-scm.com](https://git-scm.com/) |

> El proyecto ya incluye el **Gradle Wrapper**, así que no necesitas instalar Gradle. La primera vez que compiles, el wrapper lo descarga automáticamente.

---

## Paso 1 — Obtener el proyecto

Abre una terminal y clona el repositorio con el siguiente comando:

```bash
git clone https://github.com/TECMI-ESAU/Citas_consultorio_clinico.git
cd Citas_consultorio_clinico
```

Si no tienes experiencia con Git, también puedes descargar el proyecto como archivo ZIP desde el botón verde **"Code"** en GitHub y descomprimirlo en tu computadora.

---

## Paso 2 — Compilar el proyecto

El proyecto se compila con un solo comando que genera un archivo JAR ejecutable con todo incluido.

**En Windows**, abre el símbolo del sistema (`cmd`) dentro de la carpeta del proyecto y ejecuta:

```bat
gradlew.bat shadowJar
```

**En macOS o Linux**, abre la terminal en la carpeta del proyecto y ejecuta:

```bash
./gradlew shadowJar
```

La primera vez tardará unos minutos porque descargará Gradle y las dependencias automáticamente. Al terminar, verás el mensaje `BUILD SUCCESSFUL`.

El archivo compilado se guardará en:

```
build/libs/citas-1.0-all.jar
```

---

## Paso 3 — Ejecutar el programa

Con el archivo JAR ya compilado, ejecuta el programa con el siguiente comando:

```bash
java -jar build/libs/citas-1.0-all.jar
```

En pantalla aparecerá el menú de inicio de sesión:

```
======================================
 SISTEMA DE CITAS - CONSULTORIO CLINICO
======================================
Ingrese su ID de administrador:
```

Las credenciales por defecto son:

| Campo | Valor |
|---|---|
| ID | `admin` |
| Contraseña | `1234` |

---

## Paso 4 — Usar el sistema

Una vez dentro, el programa muestra un menú numerado. Escribe el número de la opción que deseas y presiona **Enter**.

```
======================================
        MENU PRINCIPAL
======================================
  1. Dar de alta doctor
  2. Dar de alta paciente
  3. Crear cita
  4. Relacionar cita con doctor y paciente
  5. Salir
======================================
Seleccione una opcion:
```

Sigue las instrucciones en pantalla para cada operación. Al seleccionar la opción `5`, el programa guarda todos los datos y se cierra.

---

## Archivos de datos

El programa guarda la información automáticamente en archivos JSON dentro de la carpeta `db/`. Si la carpeta no existe, se crea sola al primer arranque. Si los archivos no existen, también se generan automáticamente con valores vacíos (excepto el administrador, que se crea con las credenciales por defecto).

```
db/
├── administradores.json
├── doctores.json
├── pacientes.json
└── citas.json
```

---

## Recompilar desde cero en otro equipo

Si alguien más quiere compilar y ejecutar el proyecto desde el repositorio:

```bash
git clone https://github.com/TECMI-ESAU/Citas_consultorio_clinico.git
cd Citas_consultorio_clinico
gradlew.bat shadowJar
java -jar build/libs/citas-1.0-all.jar
```
