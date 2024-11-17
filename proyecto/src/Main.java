import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GestionGuardia gestionGuardia = new GestionGuardia();

	while (true) {
	    System.out.println("--- Menú de Operaciones ---");
	    System.out.println("1. Registrar Medicamento");
	    System.out.println("2. Registrar Médico");
	    System.out.println("3. Recepcion  de Pacientes");
	    System.out.println("4. Prioridad Alta");
	    System.out.println("9. Salir");
	
	    System.out.print("Seleccione una opción: ");
	    int opcion = input.nextInt();
	
	    switch (opcion) {
	        case 1:
	        	System.out.print("Ingrese la cantidad de medicamentos que puede registrar el hospital: ");
	            int capacidad = input.nextInt();
	            
	        	for (int i = 1; i <= capacidad; i++) {
		            System.out.print("Ingrese el código del medicamento: ");
		            int codigo = input.nextInt();
		            input.nextLine();
		            System.out.print("Ingrese la descripción del medicamento: ");
		            String descripcion = input.nextLine();
		            System.out.print("Ingrese el precio unitario: ");
		            double precio = input.nextDouble();
		            System.out.print("Ingrese el stock disponible: ");
		            int stock = input.nextInt();
		            input.nextLine();
		            Medicamento medicamento= new Medicamento(codigo, descripcion, precio, stock);
		            gestionGuardia.registrarMedicamento(medicamento);
	        	}
	            break;
	        case 2: 
	        	System.out.println("Ingrese la cantidad de medicos disponibles: ");
	        	int cantidadMedicos=input.nextInt();
	        	input.nextLine();
	        	for (int i = 1; i <= cantidadMedicos; i++) {
		        	System.out.println("Matricula profesional generada");
		        	int matricula=generarMatriculaAleatoria();
		        	System.out.println(matricula);
		        	System.out.println("Nombre: ");
		        	String nombre = input.nextLine(); 
		        	System.out.println("Especialidad: ");
		        	String especialidad =input.nextLine();	    
		        	Medico medico= new Medico(matricula, nombre, especialidad);
		        	gestionGuardia.registrarMedico(medico);
	        	}
	        	break;
	        case 3: 
	        	Random random= new Random();
	        	System.out.println("Datos del Paciente: ");
	        	System.out.println("Dni: ");
	        	int dni=input.nextInt(); 
	        	input.nextLine();
	        	System.out.println("Nombre: ");
	        	String nombre= input.nextLine(); 
	        	System.out.println("Edad: ");
	        	int edad = input.nextInt();
	        	input.nextLine(); 
	        	System.out.println("Antecedente: ");
	        	String antecedentes = input.nextLine();
	        	int diagnostico= 1+random.nextInt(2);
	        	System.out.println("Diagnostico: "+diagnostico);
	        	Paciente paciente= new Paciente (dni, nombre, edad, antecedentes, diagnostico);
	        	gestionGuardia.recibirPaciente(paciente);
	        	break;
	        case 4: 
	        	gestionGuardia.atenderPrioridadAlta();
	        	break;
	    } 	
	    		
	  }
	}
	public static int generarMatriculaAleatoria() {
		Random random = new Random();
        return 10000 + random.nextInt(90000);
    }
}
