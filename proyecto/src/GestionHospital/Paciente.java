/*La información que se registra para un paciente es: dni, nombre, edad, antecedentes (por ejemplo: hipertenso, diabético, etc.), diagnostico preliminar (1 o 2). */

package GestionHospital;

public class Paciente {
	private int dni;
	private String nombre;
	private int edad;
	private String antecedentes;
	private int diagnosticoPreliminar;
	
	public Paciente (int dni, String nombre, int edad, String antecedentes, int diagnosticoPreliminar) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.antecedentes = antecedentes;
		this.diagnosticoPreliminar = diagnosticoPreliminar;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public int getDiagnosticoPreliminar() {
		return diagnosticoPreliminar;
	}

	public void setDiagnosticoPreliminar(int diagnosticoPreliminar) {
		this.diagnosticoPreliminar = diagnosticoPreliminar;
	}

	@Override
	public String toString() {
		return "Paciente: " + nombre +  ", DNI: " + dni + ", Edad: " + edad + ", Antecedentes: " + antecedentes + ", Diagnostico Preliminar: " + diagnosticoPreliminar;
	}
}