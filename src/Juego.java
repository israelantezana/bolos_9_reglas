
public class Juego {

	private int lanzamientos[] = new int[21];
	private int lanzamientoActual = 0;

	public void lanzar(int pinos) {
		lanzamientos[lanzamientoActual] = pinos;
		lanzamientoActual++;		
	}

	public int puntaje() {
		int total = 0;
		int indexFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (esStrike(indexFrame)) { 
				total += 10 + bonoStrike(indexFrame);
				indexFrame++;
			}
			else {
				if (esSpare(indexFrame)) {
					total += 10 + bonoSpare(indexFrame);
				} else
					total += sumaDeDosLanzamientos(indexFrame);
				indexFrame += 2;
			}
		}
		return total;
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
