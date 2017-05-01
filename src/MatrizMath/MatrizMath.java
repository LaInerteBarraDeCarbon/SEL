package MatrizMath;

import Excepciones.DistDimException;
import Excepciones.NoCuadradaException;

public class MatrizMath {

	private int filas;
	private int columnas;
	private double[][] matriz;

	public static void main(String[] args) {

		MatrizMath mat2 = new MatrizMath(3, 3);

		double[][] matrix = { { 1, 5, 3 }, { 4, 5, 5 }, { 2, 8, 12 } };
		MatrizMath mat1 = new MatrizMath(3, 3, matrix);

		System.out.println(mat1.toString());
		System.out.println(mat1.determinante());
	}

	/**
	 * Crea una matriz vacía. <br>
	 * 
	 * @param fil
	 *            Cantidad de filas. <br>
	 * @param col
	 *            Cantidad de columnas. <br>
	 */
	public MatrizMath(int fil, int col) {
		this.filas = fil;
		this.columnas = col;

		this.matriz = new double[fil][col];

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				matriz[i][j] = 0;
	}

	/**
	 * Crea una matriz vacía de orden n. <br>
	 * 
	 * @param orden
	 *            Orden de la matriz. <br>
	 */
	public MatrizMath(int orden) {
		this.filas = this.columnas = orden;
		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				matriz[i][j] = 0;
	}

	/**
	 * Crea una matriz a partir de otra matriz. <br>
	 * 
	 * @param fil
	 *            Cantidad de filas. <br>
	 * @param col
	 *            Cantidad de columnas. <br>
	 * @param mat
	 *            Matriz. <br>
	 */
	public MatrizMath(int fil, int col, double[][] mat) {
		this.filas = fil;
		this.columnas = col;

		this.matriz = new double[fil][col];

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				matriz[i][j] = mat[i][j];
	}

	/**
	 * Crea una matriz vacía, sin filas ni columnas. <br>
	 */
	public MatrizMath() {
		filas = 0;
		columnas = 0;
		matriz = null;
	}

	/**
	 * Guarda un valor en la posición dada. <br>
	 * 
	 * @param i
	 *            Posición fila. <br>
	 * @param j
	 *            Posición columna. <br>
	 * @param valor
	 *            Valor a guardar. <br>
	 */
	public void setValor(int i, int j, double valor) {
		matriz[i][j] = valor;
	}

	/**
	 * Devuelve el valor en la posición pedida. <br>
	 * 
	 * @param i
	 *            Posición fila. <br>
	 * @param j
	 *            Posición columna. <br>
	 * @return Valor. <br>
	 */
	public double getValor(int i, int j) {
		return matriz[i][j];
	}

	/**
	 * Devuelve la cantidad de filas. <br>
	 * 
	 * @return Cantidad de filas. <br>
	 */
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	/**
	 * Devuelve la cantidad de columnas. <br>
	 * 
	 * @return Cantidad de columnas. <br>
	 */
	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/**
	 * Devuelve la matriz. <br>
	 * 
	 * @return Matriz. <br>
	 */
	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	/**
	 * Indica si la matriz es cuadrada. <br>
	 * 
	 * @return true si es cuadrada, false de lo contrario. <br>
	 */
	public boolean EsCuadrada() {
		return this.filas == this.columnas;
	}

	/**
	 * Suma una matriz con otra. Si las matrices no son iguales, no la suma.
	 * <br>
	 * 
	 * @param mat
	 *            Matriz a sumar. <br>
	 * @throws DistDimException
	 */
	// Suma de una Matriz con otra Matriz de igual dimension.
	public void sumarMatriz(MatrizMath mat) throws DistDimException {
		if (this.filas != mat.filas || this.columnas != mat.columnas)
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				this.matriz[i][j] += mat.matriz[i][j];
	}

	/**
	 * Resta una matriz con otra. Si las matrices no son iguales, no la resta.
	 * <br>
	 * 
	 * @param mat
	 *            Matriz a restar. <br>
	 * @throws DistDimException
	 */
	// Resta de una matriz por otra de igual dimension.
	public void restarMatriz(MatrizMath mat) throws DistDimException {
		if (this.filas != mat.filas || this.columnas != mat.columnas)
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				this.matriz[i][j] -= mat.matriz[i][j];
	}

	/**
	 * Multiplica una matriz con otra. Si la cantidad de columnas de la primera
	 * matriz no es la misma que la de filas de la segunda, no las multiplica.
	 * <br>
	 * 
	 * @param mat
	 *            Matriz a multiplicar. <br>
	 * @return Matriz resultado. <br>
	 * @throws DistDimException
	 */
	// Producto de una matriz por otra de igual dimension.
	public MatrizMath productoMatrizMatriz(MatrizMath mat) throws DistDimException {
		if (this.filas != mat.filas || this.columnas != mat.columnas)
			throw new DistDimException("Distinta Dimension");

		MatrizMath resultado = new MatrizMath(this.filas, mat.columnas);

		for (int f = 0; f < this.filas; f++)
			for (int c = 0; c < this.columnas; c++)
				resultado.matriz[f][0] += matriz[f][c] * mat.matriz[c][0];

		return resultado;
	}

	// Producto de una Matriz por un Vector.

	// Producto de una matriz por un Float.
	public MatrizMath productoMatrizFloat(double valor) {
		MatrizMath resultado = new MatrizMath(this.filas, this.columnas);

		for (int f = 0; f < this.filas; f++)
			for (int c = 0; c < this.columnas; c++)
				resultado.setValor(f, c, this.matriz[f][c] * valor);

		return resultado;
	}

	// maxima suma entre columnas
	public double NormaUno() {
		double resultado = 0.0, aux = 0.0;

		for (int c = 0; c < columnas; c++) {
			for (int f = 0; f < filas; f++)
				aux += Math.abs(matriz[f][c]);

			if (aux > resultado)
				resultado = aux;

			aux = 0.0;
		}

		return resultado;
	}

	// norma frobenius
	public double NormaDos() {
		double resultado = 0.0;

		for (int f = 0; f < filas; f++)
			for (int c = 0; c < columnas; c++)
				resultado += Math.pow(matriz[f][c], 2.0);

		return Math.sqrt(resultado);
	}

	// maxima suma entre filas
	public double NormaInfinito() {
		double resultado = 0.0, aux = 0.0;

		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < this.columnas; c++)
				aux += Math.abs(this.matriz[f][c]);
			if (aux > resultado)
				resultado = aux;
			aux = 0.0;
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

		MatrizMath aux = (MatrizMath) obj;
		if (this.filas != aux.filas || this.columnas != aux.columnas)
			return false;

		for (int f = 0; f < filas; f++)
			for (int c = 0; c < columnas; c++)
				if (matriz[f][c] != aux.matriz[f][c])
					return false;

		return true;
	}

	@Override
	public String toString() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.printf("%.2f\t", matriz[i][j]);
			}
			System.out.println("");
		}
		return "";
	}

	@Override
	public MatrizMath clone() {
		return new MatrizMath(this.filas, this.columnas, this.matriz);
	}

	/**
	 * Transforma una matriz de orden n en una matriz identidad. <br>
	 * 
	 * @param orden
	 *            Orden de la matriz. <br>
	 */
	public void convertirIdentidad(int orden) {
		for (int i = 0; i < orden; i++) {
			this.matriz[i][i] = 1;
		}
	}

	/**
	 * Genera la matriz inversa de una matriz. <br>
	 * 
	 * @param orden
	 *            Orden de la matriz. <br>
	 */
	public void matrizInversa(int orden) {
		MatrizMath identidad = new MatrizMath();
		identidad.convertirIdentidad(orden);

		for (int i = 0; i < orden; i++) {
			for (int j = 0; j < orden; j++) {
				if (this.getValor(i, i) != 0) {
					identidad.matriz[i][j] /= this.matriz[i][i];
					this.matriz[i][j] /= matriz[i][i];
				} else {
					identidad.matriz[i][j] += 1;
					this.matriz[i][j] += 1;
				}
			}
			if (i < orden) {
				for (int k = i + 1; k < orden; k++) {
					for (int j = 0; j < orden; j++) {
						identidad.matriz[k][j] -= this.matriz[i + 1][i] * this.matriz[i][j];
						this.matriz[k][j] -= this.matriz[i + 1][i] * this.matriz[i][j];
					}
				}
			}
		}

		for (int i = orden - 1; i >= 1; i--) {
			for (int j = orden - 1; j >= 0; j++) {
				identidad.matriz[i - 1][j] -= this.matriz[i - 1][i] * this.matriz[i][j];
				this.matriz[i - 1][j] -= this.matriz[i - 1][i] * this.matriz[i][j];
			}
		}
		this.matriz = identidad.matriz;
	}

	public double determinante()throws NoCuadradaException {
		
		if(!this.EsCuadrada())
			throw new NoCuadradaException("La matriz no es cuadrada");
		double det;
		if (this.matriz.length == 2) {
			det = (this.matriz[0][0] * this.matriz[1][1]) - (this.matriz[1][0] * this.matriz[0][1]);
			return det;
		}
		double suma = 0;
		for (int i = 0; i < this.matriz.length; i++) {
			MatrizMath temp = new MatrizMath(this.matriz.length - 1, this.matriz.length - 1);
			for (int j = 0; j < this.matriz.length; j++) {
				if (j != i) {
					for (int k = 1; k < this.matriz.length; k++) {
						int indice = -1;
						if (j < i)
							indice = j;
						else if (j > i)
							indice = j - 1;
						temp.matriz[indice][k - 1] = this.matriz[j][k];
					}
				}
			}
			if (i % 2 == 0)
				suma += this.matriz[i][0] * temp.determinante();
			else
				suma -= this.matriz[i][0] * temp.determinante();
		}
		return suma;
	}

}
