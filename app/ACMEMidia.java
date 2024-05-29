package app;

import java.util.Scanner;

import dados.Categoria;
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
		//1//CadastraVideo();
		//2//CadastraMusica();
		MostraDadosDeMidia();
		// 4MostraDadosDeMidiaPorCategoria();
		// 5MostraDadosDeVideoPorQualidade();
		// 6MostraDadosDdeMusicPorDuracao();
		// 7RemoverMidia();
		// 8MostrarSomatorioDeLocacao();
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
						+ video.getAno() + ", " + video.getCa() + ", " + video.getQualidade());
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
						+ musica.getAno() + ", " + musica.getCa() + ", " + musica.getDuracao());
			} else
				System.out.println("2: Erro-musica com codigo repetido " + codigo);
			System.out.println("digite codigo");
			codigo = sc.nextInt();

		}

	}

	public void MostraDadosDeMidia(){
		
	}

}
