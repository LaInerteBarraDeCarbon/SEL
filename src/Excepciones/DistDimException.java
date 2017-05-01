package Excepciones;

/**
 * Excpeción relacionada al tema de dimensiones distintas de elementos. <br>
 */
public class DistDimException extends ArithmeticException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Muestra el mensaje de la expeción. <br>
	 * 
	 * @param mensaje
	 */
	public DistDimException(String mensaje) {
		super(mensaje);
	}
}
