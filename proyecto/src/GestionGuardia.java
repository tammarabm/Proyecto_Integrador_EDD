import java.time.LocalDate;

public class GestionGuardia {
	Medicamento[] medicamentos;
	Queue<Paciente> prioridadMedia;
	Queue<Paciente> prioridadAlta;
	StackGenerica<Cirugia> cirugiasProgramadas;
	BinarySearchTree<Medico> medicosDisponibles;
	SimpleLinkedList<ConsultaMedica> consultasRealizadas;
	SimpleLinkedList<Cirugia> cirugiasRealizadas;
	//DoubleLinkedList<ConsultaMedica> consultasRealizadas;
	//DoubleLinkedList<Cirugia> cirugiasRealizadas;
	private int cantidadMedicamentos;

	public GestionGuardia() {
	    this.medicosDisponibles = new BinarySearchTree<>();
	    this.prioridadAlta = new Queue<>();
	    this.prioridadMedia = new Queue<>();
	    this.cirugiasProgramadas = new StackGenerica<>();
	    this.consultasRealizadas= new SimpleLinkedList<>();
	    this.cirugiasRealizadas = new SimpleLinkedList<>();   
	}
	public GestionGuardia(int cantidadMedicamento) {
		this.medicamentos = new Medicamento[cantidadMedicamento];
	    this.medicosDisponibles = new BinarySearchTree<>();
	    this.prioridadAlta = new Queue<>();
	    this.prioridadMedia = new Queue<>();
	    this.cirugiasProgramadas = new StackGenerica<>();
	    this.consultasRealizadas= new SimpleLinkedList<>();
	    this.cirugiasRealizadas = new SimpleLinkedList<>();
	    this.cantidadMedicamentos=cantidadMedicamento;
	}

	
	public void registrarMedicamento(Medicamento medicamento) {
		
		if (cantidadMedicamentos<medicamentos.length) {
			medicamentos[cantidadMedicamentos]=medicamento;
			cantidadMedicamentos++;
			System.out.println("Medicamento registrado");
		}else {
			System.out.println("No se pueden registrar más medicamentos");
		}
		for (int i =0; i<medicamentos.length;i++) {
			if(medicamentos[i].getCodigo()==medicamento.getCodigo()) {
				System.out.println("Este medicamento ya existe");	
			}
		}
	}


	public void registrarMedico(Medico medico) {
	    medicosDisponibles.add(medico);  
	}

	public void recibirPaciente(Paciente paciente) {
		if(paciente.getDiagnosticoPreliminar()==1) {
			System.out.println("Prioridad Alta");
			this.prioridadAlta.add(paciente);	
		} else if (paciente.getDiagnosticoPreliminar()==2) {
			System.out.println("Prioridad Media");
			this.prioridadMedia.add(paciente);
		}
	}
	
	public void atenderPrioridadAlta() {
		int maximoPacientes=3;
		if(prioridadAlta.isEmpty()) {
			System.out.println("No hay pacientes en la cola de prioridad alta...");
			return; 
		}
		while (!prioridadAlta.isEmpty() && maximoPacientes>0) {
			Paciente paciente= prioridadAlta.poll();
			Medico cirujano= medicosDisponibles.buscar();
			Cirugia cirugia =new Cirugia(cirujano, paciente, LocalDate.now());
			cirugiasProgramadas.push(cirugia);
			System.out.println("Cirugia programada para el paciente: " + paciente.getNombre());
		}
	}
	
	
	/**public void atenderPrioridadMedia() {
		if (prioridadMedia.isEmpty()) {
            System.out.println("No hay pacientes en la cola de prioridad media.");
            return;
        }
        while (!prioridadMedia.isEmpty()) {
            Paciente paciente = prioridadMedia.poll(); 
            Medico medico = medicosDisponibles.buscarMedico("Clínico");  
            if (medico != null) {
                Medicamento medicamento = medicamentos[0];  
                ConsultaMedica consulta = new ConsultaMedica(medico, paciente, medicamento, 1, LocalDate.now());
                consultasRealizadas.addLast(consulta);
                System.out.println("Consulta realizada para el paciente: " + paciente.getNombre());
            } else {
                System.out.println("No hay médicos clínicos disponibles.");
            }
        }
    }*/
	
	
}
