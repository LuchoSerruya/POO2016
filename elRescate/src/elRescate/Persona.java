package elRescate;

public class Persona {
	private String nombre;
	private String apellido;
	
	public Persona(String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Persona(){
		this("El", "Rescatado");
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
