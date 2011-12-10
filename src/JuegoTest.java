import static org.junit.Assert.*;
import org.junit.Test;

public class JuegoTest {
	Juego juego = new Juego();
	
	@Test
	public void todosLosLanzamientosAlCanal() throws Exception {
		lanzarVarios(20, 0);
		assertEquals(0, juego.puntaje());
	}
	
	@Test
	public void todosLosLanzamientosDerribanUnPino() throws Exception {
		lanzarVarios(20, 1);
		assertEquals(20, juego.puntaje());
	}
	
	@Test
	public void variosLanzamientosConUnSpare() throws Exception {
		lanzarSpare();
		juego.lanzar(2);
		lanzarVarios(17, 0);
		assertEquals(14, juego.puntaje());
	}

	@Test
	public void variosLanzamientosConUnStrike() throws Exception {
		lanzarStrike();
		juego.lanzar(3);
		juego.lanzar(4);
		lanzarVarios(17, 0);
		assertEquals(24, juego.puntaje());
	}

	private void lanzarStrike() {
		juego.lanzar(10);
	}
	
	@Test
	public void juegoPerfecto() throws Exception {
		lanzarVarios(12, 10);
		assertEquals(300, juego.puntaje());
	}

	private void lanzarVarios(int n, int pinos) {
		for (int i = 0; i < n; i++)
			juego.lanzar(pinos);
	}
	
	private void lanzarSpare() {
		juego.lanzar(7);
		juego.lanzar(3);
	}
}
