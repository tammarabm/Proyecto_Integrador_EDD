import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		GestionGuardia gestionGuardia = new GestionGuardia();

	while (true) {
	    System.out.println("\n--- Menú de Operaciones ---");
	    System.out.println("1. Registrar Medicamento");
	    System.out.println("2. Registrar Médico");
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
	
	        
	    }
	  }
	}
}
