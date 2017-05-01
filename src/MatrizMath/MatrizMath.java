package MatrizMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Excepciones.DistDimException;
import Excepciones.NoCuadradaException;
import VectorMath.VectorMath;


public class MatrizMath {

	private int filas;
	private int columnas;
	private double[][] matriz;

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
		this.matriz = new double[this.filas][this.columnas];
		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				this.matriz[i][j] = 0;
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

	/**
	 * Devuelve la cantidad de columnas. <br>
	 * 
	 * @return Cantidad de columnas. <br>
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Devuelve la matriz. <br>
	 * 
	 * @return Matriz. <br>
	 */
	public double[][] getMatriz() {
		return matriz;
	}

	/**
	 * Suma una matriz con otra. Si las matrices no son iguales, no la suma.
	 * <br>
	 * 
	 * @param mat
	 *            Matriz a sumar. <br>
	 * @throws DistDimException
	 */
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
	public MatrizMath productoMatrizMatriz(MatrizMath mat) throws DistDimException {
		if (this.columnas != mat.filas)
			throw new DistDimException("Distinta Dimension");

		MatrizMath resultado = new MatrizMath(this.filas, mat.columnas);

		for (int f = 0; f < this.filas; f++) {
			for (int c = 0; c < this.columnas; c++) {
				for (int fico = 0; fico < this.columnas; fico++) {
					resultado.matriz[f][c] += this.matriz[f][fico] * mat.matriz[f][c];
				}
			}
		}
		return resultado;
	}

	/**
	 * Multiplica una matriz por un vector. Si el vector posee distinta
	 * dimensión con respecto a la dimensión de la columna de la matriz, no la
	 * multiplica. <br>
	 * 
	 * @param vec
	 *            Vector a multiplicar. <br>
	 * @return Matriz resultado. <br>
	 * @throws DistDimException
	 */
	public VectorMath productoMatrizVector(VectorMath vec) throws DistDimException {
		if (this.columnas != vec.getDimension())
			throw new DistDimException("Distinta dimensión.");
		double auxiliar;
		VectorMath aux = new VectorMath(this.filas);
		for (int i = 0; i < this.filas; i++) {
			auxiliar = 0.0;
			for (int j = 0; j < this.columnas; j++) {
				auxiliar += this.matriz[i][j] * vec.getValor(j);
			}
			aux.setValor(i, auxiliar);
		}
		return aux;
	}

	/**
	 * Multiplica una matriz por un valor. <br>
	 * 
	 * @param valor
	 *            Valor a multiplicar. <br>
	 * @return Matriz resultado. <br>
	 */
	public MatrizMath productoMatrizFloat(double valor) {
		MatrizMath resultado = new MatrizMath(this.filas, this.columnas);

		for (int f = 0; f < this.filas; f++)
			for (int c = 0; c < this.columnas; c++)
				resultado.setValor(f, c, this.matriz[f][c] * valor);

		return resultado;
	}

	/**
	 * Realiza la norma uno de una matriz. <br>
	 * 
	 * @return Norma uno. <br>
	 */
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

	/**
	 * Calcula la norma dos de una matriz. <br>
	 * 
	 * @return Norma dos. <br>
	 */
	// norma frobenius
	public double NormaDos() {
		double resultado = 0.0;

		for (int f = 0; f < filas; f++)
			for (int c = 0; c < columnas; c++)
				resultado += Math.pow(matriz[f][c], 2.0);

		return Math.sqrt(resultado);
	}

	/**
	 * Calcula la norma infinito de una matriz. <br>
	 * 
	 * @return Norma infinito. <br>
	 */
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

	/**
	 * Genera la matriz inversa de una matriz. <br>
	 * 
	 * @param orden
	 *            Orden de la matriz. <br>
	 * 
	 * @return Matriz inversa. <br>
	 */
	public MatrizMath matrizInversa(int orden) {
		int i = 0, j = 0, k = 0;
		int matDim = this.columnas;
		double num;
		MatrizMath aux = new MatrizMath(this.filas, this.columnas, this.matriz);
		MatrizMath inversa = new MatrizMath(this.columnas);

		for (int s = 0; s < orden; s++) {
			inversa.matriz[s][s] = 1.0;
		}

		for (k = 0; k < matDim; k++) {
			if (aux.getValor(k, k) == 0) { // transforma los ceros de la
											// diagonal principal
				i = k;
				while (aux.getValor(i, k) == 0 && i < matDim - k) // busco en
																	// las
																	// otras
																	// filas
					i++;
				for (j = 0; j < matDim; j++) {
					aux.setValor(k, j, aux.getValor(k, j) + aux.getValor(i, j));
					inversa.setValor(k, j, inversa.getValor(k, j) + inversa.getValor(i, j));
				}
			}

			num = aux.getValor(k, k);

			for (j = 0; j < matDim; j++) { // divido la fila por el inverso del
											// diagonal para hacerlo 1
				aux.setValor(k, j, aux.getValor(k, j) * (1 / num));
				inversa.setValor(k, j, inversa.getValor(k, j) * (1 / num));
			}

			for (i = k + 1; i < matDim; i++) { // transformo en cero
				num = aux.getValor(i, k);
				for (j = 0; j < matDim; j++) {
					aux.setValor(i, j, aux.getValor(i, j) - num * aux.getValor(k, j));
					inversa.setValor(i, j, inversa.getValor(i, j) - num * inversa.getValor(k, j));
				}
			}
		} // ya se obtuvo la triangular inferior como la identidad

		for (k = 0; k < matDim - 1; k++) // ahora me encargo de la triangular
											// superior
			for (i = 1; i < matDim - k; i++) {
				num = aux.getValor(k, k + i);
				for (j = 0; j < matDim; j++) {
					aux.setValor(k, j, aux.getValor(k, j) - num * aux.getValor(k + i, j));
					inversa.setValor(k, j, inversa.getValor(k, j) - num * inversa.getValor(k + i, j));
				}
			}
		return inversa;
	}

	/**
	 * Muestra el contenido de la matriz. <br>
	 */
	public void mostarMatriz() {
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				System.out.println("Fila " + (i + 1) + "\tColumna " + (j + 1) + "\t" + this.matriz[i][j]);
			}
		}
	}

	/**
	 * Lee una matriz desde un archivo. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public void leerArchivoMatriz(String path) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(path));

			this.filas = sc.nextInt();
			this.columnas = sc.nextInt();

			this.matriz = new double[(int) this.filas][(int) this.columnas];

			for (int i = 0; i < this.filas; i++) {
				for (int j = 0; j < this.columnas; j++) {
					this.matriz[sc.nextInt()][sc.nextInt()] = sc.nextDouble();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		sc.close();
	}

	/**
	 * Calcula el deteriminante de una matriz. Si la matriz no es cuadrada no lo
	 * calcula. <br>
	 * 
	 * @return Determinante. <br>
	 * @throws NoCuadradaException
	 */
	public double determinante() throws NoCuadradaException {
		if (this.columnas != this.filas)

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
