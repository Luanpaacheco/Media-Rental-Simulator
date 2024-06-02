package dados;

public class Musica extends Midia {

	private double duracao;
	private Categoria ca;

	public Musica(int codigo, String titulo, int ano, Categoria categoria, double duracao) {
			super(codigo, titulo, ano, categoria);
			this.duracao=duracao;
			ca=categoria;
			
	}

	@Override
	public double calculaLocacao() {
		if(ca.equals(Categoria.ACA)){
			return (duracao*0.9);
		}else if (ca.equals(Categoria.DRA)){
			return duracao*0.7;
		}else if (ca.equals(Categoria.FIC)){
			return duracao*0.5;
		}else return duracao*0.3;
	}

	public double getDuracao() {
		return duracao;
	}

	public String getCa() {
		return ca.getNome();
	}

	

}
