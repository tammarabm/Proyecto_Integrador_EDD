import java.time.LocalDate;

public class ConsultaMedica {
	private Medico medicoACargo; 
	private Paciente paciente; 
	private Medicamento medicacionAdministrada;
	private int cantidadAplicada; 
	private LocalDate fecha; 
	
	public ConsultaMedica() {
		
	}

	public ConsultaMedica(Medico medicoACargo) {
		this.medicoACargo = medicoACargo;
	}

	public ConsultaMedica(Medico medicoACargo, Paciente paciente) {
		this.medicoACargo = medicoACargo;
		this.paciente = paciente;
	}

	public ConsultaMedica(Medico medicoACargo, Paciente paciente, Medicamento medicacionAdministrada) {
		this.medicoACargo = medicoACargo;
		this.paciente = paciente;
		this.medicacionAdministrada = medicacionAdministrada;
	}

	public ConsultaMedica(Medico medicoACargo, Paciente paciente, Medicamento medicacionAdministrada,
			int cantidadAplicada) {
		this.medicoACargo = medicoACargo;
		this.paciente = paciente;
		this.medicacionAdministrada = medicacionAdministrada;
		this.cantidadAplicada = cantidadAplicada;
	}

	public ConsultaMedica(Medico medicoACargo, Paciente paciente, Medicamento medicacionAdministrada,
			int cantidadAplicada, LocalDate fecha) {
		this.medicoACargo = medicoACargo;
		this.paciente = paciente;
		this.medicacionAdministrada = medicacionAdministrada;
		this.cantidadAplicada = cantidadAplicada;
		this.fecha = fecha;
	}

	public Medico getMedicoACargo() {
		return medicoACargo;
	}

	public void setMedicoACargo(Medico medicoACargo) {
		this.medicoACargo = medicoACargo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicamento getMedicacionAdministrada() {
		return medicacionAdministrada;
	}

	public void setMedicacionAdministrada(Medicamento medicacionAdministrada) {
		this.medicacionAdministrada = medicacionAdministrada;
	}

	public int getCantidadAplicada() {
		return cantidadAplicada;
	}

	public void setCantidadAplicada(int cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ConsultaMedica [medicoACargo=" + medicoACargo + ", paciente=" + paciente + ", medicacionAdministrada="
				+ medicacionAdministrada + ", cantidadAplicada=" + cantidadAplicada + ", fecha=" + fecha + "]";
	}
	
}
