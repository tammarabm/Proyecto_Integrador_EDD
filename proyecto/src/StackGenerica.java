
public class StackGenerica<ELEMENT> {
	private final static Integer defaultDimension=10; 
	private ELEMENT [] datos;
	private Integer cuenta; 
	
	public StackGenerica() {
		this(StackGenerica.defaultDimension);
	}
	
	public StackGenerica(Integer dimension) {
		if (dimension <= 0) {
            throw new IllegalArgumentException("El tamaño máximo debe ser mayor que 0");
        }
		this.datos=(ELEMENT []) new Object[dimension];
		this.cuenta=0;
	}
	public void push (ELEMENT elemento) {
		if (this.isFull()) {
			throw new RuntimeException("La pila está llena");
		}
		this.datos[this.cuenta]=elemento; 
		++this.cuenta;
	}
	public ELEMENT pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("La pila está vacía");
		}
		--this.cuenta; 
		return this.datos[this.cuenta]; 
	}
	public ELEMENT peek() {
		if(this.isEmpty()) {
			throw new RuntimeException("La pila está vacía");
		}
		return this.datos[this.cuenta-1];
	}
	public boolean isEmpty() {
		return this.cuenta<=0; 		
	}
	public boolean isFull() {
		return this.cuenta>=this.datos.length;
	}
	public int size () { //o count()
		return this.cuenta;
	}
	
	public int search(Object object) {
        for (int pos = this.cuenta - 1; pos >= 0; --pos) {
            if (this.datos[pos].equals(object)) {
                return this.cuenta - pos;
            }
        }
        return -1;
    }
	
	@Override
    public String toString() {
 
        if (this.size() <=0) {
            return "";
        }
 
        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.datos[0].toString());
        for (int i = 1; i < this.size(); ++i) {
            sb.append(", " + this.datos[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
