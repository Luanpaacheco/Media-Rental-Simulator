package dados;

public class Musica extends Midia {

	private double duracao;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
			super(codigo, titulo, ano, categoria);
			this.duracao=duracao;
			
	}

	@Override
	public double calculaLocacao() {
		// TODO Auto-generated method stub
		return 5;
	}

}
