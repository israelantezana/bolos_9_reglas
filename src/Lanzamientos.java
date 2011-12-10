import java.util.ArrayList;
import java.util.List;


public class Lanzamientos {

	private List<Integer> lanzamientos = new ArrayList<Integer>();
	
	public void add(int pinos){
		lanzamientos.add(pinos);
	}
	
	public boolean esStrike(int indexFrame) {
		return lanzamientos.get(indexFrame) == 10;
	}

	public int bonoStrike(int indexFrame) {
		return lanzamientos.get(indexFrame + 1) + bonoSpare(indexFrame);
	}

	public boolean esSpare(int indexFrame) {
		return sumaDeDosLanzamientos(indexFrame) == 10;
	}
	
	public int bonoSpare(int indexFrame) {
		return lanzamientos.get(indexFrame + 2);
	}

	public int sumaDeDosLanzamientos(int indexFrame) {
		return lanzamientos.get(indexFrame) + lanzamientos.get(indexFrame + 1);
	}

}
