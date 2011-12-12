
public class Lanzamiento {

	private final int pinosDerribados;

	public Lanzamiento(int pinos) {
		this.pinosDerribados = pinos;
	}

	public boolean esStrike() {
		return pinosDerribados == 10;
	}

	public int getPinosDerribados() {
		return pinosDerribados;
	}
	
	public Lanzamiento sumar(Lanzamiento lanzamiento) {
		return new Lanzamiento(pinosDerribados + lanzamiento.pinosDerribados);
	}

}
