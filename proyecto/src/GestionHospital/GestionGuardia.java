/*Algunas estructuras de datos La información de los N medicamentos disponibles en el hospital se debe almacenar en un arreglo (no arraylist). Cada medicamento cuenta con los datos: código, descripción, precio unitario y 
 stock disponible. 
 * La información que se registra para un paciente es: dni, nombre, edad, antecedentes (por ejemplo: hipertenso, diabético, etc.), diagnostico preliminar (1 o 2). 
 * La información que se registra para un médico es: matricula profesional, nombre y especialidad. 
 * La información que se registra para una cirugía es: médico responsable, paciente y fecha. 
 * La información que se registra para una consulta médica es: médico a cargo, paciente, medicación administrada, cantidad aplicada, y fecha. 
 * Se requiere de una cola de espera, llamada prioridadMedia, a la cual se remitirán los pacientes con diagnostico preliminar igual a 2.  
 * Se requiere de una cola de espera, llamada prioridadAlta, a la cual se remitirán los pacientes con diagnostico preliminar igual a 1. 
 * Se requiere de una pila, llamada programadas, que almacenará las cirugías que resultan de la atención de los pacientes de la cola prioridadAlta.  
 * Se requiere de una lista para guardar la información de las consultas realizadas que resultan de la atención de los pacientes de la cola prioridadMedia. 
 * Las cirugías que se realizan (salen de la pila programadas) deben guardarse en una lista para su posterior control. 
 * La información de los médicos debe guardarse en un árbol binario de búsqueda llamado disponibles.  
 * A fin de simplificar la complejidad del problema, se considera que los médicos tienen solamente la especialidad cirujano o clínica general. 
 * Además, se asume que para la atención de cada paciente se requiere de un solo medico (tanto para consulta como para cirugía). 
 * De ser necesario, puede hacerse uso de estructuras auxiliares para guardar los objetos generados*/

package GestionHospital;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class GestionGuardia {
	public static BinarySearchTree<Medico> disponibles = new BinarySearchTree<>();
	public static DoubleLinkedList<ConsultaMedica> consultasRealizadas = new DoubleLinkedList<>();	
	public static DoubleLinkedList<Cirugia> cirugiasRealizadas = new DoubleLinkedList<>();
	public static Stack<Cirugia> cirugiasProgramadas = new Stack<Cirugia>();
	public static Medicamento[] arregloMedicamentos;
    public static Queue<Paciente> prioridadMedia = new Queue<Paciente>();
	public static Queue<Paciente> prioridadAlta = new Queue<Paciente>();
	private static Medico medicoClinicaGeneralRepetido = null;
	public static Scanner scanner = new Scanner(System.in);
	private static int contadorPacientesPrioridadMedia = 0;
	private static Medico medicoPrioridadMedia = null;
	
	public static void crearArregloMedicamentos() {
		int N = Helper.validarEnteroNoNegativo(scanner, "Indique la cantidad de medicamentos: ");
		Integer[] codigos = new Integer[N];
		arregloMedicamentos = new Medicamento[N];
		for (int i = 0; i < N; i++) {
			Medicamento medicamento = crearMedicamento(codigos);
			arregloMedicamentos[i] = medicamento;
			codigos[i] = medicamento.getCodigo();
		}
	}
	
	public static Medicamento crearMedicamento(Integer[] codigos){
		int codigo = Helper.validarCodigo(scanner, "Codigo: ", codigos);
		System.out.println("Descripcion: ");
		String descripcion = scanner.nextLine();
		double precioUnitario = Helper.validarDoubleNoNegativo(scanner, "Precio unitario: ");
		int stockDisponible = Helper.validarStock(scanner, "Stock disponible: ");
		Medicamento medicamento = new Medicamento(codigo, descripcion, precioUnitario, stockDisponible);
		return medicamento;
	}

	public static void registrarMedico() {
		int matriculaProfesional = generarMatriculaAleatoria();
		System.out.println("Matricula generada: " + matriculaProfesional);
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine().trim();
		String especialidad = Helper.validarEspecialidad(scanner, "Especialidad: ");
		Medico medico = new Medico(matriculaProfesional,nombre,especialidad);
		disponibles.add(medico);
	}
	
	public static int generarMatriculaAleatoria() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
	
	public static void registrarPaciente() {
		int dni = Helper.validarDni(scanner, "DNI: ");
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine().trim();
		int edad = Helper.validarEdad(scanner, "Edad: ");
		System.out.println("Antecedentes: ");
		String antecedentes = scanner.nextLine();
		int diagnosticoPreliminar = Helper.validarDiagnosticoPreliminar();
		System.out.println("Diagnostico Preliminar: " + diagnosticoPreliminar);
		Paciente paciente = new Paciente(dni,nombre,edad,antecedentes,diagnosticoPreliminar);
		asignarPaciente(paciente);
	}
	
	public static void asignarPaciente(Paciente paciente) {
		if (paciente.getDiagnosticoPreliminar() == 1) {
			System.out.println("El Paciente fue asignado a la cola de Prioridad Alta");
			prioridadAlta.add(paciente);
		}else if (paciente.getDiagnosticoPreliminar() == 2) {
			System.out.println("El Paciente fue asignado a la cola de Prioridad Media");
			prioridadMedia.add(paciente);
		}
	}
	
	public static void atenderPrioridadMedia() {
        if(prioridadMedia.isEmpty()) {
            System.out.println("\nNo hay pacientes en la cola de prioridad media...");
            return; 
        }
        if(arregloMedicamentos==null) {
        	System.out.println("\nNo hay medicamentos disponibles...");
            return;
        }
        if(arregloMedicamentos.length == 0) {
            System.out.println("\nNo hay medicamentos disponibles...");
            return;
        }
    	while (!prioridadMedia.isEmpty())  {
	    	if (contadorPacientesPrioridadMedia == 0) {
	        	medicoPrioridadMedia = extraerMedico("Clinica General");
	        }
        	if (medicoPrioridadMedia == null) {
        		System.out.println("\nNo hay Medico de Clinica General");
        		return;
        	}
        	if(arregloMedicamentos.length != 0) {
        		Paciente paciente = prioridadMedia.pool();
            	System.out.println("\n" + paciente.toString());
            	ConsultaMedica consulta = registrarConsulta(arregloMedicamentos, paciente, medicoPrioridadMedia);
            	consultasRealizadas.addFirst(consulta);
            	contadorPacientesPrioridadMedia++;
            	
            	if (contadorPacientesPrioridadMedia == 10) {
            		contadorPacientesPrioridadMedia = 0;
            		medicoClinicaGeneralRepetido = medicoPrioridadMedia;
            		System.out.println("El médico " + medicoPrioridadMedia.getNombre() + " ha sido reintegrado al árbol.");
            		disponibles.add(medicoPrioridadMedia);
            	}
                
        	}else {
                	System.out.println("\nYa no hay medicamentos disponibles... Lo atendenderemos proximamente.");
                    return;
                }   	
    	}
    	
    	if(prioridadMedia.isEmpty()) {
    		System.out.println("Pacientes de la Cola Prioridad Media atendidos");
    	}
    
	}
	
	@SuppressWarnings("deprecation")
	public static ConsultaMedica registrarConsulta(Medicamento[] medicamentos, Paciente paciente, Medico medico) {
		System.out.println("\n----- Registro de la Consulta del Paciente ------");
		System.out.println("\n"+paciente);
		System.out.println("\nMedico asignado: " + medico.toString());
		Medicamento medicacionAdministrada = obtenerMedicamentoAleatorio(medicamentos);
		System.out.println("Medicacion Administrada: " + medicacionAdministrada.toString());
		int cantidadAplicada = Helper.validarStockMedicamento(scanner, "\nCantidad aplicada:", medicacionAdministrada);
		int anio = Helper.validarAñoActual(scanner, "Año: ");
		int mes = Helper.validarMes(scanner, "Mes: "); 
		int dia = Helper.validarDia(scanner, "Dia: ");
		Date fecha = new Date(anio, mes, dia);
		ConsultaMedica consulta = new ConsultaMedica(medico, paciente, medicacionAdministrada, cantidadAplicada, fecha);
        arregloMedicamentos=descontarStockMedicamento(arregloMedicamentos,medicacionAdministrada, cantidadAplicada);
		return consulta;
	}
	
	private static Medicamento obtenerMedicamentoAleatorio(Medicamento[] arregloMedicamentos) {
    	Random random = new Random();
        int index = random.nextInt(arregloMedicamentos.length);
        return arregloMedicamentos[index];
    }
	
	private static Medicamento[] descontarStockMedicamento(Medicamento[] arregloMedicamentos, Medicamento medicamento, int cantidadAplicada) {
        medicamento.setStockDisponible(medicamento.getStockDisponible() - cantidadAplicada);
        if (medicamento.getStockDisponible() == 0) {
            arregloMedicamentos=eliminarMedicamento(arregloMedicamentos, medicamento);
        }
        return arregloMedicamentos;
    }
	private static Medicamento[] eliminarMedicamento(Medicamento[] medicamentos, Medicamento medicamentoAEliminar) {
	    int tamañoArreglo = medicamentos.length - 1;
	    Medicamento[] nuevoArreglo = new Medicamento[tamañoArreglo];
	    int index = 0;
	    for (Medicamento medicamento : medicamentos) {
	        if (!medicamento.equals(medicamentoAEliminar)) {
	            nuevoArreglo[index++] = medicamento;
	        }
	    }
	    return nuevoArreglo;
	}

	
	public static void atenderPrioridadAlta() {
        if(prioridadAlta.isEmpty() && cirugiasProgramadas.isEmpty()) {
            System.out.println("No hay pacientes en la cola de prioridad alta...ni cirugías programadas...");
            return; 
        }
        while (!prioridadAlta.isEmpty() || !cirugiasProgramadas.isEmpty()) {
        	realizarCirugia();
        	
        	if (!prioridadAlta.isEmpty() && cirugiasProgramadas.size() < 3) {
                for (int i = cirugiasProgramadas.size(); i < 3 && !prioridadAlta.isEmpty(); i++) {
                	System.out.println("\n---Programar Cirugias---");
	                Paciente paciente = prioridadAlta.pool();
	                System.out.println("\nPaciente :" + paciente.getNombre());
	                Medico medicoPrioridadAlta = extraerMedico("Cirujano");
		        	if (medicoPrioridadAlta == null) {
		        		System.out.println("\nNo hay Medicos Cirujanos. ");
		        		System.out.println("\nSerás reintegrado a la cola. ");
		        		prioridadAlta.add(paciente);
		        		break;
		        	}
	            Cirugia cirugia = registrarCirugia(medicoPrioridadAlta, paciente);
	            cirugiasProgramadas.push(cirugia);
	            System.out.println("Cirugia programada para el paciente: " + paciente.getNombre());
        	}
         }
        }
        
    }
	
	private static Medico extraerMedico(String especialidad) {
        if(disponibles.Height() == 0) {
            return null;
        }
        else {
        	Medico medico= disponibles.buscarPorEspecialidad(especialidad);
        	if (medico != null || medico!=medicoClinicaGeneralRepetido) {
        		System.out.println("Se asigno el medico: " + medico);
        	    disponibles.remove(medico);
        	    System.out.println("Médico eliminado del árbol: " + medico.getNombre());
        	    return medico;
        	}
			
		    return null;
        }
    }
	
	public static void realizarCirugia() {
		int quirofanosDisponibles=3; 
		int contador=0;
		while(!cirugiasProgramadas.isEmpty() && contador<quirofanosDisponibles) {
			System.out.println("\n---Cirugias---");
			Cirugia cirugia = cirugiasProgramadas.pop();
			Paciente paciente = cirugia.getPaciente();
		    Medico cirujano = cirugia.getMedico();
		    System.out.println("\nPaciente: " + paciente.getNombre());
		    System.out.println("Cirujano: " + cirujano.getNombre());
			cirugiasRealizadas.addFirst(cirugia);
			reintegrarMedico(cirujano);
			contador++;
		}
		if (contador == quirofanosDisponibles) {
			System.out.println("\nSe ha alcanzado el máximo de cirugías simultáneas.");
		} else {
		    System.out.println("\nNo hay cirugías programadas.");
		}
	}
	
	public static void reintegrarMedico(Medico cirujano) {
		 if (cirujano == null) {
		        System.out.println("No se puede reintegrar un cirujano nulo.");
		        return;
		    }
		 
		 disponibles.add(cirujano);
	     System.out.println("El médico " + cirujano.getNombre() + " ha sido reintegrado al árbol.");
	    
	}
	
	public static Cirugia registrarCirugia(Medico cirujano, Paciente paciente) {
		Medico medico = cirujano;
		int anio = Helper.validarAñoActual(scanner, "Año: ");
		int mes = Helper.validarMes(scanner, "Mes: "); 
		int dia = Helper.validarDia(scanner, "Dia: ");
		Date fecha = new Date(anio, mes, dia);
		Cirugia cirugia = new Cirugia(medico, paciente, fecha);
		return cirugia;
	}
	
	// CONSULTAS
    public static void consultarMedicosDisponibles() {
    	if (disponibles.Height() == 0) {
    		System.out.println("\nNo hay Medicos Disponibles.");
    	}
    	else {
			disponibles.InOrder();
    	}
    }
    
    public static void consultarMedicamentos() {
    	if ( arregloMedicamentos==null ) {
    		System.out.println("\nNo hay Medicamentos Disponibles.");
    		return;
    	}
    	if (arregloMedicamentos.length == 0) {
    		System.out.println("\nNo hay Medicamentos Disponibles.");
    		return;
    	}
		int stockMaximo = Helper.validarEnteroNoNegativo(scanner, "Ingrese un stock: ");
		for (Medicamento medicamento : arregloMedicamentos) {
			if (medicamento.getStockDisponible() <= stockMaximo) {
				System.out.println(medicamento);
			}
        }
		return;
    }
    
    public static void consultarCirugiasRealizadas() {
    	if (cirugiasRealizadas.size() == 0) {
    		System.out.println("\nNo hay Cirugias Realizadas.");
    		return;
    	}
    	else {
    		for (Cirugia cirugia : cirugiasRealizadas) {
    			System.out.println(cirugia);
            }
        }
    }
    
    public static void consultarConsultasMedicasEfectuadas() {
    	if (consultasRealizadas.size() == 0) {
    		System.out.println("\nNo hay Consultas Medicas Efectuadas.");
    		return;
    	}
    	else {
    		for (ConsultaMedica consulta : consultasRealizadas) {
    			System.out.println(consulta);
    		}
        }
    }
    
    public static void consultarCantidadPacientesAtendidosPorFechas() {
    	if (consultasRealizadas.size() == 0 && cirugiasRealizadas.size() == 0) {
    		System.out.println("\nNo hay Pacientes Atendidos.");
    		return;
    	}

		int cantidad = 0;
		System.out.println("\nIngrese una Fecha Inicial");
		Date fechaInicio = Helper.ingresarFecha(scanner);
		System.out.println("\nIngrese una Fecha Final");
		Date fechaFin = Helper.ingresarFecha(scanner);
		for (ConsultaMedica consulta : consultasRealizadas) {
			if (!consulta.getFecha().before(fechaInicio) && !consulta.getFecha().after(fechaFin)) {
				cantidad++;
			}
		}
		for (Cirugia cirugia : cirugiasRealizadas) {
			if (!cirugia.getFecha().before(fechaInicio) && !cirugia.getFecha().after(fechaFin)) {
				cantidad++;
			}
		}
		System.out.println("\nCantidad de pacientes atendidos: " + cantidad);
    }
    
    public static void consultarCantidadPacientesOperadosPorEdad() {
    	if (cirugiasRealizadas.size() == 0) {
    		System.out.println("\nNo hay Pacientes Operados.");
    		return;
    	}
    	else {
    		int cantidad = 0;
    		int edadInicio = Helper.validarEdad(scanner, "\nIngrese una Edad Inicial");
    		int edadFin = Helper.validarEdad(scanner, "\nIngrese una Edad Final");
    		for (Cirugia cirugia : cirugiasRealizadas) {
    			int edad = cirugia.getPaciente().getEdad();
    			if (edad >= edadInicio && edad <= edadFin) {
    				cantidad++;
    			}
    		}
    		System.out.println("\nCantidad de pacientes operados con edad entre " + edadInicio + " y " + edadFin + ": " + cantidad);
    	}
    }
    
    public static void consultarCantidadPacientesConAntecedente() {
        int cantidad = 0;
       	if (consultasRealizadas.size() == 0) {
    		System.out.println("\nNo hay Pacientes con Antecedentes.");
    		return;
    	}
    	else {
    		System.out.println("\nIngrese un antecedente: ");
    		String antecedente = scanner.nextLine();
    		for (ConsultaMedica consulta : consultasRealizadas) {
    			if (consulta.getPaciente().getAntecedentes().contains(antecedente)) {
    				cantidad++;
    			}
    		}
        System.out.println("\nCantidad de pacientes atendidos en consulta con antecedente " + antecedente + ": " + cantidad);
    	}
    }
    
    public static void consultarMontoTotalMedicamentos() {
    	if ( arregloMedicamentos==null ) {
    		System.out.println("\nNo hay Medicamentos Disponibles.");
    		return;
    	}
    	if (arregloMedicamentos.length == 0) {
    		System.out.println("\nNo hay Medicamentos Disponibles.");
    		return;
    	}
        double montoTotal = 0;
    	for (Medicamento medicamento : arregloMedicamentos) {
    		montoTotal += medicamento.getPrecioUnitario() * medicamento.getStockDisponible();
    	}
    	System.out.println("\nMonto total de los medicamentos en stock: " + montoTotal);
    	
    }
    
    public static void pressKey() {
    	Scanner inputTecla=new Scanner(System.in);
    	System.out.println("\nPresione una tecla...");
    	String tecla= inputTecla.nextLine(); 
    }
}