import java.time.LocalDate;

public class Cirugia {
	private Medico medicoResponsable; 
	private Paciente paciente; 
	private LocalDate fecha;
	
	
	public Cirugia() {
		
	}
	public Cirugia(Medico medicoResponsable) {
		this.medicoResponsable = medicoResponsable;
	}
	
	public Cirugia(Medico medicoResponsable, Paciente paciente) {
		this.medicoResponsable = medicoResponsable;
		this.paciente = paciente;
	}
	
	public Cirugia(Medico medicoResponsable, Paciente paciente, LocalDate fecha) {
		this.medicoResponsable = medicoResponsable;
		this.paciente = paciente;
		this.fecha = fecha;
	}
	public Medico getMedicoResponsable() {
		return medicoResponsable;
	}
	public void setMedicoResponsable(Medico medicoResponsable) {
		this.medicoResponsable = medicoResponsable;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Cirugia [medicoResponsable=" + medicoResponsable + ", paciente=" + paciente + ", fecha=" + fecha + "]";
	}
}
