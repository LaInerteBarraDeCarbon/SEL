package VectorMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Excepciones.DistDimException;

public class VectorMath {

	private int[] valores;
	Integer dimension;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	public VectorMath() {
		this.dimension = 0;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = 0;
	}

	public VectorMath(VectorMath vector) {
		this.dimension = vector.dimension;
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] = vector.valores[i];
	}

	public void sumaVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			this.valores[i] += vector.valores[i];
	}

	public void restaVectorVector(VectorMath vector) throws DistDimException {
		if (!this.dimension.equals(vector.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			this.valores[i] -= vector.valores[i];
	}

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

	public void productoVectorEscalar(int valor) {
		for (int i = 0; i < this.dimension; i++)
			this.valores[i] *= valor;
	}

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

	public VectorMath clone() {
		VectorMath vector = new VectorMath(this);
		return vector;
	}

}
