package MatrizMath;

import java.util.Arrays;

import Excepciones.DistDimException;
import VectorMath.VectorMath;

public class MatrizMath {

	private Integer dimension;
	private int[][] valores;

	public static void main(String[] args) {

		MatrizMath mat1 = new MatrizMath(3);
		MatrizMath mat2 = new MatrizMath(3);

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		mat1.valores = matrix;

		int k = 1;
		for (int i = 0; i < mat1.dimension; i++) {
			for (int j = 0; j < mat1.dimension; j++) {
				mat1.valores[i][j] = k;
				mat2.valores[i][j] = k;
				k++;
			}
		}

		mat1.productoMatrizMatriz(mat2);
	}

	public MatrizMath(int dim) {
		this.dimension = dim;
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++) {
				this.valores[i][j] = 0;
			}
	}

	public MatrizMath(MatrizMath mat) {
		this.dimension = mat.dimension;
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				this.valores[i][j] = mat.valores[i][j];
			}
		}
	}

	public void sumarMatriz(MatrizMath mat) throws DistDimException {
		if (!this.dimension.equals(mat.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			for (int j = 0; j < this.dimension; j++)
				this.valores[i][j] += mat.valores[i][j];
	}

	public void restarMatriz(MatrizMath mat) throws DistDimException {
		if (!this.dimension.equals(mat.dimension))
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.dimension; i++)
			for (int j = 0; j < this.dimension; j++)
				this.valores[i][j] -= mat.valores[i][j];
	}

	public MatrizMath productoMatrizMatriz(MatrizMath mat) throws DistDimException {
		if (!this.dimension.equals(mat.dimension))
			throw new DistDimException("Distinta Dimension");

		int suma = 0;
		MatrizMath resultado = new MatrizMath(this.dimension);
		for (int h = 0; h < this.dimension; h++) {
			for (int i = 0; i < this.dimension; i++) {
				int k = 0;
				for (int j = 0; j < mat.dimension; j++) {
					suma += this.valores[k][j] * mat.valores[j][k];
					k++;
				}
				resultado.valores[h][this.dimension - (this.dimension - i)] = suma;
			}

		}
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizMath other = (MatrizMath) obj;
		if (dimension != other.dimension)
			return false;
		if (!Arrays.deepEquals(valores, other.valores))
			return false;
		return true;
	}

}
