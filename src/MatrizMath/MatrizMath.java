package MatrizMath;

import java.util.Arrays;

import Excepciones.DistDimException;
import VectorMath.VectorMath;

public class MatrizMath {

	private int filas;
	private int columnas;
	private double[][] matriz;

	public static void main(String[] args) {

		MatrizMath mat1 = new MatrizMath(3, 3);
		MatrizMath mat2 = new MatrizMath(3, 3);

		double[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		mat1.matriz = matrix;

		int k = 1;
		for (int i = 0; i < mat1.filas; i++) {
			for (int j = 0; j < mat1.columnas; j++) {
				mat1.matriz[i][j] = k;
				mat2.matriz[i][j] = k;
				k++;
			}
		}

		mat1.productoMatrizMatriz(mat2);
		
	}

	public MatrizMath(int fil, int col) {
		this.filas = fil;
		this.columnas = col;

		this.matriz = new double[fil][col];

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				matriz[i][j] = 0;
	}

	public MatrizMath(int fil, int col, double[][] mat) {
		this.filas = fil;
		this.columnas = col;

		this.matriz = new double[fil][col];

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				matriz[i][j] = mat[i][j];
	}

	public MatrizMath() {
		filas = 0;
		columnas = 0;
		matriz = null;
	}

	public void setValor(int i, int j, double valor)
	{
		matriz[i][j]=valor;
	}
	
	public double getValor(int i, int j)
	{
		return matriz[i][j];
	}
	
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}
	
	public boolean EsCuadrada() {
		return this.filas == this.columnas;
	}

	// Suma de una Matriz con otra Matriz de igual dimension.
	public void sumarMatriz(MatrizMath mat) throws DistDimException {
		if (this.filas != mat.filas || this.columnas != mat.columnas)
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				this.matriz[i][j] += mat.matriz[i][j];
	}
	
	// Resta de una matriz por otra de igual dimension.
	public void restarMatriz(MatrizMath mat) throws DistDimException {
		if (this.filas != mat.filas || this.columnas != mat.columnas)
			throw new DistDimException("Distinta Dimension");

		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				this.matriz[i][j] -= mat.matriz[i][j];
	}

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
		
		for(int f=0; f<this.filas; f++)
			for(int c=0; c<this.columnas; c++)
				resultado.setValor(f, c, this.matriz[f][c] * valor);
		
		return resultado;
	}
	
	//maxima suma entre columnas
		public double NormaUno(){
			double resultado = 0.0, aux = 0.0;
			
			for(int c=0; c<columnas; c++){
				for(int f=0; f<filas; f++)
					aux += Math.abs(matriz[f][c]);
				
				if(aux > resultado)
					resultado = aux;
				
				aux = 0.0;
			}
			
			return resultado;
		}
		
		//norma frobenius
		public double NormaDos(){
			double resultado = 0.0;
			
			for(int f=0; f<filas; f++)
				for(int c=0; c<columnas; c++)
					resultado += Math.pow(matriz[f][c], 2.0);
			
			return Math.sqrt(resultado);
		}
		
		//maxima suma entre filas
		public double NormaInfinito(){
			double resultado = 0.0, aux = 0.0;
			
			for(int f=0; f<this.filas; f++){
				for(int c=0; c<this.columnas; c++)
					aux += Math.abs(this.matriz[f][c]);
				if(aux > resultado)
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
		
		MatrizMath aux = (MatrizMath)obj;
		if(this.filas != aux.filas || this.columnas != aux.columnas) 
			return false;
		
		for(int f=0; f<filas; f++)
			for(int c=0; c<columnas; c++)
				if(matriz[f][c] != aux.matriz[f][c])	
					return false;
		
		return true;
	}

}
