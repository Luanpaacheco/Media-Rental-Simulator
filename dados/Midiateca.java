package dados;

import java.util.ArrayList;

public class Midiateca implements Iterador {

	private int contador;

	private ArrayList<Midia> midias;

	public Midiateca() {
		midias=new ArrayList<>();
	}

	

	public ArrayList<Midia> getMidias() {
		return midias;
	}



	public boolean cadastraMidia(Midia jogo) {
		if(consultaPorCodigo(jogo.getCodigo())==null){
			midias.add(jogo);	
			return true;
		}
		else
			return false;
	}

	public Midia consultaPorCodigo(int codigo) {
		for(Midia a : midias){
			if (a.getCodigo()==codigo){
				return a;
			}
		}
		return null; 
		 
	}

	public ArrayList<Midia> consultaPorCategoria(Categoria categoria) {
		ArrayList<Midia>midiasCategoria=new ArrayList<>();
		for(Midia a : midias){
			if(a.getCategoria()==categoria){
				midiasCategoria.add(a);
			}
		}
		if(midiasCategoria.isEmpty()){
			return null;
		}else return midiasCategoria;
	}

	public boolean removeMidia(int codigo) {
		if(consultaPorCodigo(codigo)==null){
			return false;
		}else 
			midias.remove(consultaPorCodigo(codigo));
			return true;
			/*for(Midia a : midias){
				if(a.getCodigo()==codigo){
					midias.remove(a);
				}
			}
			return true;*/
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
