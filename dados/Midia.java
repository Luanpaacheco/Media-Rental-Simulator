package dados;

public abstract class Midia {

	private int codigo;

	private String titulo;

	private int ano;

	public Midia(int codigo, String titulo, int ano, Categoria categoria) {

	}

	public abstract double calculaLocacao();

}
