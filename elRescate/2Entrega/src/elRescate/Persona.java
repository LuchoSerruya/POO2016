package elRescate;

public class Persona {
	private String nombre;
	private String apellido;
	
	
	/**
	 * Crea una persona con nombre y apellido
	 * @param nombre
	 * @param apellido
	 */
	public Persona(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	/**
	 * Crea persona con nombre "El", apellido "Rescatado"
	 */
	public Persona(){
		this("El", "Rescatado");
	}
	
	/**
	 * Devuelve apellido de una persona
	 * @return
	 */
	public String getApellido() {
		return this.apellido;
	}
	
	/**
	 * Devuelve nombre de una persona
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Setea apellido de una persona
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	/**
	 * Setea nombre de una persona
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
