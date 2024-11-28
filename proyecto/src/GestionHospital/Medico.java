package GestionHospital;

public class Medico implements Comparable<Medico>{
	private int matriculaProfesional; 
	private String nombre; 
	private String especialidad; 
	
	public Medico() {
		
	}

	public Medico(int matriculaProfesional) {
		this.matriculaProfesional = matriculaProfesional;
	}

	public Medico(int matriculaProfesional, String nombre) {
		this.matriculaProfesional = matriculaProfesional;
		this.nombre = nombre;
	}

	public Medico(int matriculaProfesional, String nombre, String especialidad) {
		this.matriculaProfesional = matriculaProfesional;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public int getMatriculaProfesional() {
		return matriculaProfesional;
	}

	public void setMatriculaProfesional(int matriculaProfesional) {
		this.matriculaProfesional = matriculaProfesional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Matricula profesional: " + matriculaProfesional + ", Nombre: " + nombre + ", Especialidad: " + especialidad;
	}
	
	public int compareTo(Medico medico) {
		return Integer.compare(this.matriculaProfesional, medico.matriculaProfesional);
	}
}