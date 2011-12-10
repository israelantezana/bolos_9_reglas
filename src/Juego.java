
public class Juego {

	private int lanzamientos[] = new int[21];
	private int lanzamientoActual = 0;
	private int total;
	private int indexFrame;

	public void lanzar(int pinos) {
		lanzamientos[lanzamientoActual] = pinos;
		lanzamientoActual++;		
	}

	public int puntaje() {
		total = 0;
		indexFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			calcularPuntajeParaFrame();
		}
		return total;
	}

	private void calcularPuntajeParaFrame() {
		if (esStrike(indexFrame)) { 
			total += 10 + bonoStrike(indexFrame);
			indexFrame++;
			return;
		}
		if (esSpare(indexFrame)) {
			total += 10 + bonoSpare(indexFrame);
			indexFrame += 2;
			return;
		} 	
		total += sumaDeDosLanzamientos(indexFrame);
		indexFrame += 2;
	}
	
	private boolean esStrike(int indexFrame) {
		return lanzamientos[indexFrame] == 10;
	}

	private int bonoStrike(int indexFrame) {
		return lanzamientos[indexFrame + 1] + bonoSpare(indexFrame);
	}

	private boolean esSpare(int indexFrame) {
		return sumaDeDosLanzamientos(indexFrame) == 10;
	}
	
	private int bonoSpare(int indexFrame) {
		return lanzamientos[indexFrame + 2];
	}

	private int sumaDeDosLanzamientos(int indexFrame) {
		return lanzamientos[indexFrame] + lanzamientos[indexFrame + 1];
	}
}
