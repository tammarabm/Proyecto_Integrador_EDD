package GestionHospital;

import java.util.Date;

public class ConsultaMedica {
	private Medico medico_a_cargo;
	private Paciente paciente;
	private Medicamento medicacionAdministrada;
	private int cantidadAplicada;
	private Date fecha;
	
	public ConsultaMedica(Medico medico_a_cargo, Paciente paciente, Medicamento medicacionAdministrada, int cantidadAplicada, Date fecha) {
		this.medico_a_cargo = medico_a_cargo;
		this.paciente = paciente;
		this.medicacionAdministrada = medicacionAdministrada;
		this.cantidadAplicada = cantidadAplicada;
		this.fecha = fecha;
	}

	public Medico getMedico_a_cargo() {
		return medico_a_cargo;
	}

	public void setMedico_a_cargo(Medico medico_a_cargo) {
		this.medico_a_cargo = medico_a_cargo;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Medico a cargo: " + medico_a_cargo + ", Paciente: " + paciente + ", Medicacion administrada: " + medicacionAdministrada + ", Cantidad aplicada: " + cantidadAplicada + ", Fecha: " + fecha;
	}
}