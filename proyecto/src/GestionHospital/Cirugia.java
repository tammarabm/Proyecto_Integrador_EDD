package GestionHospital;

import java.util.Date;

public class Cirugia {
	private Medico medico;
	private Paciente paciente;
	private Date fecha;
	
	public Cirugia(Medico medico, Paciente paciente, Date fecha) {
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha; 
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Medico Responsable: " + medico + ", Paciente: " + paciente + ", Fecha: " + fecha;
	}
	
}