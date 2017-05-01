package VectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Excepciones.DistDimException;

public class VectorMath {

	Integer dimension;
	private int[] valores = new int[1000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * VectorMath vector1 = new VectorMath(5); VectorMath vector2 = new
		 * VectorMath(5);
		 * 
		 * vector1.seteaOrdenado(); vector2.seteaOrdenado();
		 * 
		 * vector1.sumaVectorVector(vector2);
		 * 
		 * vector1.imprimeVector();
		 */

	}

	/**
	 * Carga un vector a partir de un archivo. <br>
	 * 
	 * @param ruta
	 *            Dirección del archivo. <br>
	 */
	public VectorMath(String ruta) {
		Scanner sc;
		try {
			sc = new Scanner(new File(ruta));
			this.dimension = sc.nextInt();
			for (int i = 0; i < this.dimension; i++)
				this.valores[i] = sc.nextInt();

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga un vector con una dimensión dada. <br>
	 * 
	 * @param dim
	 *            Dimensión del vector. <br>
	 */
	public VectorMath(int dim) {
		this.dimension = dim;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = 0;
	}

	/**
	 * Carga un vector con la dimensión y valores de otro vector. <br>
	 * 
	 * @param vector
	 *            Vector a cargar. <br>
	 */
	public VectorMath(VectorMath vector) {
		this.dimension = vector.dimension;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = vector.valores[i];
	}

	public void seteaOrdenado() {
		for (int i = 0; i <= this.dimension; i++)
			this.valores[i] = i + 1;
	}

	/**
	 * Muestra los valores del vector. <br>
	 */
	public void imprimeVector() {
		for (int i = 0; i < this.dimension; i++)
			System.out.println(this.valores[i]);
	}

	/**
	 * Realiza la suma entre vectores. Si poseen dimensión diferente, no lo
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
	 * Realiza la resta entre vectores. Si poseen dimensión diferente, no lo
	 * resta. <br>
	 * 
	 * @param vector
	 *            Vector a restar. <br>
	 * @throws DistDimException
	 */
	public void restaVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			this.valores[i] -= vector.valores[i];
	}

	/**
	 * Realiza el producto entre vectores. Si poseen dimensión diferente, no los
	 * multiplica. <br>
	 * 
	 * @param vector
	 *            Vector a multiplicar. <br>
	 * @return Resultado multiplicación. <br>
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
	 * @return Norma del vector. <br>
	 */
	public int normaVector() {
		int suma = 0;
		for (int i = 0; i < this.dimension; i++) {
			suma += Math.pow(this.valores[i], 2);
		}
		return (int) Math.sqrt(suma);
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
}
