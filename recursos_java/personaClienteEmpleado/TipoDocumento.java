package personaClienteEmpleado;



public enum TipoDocumento {
	
	LE("Libreta de enrolamiento"), 
	DNI("Documento Nacional de Identidad"),
	LC("Libreta Cívica"),
	P("Pasaporte");
	
	private String descripcion;
	
	private TipoDocumento(String descripcion){
		this.descripcion = descripcion;		
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	

}
