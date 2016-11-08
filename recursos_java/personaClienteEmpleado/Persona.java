package personaClienteEmpleado;

/**
 * 
 * Clase para Persona.
 * Si es muy plaga el tema de la excepcion,
 * hacer que NroDocInvalidoException extienda de RuntimeException
 *
 */
public class Persona {
	
	private TipoDocumento tipo;
	private long numeroDocumento;
	private String nombre;
	private String direccion;

	public void setTipoDoc(TipoDocumento tipo){
		this.tipo = tipo;
	}
	
	public TipoDocumento getTipoDoc(){
		return this.tipo;
	}
	
	public void setNumeroDoc(long nro) throws NroDocInvalidoException{
		if(nro < 0)
			throw new NroDocInvalidoException();
		
		this.numeroDocumento = nro;
	}
	
	public long getNumeroDoc(){
		return this.numeroDocumento;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	/**
	 * Devuelve tipo y numero de documento, y nombre
	 */
	public String toString(){
		return String.format("%s: %d | %s", this.getTipoDoc().getDescripcion(), this.getNumeroDoc(), this.getNombre());
	}
	
	@Override
	/**
	 * Verifica si dos persona son iguales si tienen el mismo tipo de documento y mismo numero de documento
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Persona){
			Persona p = (Persona)obj;
			return ((p.getTipoDoc().getDescripcion() == this.getTipoDoc().getDescripcion()) && (p.getNumeroDoc() == this.getNumeroDoc()));
		}
		return super.equals(obj);
	}
	
	/**
	 * Crea una persona nueva
	 * @param nombre Nombre de la persona
	 * @param tipo Tipo del documento (DNI, LE, LC, Pasaporte)
	 * @param nro número del documento
	 * @param direccion dirección
	 */
	public Persona(String nombre, TipoDocumento tipo, long nro, String direccion) throws NroDocInvalidoException{
		this.setNombre(nombre);
		this.setTipoDoc(tipo);
		this.setNumeroDoc(nro);
		this.setDireccion(direccion);
	}
	
	/**
	 * Crea una persona con documento DNI
	 * @param nombre Nombre de la persona
	 * @param nro número del DNI
	 * @param direccion dirección
	 */
	public Persona(String nombre, long nro, String direccion) throws NroDocInvalidoException{
		this(nombre, TipoDocumento.DNI, nro, direccion);
	}
	
	/**
	 * Crea una persona con documento DNI y dirección sin especificar
	 * @param nombre Nombre de la persona
	 * @param nro del DNI
	 */
	public Persona(String nombre, long nro) throws NroDocInvalidoException{
		this(nombre, TipoDocumento.DNI, nro, "Sin especificar");
	}
	
}
