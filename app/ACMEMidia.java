package app;

import java.util.Scanner;

//import package dados;
import dados.Categoria;
import dados.Midia;
import dados.Midiateca;
import dados.Musica;
import dados.Video;

// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class ACMEMidia {

	private Midiateca midiateca;
	//private Scanner sc;
	 // Atributos para redirecionamento de E/S
	 private Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
	 private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
	 private final String nomeArquivoEntrada = "entrada.txt";  // Nome do arquivo de entrada de dados
	 private final String nomeArquivoSaida = "saida.txt";  // Nome do arquivo de saida de dados

	public ACMEMidia() {
		midiateca = new Midiateca();
		//sc = new Scanner(System.in);
		redirecionaES();
	}

	public void executa() {
		CadastraVideo();
		CadastraMusica();
		MostraDadosDeMidia();
		MostraDadosDeMidiaPorCategoria();
		MostraDadosDeVideoPorQualidade();
		MostraDadosDeMusicaPorDuracao();
		RemoverMidia();
		MostrarSomatorioDeLocacao();
	}

	public void CadastraVideo() {
		String titulo;
		int ano;
		Categoria cat;
		int qualidade;
		//System.out.println("digite codigo");
		int codigo = entrada.nextInt();

		while (codigo != -1) {

			entrada.nextLine();
			//System.out.println("digite titulo");
			titulo = entrada.nextLine();
			//System.out.println("digite o ano");
			ano = entrada.nextInt();
			entrada.nextLine();
			//System.out.println("digite a categoria");
			cat = Categoria.valueOf(entrada.nextLine());
			//System.out.println("digite qualidade");
			qualidade = entrada.nextInt();
			Video video = new Video(codigo, titulo, ano, cat, qualidade);
			if (midiateca.cadastraMidia(video)) {
				System.out.println("1:" + video.getCodigo() + "," + video.getTitulo() + "," + video.getAno() 
						 + "," + video.getCa() + "," + video.getQualidade());
			} else
				System.out.println("1: Erro-video com codigo repetido " + codigo);
			//System.out.println("digite codigo");
			codigo = entrada.nextInt();

		}

	}

	public void CadastraMusica() {
		String titulo;
		int ano;
		Categoria cat;
		double duracao;
		//System.out.println("digite codigo");
		int codigo = entrada.nextInt();

		while (codigo != -1) {

			entrada.nextLine();
			//System.out.println("digite titulo");
			titulo = entrada.nextLine();
			//System.out.println("digite o ano");
			ano = entrada.nextInt();
			entrada.nextLine();
			//System.out.println("digite a categoria");
			cat = Categoria.valueOf(entrada.nextLine());
			//System.out.println("digite duracao");
			duracao = entrada.nextDouble();
			Musica musica = new Musica(codigo, titulo, ano, cat, duracao);
			if (midiateca.cadastraMidia(musica)) {
				System.out.println("2:" + musica.getCodigo() + "," + musica.getTitulo() + "," + musica.getAno() +  "," + musica.getCa() + "," + musica.getDuracao());
			} else
				System.out.println("2: Erro-musica com codigo repetido " + codigo);
			//System.out.println("digite codigo");
			codigo = entrada.nextInt();

		}

	}

	public void MostraDadosDeMidia(){
		int codigo= entrada.nextInt();
		if(midiateca.consultaPorCodigo(codigo)==null){
			System.out.println("3:Codigo inexistente.");
		}else 
			for(Midia a : midiateca.getMidias()){
				if(a.getCodigo()==codigo){ 
					TestaObj(a,3);		
			}
		}

	}

	public void MostraDadosDeMidiaPorCategoria(){
		try{
			entrada.nextLine();
		Categoria cat= Categoria.valueOf(entrada.nextLine());
		if(midiateca.consultaPorCategoria(cat)==null){
			System.out.println("4:Codigo inexistente.");
		}else 
			for(Midia a : midiateca.getMidias()){
				if(a.getCategoria().equals(cat)){ 
					TestaObj(a,4);		
			}
		}
		}catch(Exception e ){
			System.out.println("4:Codigo inexistente.");
		}
		
	}

	public void MostraDadosDeVideoPorQualidade(){
		try{
			int qualidade= entrada.nextInt();;
		if(midiateca.consultaPorQualidade(qualidade)==null){
			System.out.println("5:Codigo inexistente.");
		}else 
			for(Video video : midiateca.consultaPorQualidade(qualidade) ){
				System.out.println("5:" + video.getCodigo() + "," + video.getTitulo() + "," + video.getAno() + ","
				 + video.getCa() + "," + video.getQualidade()+","+video.calculaLocacao());
			}
		}catch(Exception e){
			System.out.println("erro");
		}
		
		}

	public void MostraDadosDeMusicaPorDuracao(){
		try{
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
		}catch(Exception e){
			System.out.println("6:Nenhuma música encontrada.");
		}
		
	}

	public void RemoverMidia(){
		//System.out.println("digite um codigo");
		try{
			int codigo = entrada.nextInt();
			
			if(midiateca.consultaPorCodigo(codigo)!=null){
				TestaObj(midiateca.consultaPorCodigo(codigo), 7);
				midiateca.removeMidia(codigo);
				
			}else System.out.println("7:erro");
		}catch(Exception e){
			System.out.println("erro"+ e.getMessage()+" "+e.getLocalizedMessage());
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
		DecimalFormat deci=new DecimalFormat("0.00");
		if(x instanceof Video){
			Video video = (Video)x;
			System.out.println(n+":" + video.getCodigo() + "," + video.getTitulo() + "," + video.getAno() 
			+ "," + video.getCa() + "," + video.getQualidade()+","+deci.format(video.calculaLocacao()));
		}else  {
			Musica musica = (Musica) x;
			System.out.println(n+":" + musica.getCodigo() + "," + musica.getTitulo() + "," + musica.getAno()
			 + "," + musica.getCa() + "," + musica.getDuracao()+","+ deci.format(musica.calculaLocacao()));
		}
	}

// Redireciona E/S para arquivos
    // Chame este metodo para redirecionar a leitura e escrita de dados para arquivos
    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Restaura E/S padrao de tela(console)/teclado
    // Chame este metodo para retornar a leitura e escrita de dados para o padrao
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
	
	
}


