package dados;

public enum Categoria {

	ACA("Acao"),

	DRA("Drama"),

	FIC("Ficcao"),

	ROM("Romance");

	private String nome;

	private Categoria(String nome) {
		this.nome=nome;
	}

	public String getNome() {
		return nome;
	}

}
