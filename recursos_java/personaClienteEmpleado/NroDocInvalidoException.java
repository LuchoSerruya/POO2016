package personaClienteEmpleado;

public class NroDocInvalidoException extends Exception{
	
	@Override
	public String getMessage() {
		return "Se ingresó un número de documento inválido";
	}

}
