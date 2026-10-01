Algoritmo SistemaCitas
	Definir intentos, autenticado Como Entero
	Definir id_usuario, contrasena Como Cadena
	intentos <- 0
	autenticado <- 0
	Escribir ''
	Escribir ' SISTEMA DE CITAS - CONSULTORIO CLINICO'
	Escribir ''
	Mientras intentos<3 Y autenticado=0 Hacer
		Escribir 'Ingrese su ID de administrador:'
		Leer id_usuario
		Escribir 'Ingrese su contrasena:'
		Leer contrasena
		Si id_usuario='admin' Y contrasena='1234' Entonces
			autenticado <- 1
			Escribir 'Acceso concedido. Bienvenido.'
		SiNo
			intentos <- intentos+1
			Escribir 'Credenciales incorrectas. Intentos restantes: ', 3-intentos
		FinSi
	FinMientras
	Si autenticado=1 Entonces
		MenuPrincipal()
	SiNo
		Escribir 'Acceso denegado. Numero maximo de intentos alcanzado.'
		Escribir 'El programa se cerrara.'
	FinSi
FinAlgoritmo

Función MenuPrincipal
	Mientras opcion<>5 Hacer
		Escribir ''
		Escribir '        MENU PRINCIPAL'
		Escribir '  1. Dar de alta doctor'
		Escribir '  2. Dar de alta paciente'
		Escribir '  3. Crear cita'
		Escribir '  4. Relacionar cita con doctor y paciente'
		Escribir '  5. Salir'
		Escribir ''
		Escribir 'Seleccione una opcion:'
		Leer opcion
		Si opcion=1 Entonces
			AltaDoctor()
		SiNo
			Si opcion=2 Entonces
				AltaPaciente()
			SiNo
				Si opcion=3 Entonces
					CrearCita()
				SiNo
					Si opcion=4 Entonces
						RelacionarCita()
					SiNo
						Si opcion=5 Entonces
							GuardarTodo()
							Escribir 'Datos guardados. Hasta luego.'
						SiNo
							Escribir 'Opcion no valida. Intente de nuevo.'
						FinSi
					FinSi
				FinSi
			FinSi
		FinSi
	FinMientras
FinFunción

Función AltaDoctor
	Definir id_doctor, nombre_doctor, especialidad_doctor Como Cadena
	Escribir ''
	Escribir '-- Registro de Doctor --'
	Escribir 'ID unico del doctor:'
	Leer id_doctor
	Escribir 'Nombre completo:'
	Leer nombre_doctor
	Escribir 'Especialidad:'
	Leer especialidad_doctor
	Escribir ''
	Escribir 'Doctor registrado:'
	Escribir '  ID          : ', id_doctor
	Escribir '  Nombre      : ', nombre_doctor
	Escribir '  Especialidad: ', especialidad_doctor
	Escribir 'Doctor registrado correctamente.'
FinFunción

Función AltaPaciente
	Definir id_paciente, nombre_paciente Como Cadena
	Escribir ''
	Escribir '--Registro de Paciente --'
	Escribir 'ID unico del paciente:'
	Leer id_paciente
	Escribir 'Nombre completo:'
	Leer nombre_paciente
	Escribir ''
	Escribir 'Paciente registrado:'
	Escribir '  ID    : ', id_paciente
	Escribir '  Nombre: ', nombre_paciente
	Escribir 'Paciente registrado correctamente.'
FinFunción

Función CrearCita
	Definir id_cita, fecha_hora, motivo Como Cadena
	Escribir ''
	Escribir '-- Nueva Cita --'
	Escribir 'ID unico de la cita:'
	Leer id_cita
	Escribir 'Fecha y hora (DD/MM/AAAA HH:MM):'
	Leer fecha_hora
	Escribir 'Motivo de la cita:'
	Leer motivo
	Escribir ''
	Escribir 'Cita creada:'
	Escribir '  ID        : ', id_cita
	Escribir '  Fecha/Hora: ', fecha_hora
	Escribir '  Motivo    : ', motivo
	Escribir 'Cita creada correctamente.'
FinFunción

Función RelacionarCita
	Definir id_cita, id_doctor, id_paciente Como Cadena
	Definir cita_existe, doctor_existe, paciente_existe Como Entero
	Escribir ''
	Escribir '-- Relacionar Cita --'
	Escribir 'ID de la cita a relacionar:'
	Leer id_cita
	Escribir 'ID del doctor:'
	Leer id_doctor
	Escribir 'ID del paciente:'
	Leer id_paciente
	Si id_cita<>'' Entonces
		cita_existe <- 1
	SiNo
		cita_existe <- 0
	FinSi
	Si id_doctor<>'' Entonces
		doctor_existe <- 1
	SiNo
		doctor_existe <- 0
	FinSi
	Si id_paciente<>'' Entonces
		paciente_existe <- 1
	SiNo
		paciente_existe <- 0
	FinSi
	Si cita_existe=0 Entonces
		Escribir 'Error: no se encontro la cita con ID: ', id_cita
	SiNo
		Si doctor_existe=0 Entonces
			Escribir 'Error: no se encontro el doctor con ID: ', id_doctor
		SiNo
			Si paciente_existe=0 Entonces
				Escribir 'Error: no se encontro el paciente con ID: ', id_paciente
			SiNo
				Escribir ''
				Escribir 'Cita relacionada:'
				Escribir '  Cita    : ', id_cita
				Escribir '  Doctor  : ', id_doctor
				Escribir '  Paciente: ', id_paciente
				Escribir 'Cita relacionada correctamente con doctor y paciente.'
			FinSi
		FinSi
	FinSi
FinFunción

Función GuardarTodo
	Escribir 'Guardando datos de doctores...'
	Escribir 'Guardando datos de pacientes...'
	Escribir 'Guardando datos de citas...'
	Escribir 'Todos los datos han sido guardados.'
FinFunción
