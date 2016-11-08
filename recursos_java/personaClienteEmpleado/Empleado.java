package personaClienteEmpleado;

public class Empleado extends Persona{
	
	private int codigoLegajo = 0;
	private int legajo;
	
	private void generarLegajo(){
		this.codigoLegajo++;
		this.legajo = codigoLegajo;
	}
	
	public int getLegajo() {
		return legajo;
	}
	
	public int getCodigoLegajo() {
		return codigoLegajo;
	}
	
	@Override
	/**
	 * Devuelve el legajo y nombre de un empleado
	 */
	public String toString() {
		return String.format("%d | %s", this.getLegajo(), this.getNombre());
	}
	
	@Override
	/**
	 * Verifica si dos empleados son iguales por su numero de legajo
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Empleado){
			Empleado e = (Empleado)obj;
			return e.getLegajo() == this.getLegajo();
		}
		return super.equals(obj);
	}
	
	/**
	 * Crea un empleado
	 * @param nombre Nombre del empleado
	 * @param tipo tipo del documento
	 * @param nro número del documento
	 * @param direccion dirección del empleado
	 */
	public Empleado(String nombre, TipoDocumento tipo, long nro, String direccion) throws NroDocInvalidoException{
		super(nombre, tipo, nro, direccion);
		this.generarLegajo();
	}
	
	/**
	 * Crea un empleado con documento DNI
	 * @param nombre Nombre del empleado
	 * @param nro número del documento
	 * @param direccion dirección del empleado
	 */
	public Empleado(String nombre, long nro, String direccion) throws NroDocInvalidoException{
		this(nombre, TipoDocumento.DNI, nro, direccion);
	}
	
	
	/**
	 * Crea un empleado con documento DNI y dirección sin especificar
	 * @param nombre Nombre del empleado
	 * @param nro número del documento
	 */
	public Empleado(String nombre, long nro) throws NroDocInvalidoException{
		this(nombre, TipoDocumento.DNI, nro, "Sin especificar");
	}

}
