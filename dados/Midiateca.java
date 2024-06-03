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

	public void removes(Midia a){
		midias.remove(a);
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
			if(a.getCategoria().getNome().equals(categoria)){
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

	public ArrayList<Video> consultaPorQualidade(int qualidade) {
		ArrayList<Video>midiasQualidade=new ArrayList<>();
		for(Midia a : midias){
			if(a instanceof Video ){
				if(((Video)a).getQualidade()==qualidade){
					midiasQualidade.add((Video) a);
				}
			}
		}
		if(midiasQualidade.isEmpty())
			return null;
		else 
			return midiasQualidade;
	}

	

	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {
		contador = 0;
	}


	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		return contador<midias.size();
	}


	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {
		if (hasNext()) {
            Midia midiaElemento = midias.get(contador);
            contador++;
            return midiaElemento;
        }
        // Aqui você pode lançar uma exceção ou retornar null, dependendo do que deseja fazer
        return null;
    }


}
