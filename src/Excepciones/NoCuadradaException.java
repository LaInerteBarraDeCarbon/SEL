package Excepciones;

/**
 * Excpeción relacionada al tema de distintos ordenes de una matriz. <br>
 */
public class NoCuadradaException extends ArithmeticException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Muestra el mensaje de error. <br>
	 * 
	 * @param mensaje
	 */
	public NoCuadradaException(String mensaje) {

		super(mensaje);
	}

}
