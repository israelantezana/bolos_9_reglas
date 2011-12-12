import java.util.ArrayList;
import java.util.List;


public class Lanzamientos {

	private List<Lanzamiento> lanzamientos = new ArrayList<Lanzamiento>();
	
	public void add(int pinos){
		lanzamientos.add(new Lanzamiento(pinos));
	}
	
	public Lanzamiento get(int indexFrame) {
		return lanzamientos.get(indexFrame);
	}
	
	public boolean esStrike(int indexFrame) {
		return lanzamientos.get(indexFrame).esStrike();
	}

	public int bonoStrike(int indexFrame) {
		return lanzamientos.get(indexFrame + 1).getPinosDerribados() + bonoSpare(indexFrame);
	}

	public boolean esSpare(int indexFrame) {
		return sumaDeDosLanzamientos(indexFrame).esStrike();
	}
	
	public int bonoSpare(int indexFrame) {
		return lanzamientos.get(indexFrame + 2).getPinosDerribados();
	}

	public Lanzamiento sumaDeDosLanzamientos(int indexFrame) {
		return lanzamientos.get(indexFrame).sumar(lanzamientos.get(indexFrame + 1));
	}

}
