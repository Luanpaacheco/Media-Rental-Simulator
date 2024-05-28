package dados;

import java.util.ArrayList;

public class Midiateca implements Iterador {

	private int contador;

	private Midia[] midia;

	public Midiateca() {

	}

	public boolean cadastraMidia(Midia jogo) {
		return false;
	}

	public Midia consultaPorCodigo(int codigo) {
		return null;
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {
		return null;
	}

	public boolean removeMidia(int codigo) {
		return false;
	}


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {

	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		return null;
	}

}
