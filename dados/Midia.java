package dados;

public abstract class Midia {

	private int codigo;

	private String titulo;

	private int ano;

	private Categoria ca;

	public Midia(int codigo, String titulo, int ano, Categoria categoria) {
		this.codigo = codigo;
		this.titulo=titulo;
		this.ano=ano;
		ca = categoria;
		
	}


	public abstract double calculaLocacao();


	public Categoria getCategoria(){
		return ca;
	}

	public int getCodigo() {
		return codigo;
	}



	public String getTitulo() {
		return titulo;
	}



	public int getAno() {
		return ano;
	}

}
