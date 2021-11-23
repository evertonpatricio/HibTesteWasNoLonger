package util.diversos;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

public class TesteThread extends Thread {

	public void run() {
		
		while (true) {
			try {
				System.out.println("Teste thread executado em: " + retornarDataString(new Date()));
				Thread.sleep(3000L); //3000L = 3 segundos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*
		while (true) {
			try {
				// executa funcao;
				System.out.println("Teste thread executado em: " + retornarDataString(new Date()));
			} catch (Exception ex) {
				System.out.println(ex);
			} finally {
				try {
					this.sleep(30000);
				} catch (InterruptedException ex) {
					System.out.println(ex);
				}
			}
		}
		*/
		
		/* Implementação no TesteControl
		
			@PostConstruct
			public void iniciarThreadTeste() {
				System.out.println("Iniciando a thread de testes");
				
				TesteThread testeThread = new TesteThread();
				testeThread.start();
			}
		
		*/
	}
	
	public String retornarDataString(Date data) {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
		return dataFormatada;
	}
	
}
