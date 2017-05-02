package sel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class SEL {

	private MatrizMath matriz;
	private VectorMath vector;
	private VectorMath resultado;
	private double error;
	private boolean inversible;

	/**
	 * Crea un Sistema de Ecuaciones Lineales a resolver por medio de un
	 * archivo. Lee del archivo y carga la matriz de orden n y el vector. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public SEL(String path) {
		try {
			this.leerArchivo(path);
		} catch (IOException e) {
			System.out.println("Error abrir archivo.");
			e.printStackTrace();
		}
	}

	/**
	 * Lee del archivo y carga la matriz de orden n y el vector. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @throws IOException
	 */
	private void leerArchivo(String path) throws IOException {
		String linea;
		FileReader fr;
		BufferedReader bfInput = null;
		int dim = 0, pos = 0;
		try {
			fr = new FileReader(new File(path));
			bfInput = new BufferedReader(fr);
			linea = bfInput.readLine();
			if (linea != null) {
				dim = Integer.parseInt(linea);
				this.matriz = new MatrizMath(dim, dim);
				this.vector = new VectorMath(dim);
				linea = bfInput.readLine();
			}
			while (linea != null && pos < (dim * dim)) {
				String[] datos = linea.split(" ");
				this.matriz.setValor(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]),
						Double.parseDouble(datos[2]));
				pos++;
				linea = bfInput.readLine();
			}
			for (int i = 0; i < dim; i++) {
				this.vector.setValor(i, Double.parseDouble(linea));
				linea = bfInput.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			bfInput.close();
		}
	}

	/**
	 * Graba el archivo con el resultado. <br>
	 * 
	 * @param path
	 *            Dirección del archivo a guardar. <br>
	 */
	public void grabarArchivo(String path) {
		FileWriter fw;
		PrintWriter archivoSalida = null;
		DecimalFormat formateador = new DecimalFormat("#.#");

		try {
			fw = new FileWriter(new File(path));
			archivoSalida = new PrintWriter(fw);
			if (this.inversible == true) {
				archivoSalida.println((long) this.vector.getDimension());
				for (int i = 0; i < this.vector.getDimension(); i++) {
					archivoSalida.println(formateador.format(this.resultado.getValor(i)));
				}
				archivoSalida.print(System.lineSeparator());
				archivoSalida.println(this.error);
			} else
				archivoSalida.print("El sistema es Compatible Indeterminado o Incompatible");

		} catch (IOException e) {
			e.printStackTrace();
		}
		archivoSalida.close();
	}

	/**
	 * Resuelve el sistema de ecuaciones lineales. <br>
	 */
	public void resolver() {
		MatrizMath aux = new MatrizMath(this.matriz.getFilas(), this.matriz.getColumnas());
		if (this.matriz.determinante() == 0.0) {
			this.inversible = false;
		} else {
			aux = matriz.matrizInversa();
			this.inversible = true;
			this.resultado = aux.productoMatrizVector(this.vector);
			VectorMath resultadoPrima = new VectorMath(resultado.getDimension(), resultado.getValores());
			for (int i = 0; i < this.resultado.getDimension(); i++) {
				this.resultado.setValor(i, Math.rint(this.resultado.getValor(i)));
			}
			calcularErrorSolucion(resultadoPrima);
		}
	}

	/**
	 * Calcula el error. <br>
	 * 
	 * @param resultadoPrima
	 *            Vector. <br>
	 */
	public void calcularErrorSolucion(VectorMath resultadoPrima) {
		VectorMath aux = this.resultado.clone();
		aux.restaVectorVector(resultadoPrima);
		this.error = aux.norma();
	}

	/**
	 * Muestra los resultados. <br>
	 */
	public void mostrarResultado() {
		if (this.inversible == false) {
			System.out.println("El sistema es Compatible Indeterminado o Incompatible");
		} else {
			DecimalFormat formateador = new DecimalFormat("#.#");
			System.out.println((long) this.vector.getDimension());
			System.out.println();
			for (int i = 0; i < this.resultado.getDimension(); i++)
				System.out.println(formateador.format(this.resultado.getValor(i)));
			System.out.println();
			System.out.println(this.error);
		}
	}

	/**
	 * Devuelve la cota de error. <br>
	 * 
	 * @return Cota de error. <br>
	 */
	public double getError() {
		return this.error;
	}
}
