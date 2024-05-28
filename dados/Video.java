package dados;

public class Video extends Midia {

	private int qualidade;
	private Categoria ca;

	public Video(int codigo, String titulo, int ano, Categoria categoria, int qualidade) {
		super(codigo, titulo, ano, categoria);
		this.qualidade=qualidade;
		ca=categoria;
	}

	@Override
	public double calculaLocacao() {
		if(super.getAno()==2024){
			return 20;
		}else if (super.getAno()>=2000||super.getAno()<=2023){
			return 15;
		}else return 10;
	}

	

}
