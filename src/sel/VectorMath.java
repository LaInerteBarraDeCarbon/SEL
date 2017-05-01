package sel;

import Excepciones.DistDimException;

public class VectorMath {

	Integer dimension;
	private double[] valores = new double[1000];

	/**
	 * Carga un vector con una dimensi�n dada. <br>
	 * 
	 * @param dim
	 *            Dimensi�n del vector. <br>
	 */
	public VectorMath(int dim) {
		this.dimension = dim;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = 0;
	}

	/**
	 * Carga un vector con la dimensi�n y valores de otro vector. <br>
	 * 
	 * @param vector
	 *            Vector a cargar. <br>
	 */
	public VectorMath(VectorMath vector) {
		this.dimension = vector.dimension;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = vector.valores[i];
	}

	/**
	 * Carga un vector con su dimensi�n y valores. <br>
	 * 
	 * @param dimension
	 *            Dimensi�n del vector. <br>
	 * @param valores
	 *            Valores del vector. <br>
	 */
	public VectorMath(Integer dimension, double[] valores) {
		this.dimension = dimension;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = valores[i];
	}

	/**
	 * Muestra los valores del vector. <br>
	 */
	public void imprimeVector() {
		for (int i = 0; i < this.dimension; i++)
			System.out.println(this.valores[i]);
	}

	/**
	 * Realiza la suma entre vectores. Si poseen dimensi�n diferente, no lo
	 * suma. <br>
	 * 
	 * @param vector
	 *            Vector a sumar. <br>
	 * @throws DistDimException
	 */
	public void sumaVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			this.valores[i] += vector.valores[i];
	}

	/**
	 * Realiza la resta entre vectores. Si poseen dimensi�n diferente, no lo
	 * resta. <br>
	 * 
	 * @param vector
	 *            Vector a restar. <br>
	 * @return
	 * @throws DistDimException
	 */
	public void restaVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] -= vector.valores[i];
	}

	/**
	 * Realiza el producto entre vectores. Si poseen dimensi�n diferente, no los
	 * multiplica. <br>
	 * 
	 * @param vector
	 *            Vector a multiplicar. <br>
	 * @return Resultado multiplicaci�n. <br>
	 * @throws DistDimException
	 */
	public int productoVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");

		int resultado = 0;
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < vector.dimension; j++) {
				resultado += this.valores[i] * vector.valores[j];
			}
		}
		return resultado;
	}

	/**
	 * Multiplica el vector por un escalar. <br>
	 * 
	 * @param valor
	 *            Valor a multiplicar. <br>
	 */
	public void productoVectorEscalar(int valor) {
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] *= valor;
	}

	/**
	 * Realiza la norma de un vector. <br>
	 * 
	 * @return Norma de un vector. <br>
	 */
	public double norma() {
		double suma = 0;
		for (int i = 0; i < this.dimension; i++) {
			suma += Math.pow(this.valores[i], 2);
		}
		return Math.sqrt(suma);
	}

	public boolean equals(VectorMath vector) {
		if (!this.dimension.equals(vector.dimension))
			return false;
		for (int i = 0; i < this.dimension; i++)
			if (this.valores[i] != vector.valores[i])
				return false;
		return true;
	}

	/**
	 * Clona un vector. <br>
	 */
	public VectorMath clone() {
		VectorMath vector = new VectorMath(this);
		return vector;
	}

	/**
	 * Devuelve la dimensi�n del vector. <br>
	 * 
	 * @return Dimensi�n. <br>
	 */
	public Integer getDimension() {
		return dimension;
	}

	/**
	 * Devuelve el valor de una posici�n. <br>
	 * 
	 * @param posicion
	 *            Posicion del valor. <br>
	 * @return Valor. <br>
	 */
	public double getValor(int posicion) {
		return this.valores[posicion];
	}

	/**
	 * Guarda un valor en una posici�n. <br>
	 * 
	 * @param posicion
	 *            Posici�n a guardar. <br>
	 * @param valor
	 *            Valor a guardar. <br>
	 */
	public void setValor(int posicion, double valor) {
		this.valores[posicion] = valor;
	}

	/**
	 * Devuelve el vector. <br>
	 * 
	 * @return Vector. <br>
	 */
	public double[] getValores() {
		return valores;
	}
}
