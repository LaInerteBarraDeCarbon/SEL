package sel;

import static org.junit.Assert.*;

import org.junit.Assert;

import org.junit.Test;

public class TestSEL {

	static String PathSELIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	static String PathSELOut = "Preparacion de Prueba/Lote de Prueba/Salida/";
	double errorGenerado = (double) 1 / 10;

	@Test
	public void pruebaSolucionCasoSimple() {
		SEL s1 = new SEL(PathSELIn + "01_caso2x2simple.in");
		s1.resolver();
		s1.grabarArchivo(PathSELOut + "01_caso2x2simple.out");
		assertTrue(s1.getError() <= this.errorGenerado);
	}

	@Test
	public void pruebaSolucionLevementePerturbado() {
		SEL s2 = new SEL(PathSELIn + "02_caso01_levementePeturbado.in");
		s2.resolver();
		s2.grabarArchivo(PathSELOut + "02_caso01_levementePeturbado.out");
		assertTrue(s2.getError() <= this.errorGenerado);
	}

	@Test
	public void pruebaSolucion4x4Normal() {
		SEL s3 = new SEL(PathSELIn + "03_4x4_Normal.in");
		s3.resolver();
		s3.grabarArchivo(PathSELOut + "03_4x4_Normal.out");
		Assert.assertTrue(s3.getError() <= this.errorGenerado);
	}

	@Test
	public void pruebaSolucionCasiLinealmenteDependiente() {
		SEL s4 = new SEL(PathSELIn + "04_caso2x2cCasiLDsimple.in");
		s4.resolver();
		s4.grabarArchivo(PathSELOut + "04_caso2x2cCasiLDsimple.out");
		assertTrue(s4.getError() <= this.errorGenerado);

	}
}
