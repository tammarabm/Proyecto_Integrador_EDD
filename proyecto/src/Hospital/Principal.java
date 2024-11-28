/*La gestión de la guardia del hospital involucra las siguientes operaciones: 
 * Inicio de jornada laboral 
 * 
 * Registro de medicamentos: se debe indicar la cantidad de N medicamentos disponibles en el hospital y registrar sus datos. Cada código de medicamento debe ser único. Como se mencionó anteriormente, los medicamentos 
 * se guardan en un arreglo unidimensional.
 * 
 * Registro de médicos: se debe hacer, a pedido del operador, el registro de médicos del hospital que se encuentran disponibles para la atención de pacientes. Para ello, se guarda a los médicos en un árbol binario de búsqueda 
 * que debe estar ordenado por matricula profesional.  
 * 
 * Sugerencia: A fin de facilitar la asignación de médicos a la atención de pacientes, se sugiere que las matriculas profesionales se generen en forma aleatoria dentro de un rango de valores especifico.  
 * 
 * Recepción de pacientes 
 * 
 * Consiste en registrar los datos de un paciente que llega a la guardia del hospital. De acuerdo al diagnostico preliminar, se derivará al paciente a una de las colas de espera. El diagnostico preliminar es la valoración que 
 * hace el personal de salud sobre el estado de la persona al llegar. A los fines del proyecto integrador, se simulará esa valoración haciendo una asignación aleatoria del valor 1 o 2 para ese dato del paciente. El valor 1 
 * indica que se requiere una atención con prioridad alta, por lo cual, el paciente deberá esperar para su atención en la cola prioridadAlta. El valor 2 indica que se requiere una atención con prioridad media, por lo tanto, 
 * el paciente debe esperar en la cola prioridadMedia.  
 * 
 * Atención de pacientes 
 * 
 * Para la atención de pacientes se debe proceder a retirarlos de las colas de espera. El hospital cuenta con un consultorio provisto con lo necesario para la revisión de pacientes así como con tres quirófanos preparados para 
 * su uso.
 * 
 * Atención de la cola prioridadMedia: se retira un paciente a la vez y se hace la consulta médica. Esto implica, generar una consulta con la información indicada anteriormente y guardarla en la lista de consultas realizadas. 
 * 
 * Atención de la cola prioridadAlta: se retiran hasta tres pacientes a la vez y se programan las cirugías correspondientes. Esto implica, generar una cirugía para cada paciente con la información indicada anteriormente y 
 * guardarlas en la pila de cirugías programadas. */

package Hospital;

import java.util.Scanner;
import GestionHospital.Helper;
import GestionHospital.Medicamento;
import GestionHospital.GestionGuardia;

public class Principal {
	
	public static Scanner scanner = new Scanner(System.in);	
	public static void main(String[] args) {
		while (true) {
			int opcion = menu();
			switch (opcion) {
			case 1:
	        	GestionGuardia.crearArregloMedicamentos();
	        	GestionGuardia.pressKey();
				break;
			case 2:
                int cantidadMedicos=Helper.validarEnteroNoNegativo(scanner, "Ingrese la cantidad de medicos disponibles: ");
                for (int i = 0; i < cantidadMedicos; i++) {
                    GestionGuardia.registrarMedico();
                }
                GestionGuardia.pressKey();
                break;
			case 3:
				GestionGuardia.registrarPaciente();
				GestionGuardia.pressKey();
				break;
			case 4:
				GestionGuardia.atenderPrioridadMedia();
				break;
			case 5:
				GestionGuardia.atenderPrioridadAlta();
				break;
			case 6:
				Consultas.consultas();
				break;
			case 7:
				System.out.println("Saliendo del programa...");
				return;
			}
		}
	}
	
	public static int menu() {
	    System.out.println("\n--- Menú de Operaciones ---");
		System.out.println("1- Registrar Medicamento");
		System.out.println("2- Registrar Medico");
		System.out.println("3- Registrar Paciente");
		System.out.println("4- Atender Pacientes de Prioridad Media");
		System.out.println("5- Atender Pacientes de Prioridad Alta");
		System.out.println("6- Realizar Consultas");
		System.out.println("7- Salir");
		int opcion = Helper.validarOpcionMenu(scanner, "Ingrese una opcion: ");
		return opcion;
	}
}