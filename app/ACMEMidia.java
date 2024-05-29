package app;

import java.util.Scanner;

import dados.Categoria;
import dados.Midiateca;
import dados.Video;

public class ACMEMidia {

	private Midiateca midiateca;
	private Scanner sc;

	public ACMEMidia() {
		midiateca=new Midiateca();
		sc=new Scanner(System.in);
	}

	public void executa() {
		CadastraVideo();
		//2CadastraMusica();
		//3MostraDadosDeMidia();
		//4MostraDadosDeMidiaPorCategoria();
		//5MostraDadosDeVideoPorQualidade();
		//6MostraDadosDdeMusicPorDuracao();
		//7RemoverMidia();
		//8MostrarSomatorioDeLocacao();
	}

	public void CadastraVideo(){
		String titulo;
		int ano;
		Categoria cat;
		int qualidade;
		System.out.println("digite codigo");
		int codigo = sc.nextInt();

		while(codigo !=-1){ 
		
		sc.nextLine();
		System.out.println("digite titulo");
		 titulo=sc.nextLine();
		System.out.println("digite o ano");
		ano=sc.nextInt();
		sc.nextLine();
		System.out.println("digite a categoria");
		cat=Categoria.valueOf(sc.nextLine());
		System.out.println("digite qualidade");
		qualidade= sc.nextInt();
		Video video = new Video(codigo, titulo, ano, cat, qualidade);
		if(midiateca.cadastraMidia(video)){
			System.out.println("1:"+video.getCodigo()+", "+video.getTitulo()+", "+video.getAno()+", "+video.getAno()+", "+video.getCa()+", "+video.getQualidade());
		}else System.out.println("1: Erro-video com codigo repetido "+ codigo);
		System.out.println("digite codigo");
		codigo = sc.nextInt();
		
	}



	}

}
