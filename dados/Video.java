package dados;

public class Video extends Midia {

	private int qualidade;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano, categoria);
		this.qualidade=qualidade;
	}

	@Override
	public double calculaLocacao() {
		// TODO Auto-generated method stub
		return 5;
	}

	

}
