package Hospital;

import java.util.Scanner;
import GestionHospital.GestionGuardia;
import GestionHospital.Helper;

public class Consultas {
	
	static Scanner scanner = new Scanner(System.in);
	
    public static void consultas() {
    	while (true) {
			int opcion = menuConsultas();
			switch (opcion) {
			case 1:
				GestionGuardia.consultarMedicosDisponibles();
				break;
			case 2:
				GestionGuardia.consultarMedicamentos();
	            break;
			case 3:
				GestionGuardia.consultarCirugiasRealizadas();
				break;
			case 4:
				GestionGuardia.consultarConsultasMedicasEfectuadas();
				break;
			case 5:
				GestionGuardia.consultarCantidadPacientesAtendidosPorFechas();
				break;
			case 6:
				GestionGuardia.consultarCantidadPacientesOperadosPorEdad();
				break;
			case 7:
				GestionGuardia.consultarCantidadPacientesConAntecedente();
				break;
			case 8:
				GestionGuardia.consultarMontoTotalMedicamentos();
				break;
			case 9:
				System.out.println("Volviendo a menu de operaciones.");
				return;
			}
		}
	}
    
    public static int menuConsultas() {
    	System.out.println("\n--- Menu de Consultas ---");
   		System.out.println("1- Consulta de médicos disponibles.");
   		System.out.println("2- Consulta de medicamentos con stock igual o menor a uno dado.");
   		System.out.println("3- Consulta de cirugías realizadas.");
   		System.out.println("4- Consulta de consultas medicas efectuadas.");
   		System.out.println("5- Cantidad de pacientes atendidos.");
    	System.out.println("6- Cantidad de pacientes operados cuya edad está entre un valor inicial y final dados.");
   		System.out.println("7- Cantidad de pacientes atendidos en consulta que presentan un antecedente dado.");
   		System.out.println("8- Monto total al que ascienden los medicamentos que tiene el hospital en un momento dado.");
   		System.out.println("9- Volver a Menu Principal.");
		int opcion = Helper.validarOpcionConsulta(scanner, "Ingrese una opcion: ");
   		return opcion;
    }
}