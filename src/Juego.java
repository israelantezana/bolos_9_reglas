

public class Juego {

	private Lanzamientos lanzamientos = new Lanzamientos();
	private int total;
	private int indexFrame;

	public void lanzar(int pinos) {
		lanzamientos.add(pinos);
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
		if (lanzamientos.esStrike(indexFrame)) { 
			total += 10 + lanzamientos.bonoStrike(indexFrame);
			indexFrame++;
			return;
		}
		if (lanzamientos.esSpare(indexFrame)) {
			total += 10 + lanzamientos.bonoSpare(indexFrame);
			indexFrame += 2;
			return;
		} 	
		total += lanzamientos.sumaDeDosLanzamientos(indexFrame);
		indexFrame += 2;
	}
}
