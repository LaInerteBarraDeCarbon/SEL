package sel;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestRendimiento {

	static String PathSELIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	static String PathSELOut = "Preparacion de Prueba/Lote de Prueba/Salida/";

	@Test
	public void pruebaCinco() {
		SEL s1 = new SEL(PathSELIn + "05_caso5x5simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "05_caso5x5simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 5x5: " + diff);
	}

	@Test
	public void pruebaDiez() {
		SEL s1 = new SEL(PathSELIn + "06_caso10x10simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "06_caso10x10simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 10x10: " + diff);
	}

	@Test
	public void pruebaVeinte() {
		SEL s1 = new SEL(PathSELIn + "07_caso20x20simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "07_caso20x20simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 20x20: " + diff);
	}

	@Test
	public void pruebaCincuenta() {
		SEL s1 = new SEL(PathSELIn + "08_caso50x50simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "08_caso50x50simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 50x50: " + diff);
	}

	@Test
	public void pruebaCien() {
		SEL s1 = new SEL(PathSELIn + "09_caso100x100simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "09_caso100x100simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 100x100: " + diff);
	}

	@Test
	public void pruebaDoscientos() {
		SEL s1 = new SEL(PathSELIn + "10_caso200x200simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "10_caso200x200simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 200x200: " + diff);
	}

	@Test
	public void pruebaDosCientosCincuenta() {
		SEL s1 = new SEL(PathSELIn + "11_caso250x250simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "11_caso250x250simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 250x250: " + diff);
	}

	@Test
	public void pruebaQuinientos() {
		SEL s1 = new SEL(PathSELIn + "12_caso500x500simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "12_caso500x500simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 500x500: " + diff);
	}

	@Test
	public void pruebaMil() {
		SEL s1 = new SEL(PathSELIn + "13_caso1000x1000simple.in");
		Calendar tIni = new GregorianCalendar();
		s1.resolver();
		// s1.grabarArchivo(PathSELOut + "13_caso1000x1000simple.out");
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Caso 1000x1000: " + diff);
	}
}
