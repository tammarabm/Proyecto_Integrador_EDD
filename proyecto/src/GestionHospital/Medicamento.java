package GestionHospital;

public class Medicamento {
	private int codigo; 
	private String descripcion; 
	private double precioUnitario; 
	private int stockDisponible; 
	
	public Medicamento() {
		
	}
	
	public Medicamento(int codigo) {
		this.codigo = codigo;
	}

	public Medicamento(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Medicamento(int codigo, String descripcion, double precioUnitario) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public Medicamento(int codigo, String descripcion, double precioUnitario, int stockDisponible) {
		this.codigo=codigo; 
		this.descripcion=descripcion; 
		this.precioUnitario=precioUnitario; 
		this.stockDisponible=stockDisponible; 
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStockDisponible() {
		return stockDisponible;
	}

	public void setStockDisponible(int stockDisponible) {
		this.stockDisponible = stockDisponible;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Descripcion: " + descripcion + ", Precio Unitario: " + precioUnitario + ", Stock: " + stockDisponible;
	}	
}