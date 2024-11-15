
public class Paciente {
	private int dni;
	private String nombre; 
	private int edad; 
	private String antecedentes; 
	private int diagnosticoPreliminar;
	
	public Paciente() {
		
	}
	
	public Paciente(int dni) {
		this.dni = dni;
	}

	public Paciente(int dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}
	
	public Paciente(int dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Paciente(int dni, String nombre, int edad, String antecedentes) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.antecedentes = antecedentes;
	}

	public Paciente(int dni, String nombre, int edad, String antecedentes, int diagnosticoPreliminar) {
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
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", antecedentes=" + antecedentes
				+ ", diagnosticoPreliminar=" + diagnosticoPreliminar + "]";
	}
}