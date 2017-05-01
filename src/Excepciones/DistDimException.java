package Excepciones;

/**
 * Excpeci�n relacionada al tema de dimensiones distintas de elementos. <br>
 */
public class DistDimException extends ArithmeticException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Muestra el mensaje de la expeci�n. <br>
	 * 
	 * @param mensaje
	 */
	public DistDimException(String mensaje) {
		super(mensaje);
	}
}
