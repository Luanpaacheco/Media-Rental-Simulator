package app;

import java.util.Scanner;

//import package dados;
import dados.Categoria;
import dados.Midia;
import dados.Midiateca;
import dados.Musica;
import dados.Video;

public class ACMEMidia {

	private Midiateca midiateca;
	private Scanner sc;

	public ACMEMidia() {
		midiateca = new Midiateca();
		sc = new Scanner(System.in);
	}

	public void executa() {
		CadastraVideo();
		CadastraMusica();
		MostraDadosDeMidia();
		//MostraDadosDeMidiaPorCategoria();
		//MostraDadosDeVideoPorQualidade();
		//MostraDadosDeMusicaPorDuracao();
		//RemoverMidia();
		MostrarSomatorioDeLocacao();
	}

	public void CadastraVideo() {
		String titulo;
		int ano;
		Categoria cat;
		int qualidade;
		System.out.println("digite codigo");
		int codigo = sc.nextInt();

		while (codigo != -1) {

			sc.nextLine();
			System.out.println("digite titulo");
			titulo = sc.nextLine();
			System.out.println("digite o ano");
			ano = sc.nextInt();
			sc.nextLine();
			System.out.println("digite a categoria");
			cat = Categoria.valueOf(sc.nextLine());
			System.out.println("digite qualidade");
			qualidade = sc.nextInt();
			Video video = new Video(codigo, titulo, ano, cat, qualidade);
			if (midiateca.cadastraMidia(video)) {
				System.out.println("1:" + video.getCodigo() + ", " + video.getTitulo() + ", " + video.getAno() + ", "
						 + ", " + video.getCa() + ", " + video.getQualidade());
			} else
				System.out.println("1: Erro-video com codigo repetido " + codigo);
			System.out.println("digite codigo");
			codigo = sc.nextInt();

		}

	}

	public void CadastraMusica() {
		String titulo;
		int ano;
		Categoria cat;
		double duracao;
		System.out.println("digite codigo");
		int codigo = sc.nextInt();

		while (codigo != -1) {

			sc.nextLine();
			System.out.println("digite titulo");
			titulo = sc.nextLine();
			System.out.println("digite o ano");
			ano = sc.nextInt();
			sc.nextLine();
			System.out.println("digite a categoria");
			cat = Categoria.valueOf(sc.nextLine());
			System.out.println("digite duracao");
			duracao = sc.nextDouble();
			Musica musica = new Musica(codigo, titulo, ano, cat, duracao);
			if (midiateca.cadastraMidia(musica)) {
				System.out.println("2:" + musica.getCodigo() + ", " + musica.getTitulo() + ", " + musica.getAno() + ", "
						 + ", " + musica.getCa() + ", " + musica.getDuracao());
			} else
				System.out.println("2: Erro-musica com codigo repetido " + codigo);
			System.out.println("digite codigo");
			codigo = sc.nextInt();

		}

	}

	public void MostraDadosDeMidia(){
		int codigo= sc.nextInt();
		if(midiateca.consultaPorCodigo(codigo)==null){
			System.out.println("3:Codigo inexistente.");
		}else 
			for(Midia a : midiateca.getMidias()){
				if(a.getCodigo()==codigo){ 
					TestaObj(a,4);		
			}
		}

	}

	public void MostraDadosDeMidiaPorCategoria(){
		Categoria cat= Categoria.valueOf(sc.nextLine());;
		if(midiateca.consultaPorCategoria(cat)==null){
			System.out.println("4:Codigo inexistente.");
		}else 
			for(Midia a : midiateca.getMidias()){
				if(a.getCategoria()==cat){ 
					TestaObj(a,4);		
			}
		}
	}

	public void MostraDadosDeVideoPorQualidade(){
		int qualidade= sc.nextInt();;
		if(midiateca.consultaPorQualidade(qualidade)==null){
			System.out.println("5:Codigo inexistente.");
		}else 
			for(Video video : midiateca.consultaPorQualidade(qualidade) ){
				System.out.println("5:" + video.getCodigo() + ", " + video.getTitulo() + ", " + video.getAno() + ", "
				+ video.getAno() + ", " + video.getCa() + ", " + video.getQualidade()+", "+video.calculaLocacao());
			}
		}

	public void MostraDadosDeMusicaPorDuracao(){
		Musica maior=null;
		if(!(midiateca.getMidias().isEmpty())){ 
			for(Midia a : midiateca.getMidias()){
				if(a instanceof Musica){
					if(maior==null||((Musica)a).getDuracao()>maior.getDuracao()){
						maior=(Musica)a;
					}
				}
			}
			System.out.println("6:" + maior.getTitulo()+","+maior.getDuracao());
		}else 
			System.out.println("6:Nenhuma música encontrada.");
	}

	public void RemoverMidia(){
		System.out.println("digite um codigo");
		int codigo = sc.nextInt();
		if(midiateca.consultaPorCodigo(codigo)==null){
			System.out.println("7:Codigo inexistente");
		}else {
			for(Midia a : midiateca.getMidias()){
				if(a.equals(midiateca.consultaPorCodigo(codigo))){
					TestaObj(a, 7);
					midiateca.remove(a);
				}
			}
		}
	}

	public void MostrarSomatorioDeLocacao(){
		double soma=0;
		if(midiateca.getMidias().isEmpty()){
			System.out.println("8:Nenhum midia encontrada.");
		}else {
			for(Midia a : midiateca.getMidias()){
				if(a instanceof Video){
					soma += ((Video)a).calculaLocacao();
				}else{
					soma += ((Musica)a).calculaLocacao();
				}
			}

			System.out.println("8:"+soma);
		}
	}

	public void TestaObj(Midia x,int n){
		if(x instanceof Video){
			Video video = (Video)x;
			System.out.println(n+":" + video.getCodigo() + "," + video.getTitulo() + "," + video.getAno() + ","
			+ ", " + video.getCa() + "," + video.getQualidade()+","+video.calculaLocacao());
		}else  {
			Musica musica = (Musica) x;
			System.out.println(n+":" + musica.getCodigo() + "," + musica.getTitulo() + "," + musica.getAno() + ","
			 + ", " + musica.getCa() + "," + musica.getDuracao()+","+ musica.calculaLocacao());
		}
	}
	
}


