package pong.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.PrintWriter;



public class Serveur {
	
	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;
		
		try {
		
			socketserver = new ServerSocket(2009); //creer une socket qui va écouter le port 2009
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socketduserveur = socketserver.accept(); //attend qu'un client se connect au port 2009
		        System.out.println("Un client s'est connecté");
			out = new PrintWriter(socketduserveur.getOutputStream()); //echange avec le client
		        out.println("Vous êtes connecté !");
		        out.flush();
		                
			

		        socketduserveur.close();
		        socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

}

/*

public class Serveur {

	public static ServerSocket ss = null;
	 public static Thread t;

	 
		public static void main(String[] args) {
			
			try {
				ss = new ServerSocket(2009);
				System.out.println("Le serveur est à l'écoute du port "+ss.getLocalPort());
				
				t = new Thread(new Accepter_connexion(ss));
				t.start();
				
			} catch (IOException e) {
				System.err.println("Le port "+ss.getLocalPort()+" est déjà utilisé !");
			}
}
}

class Accepter_clients implements Runnable {

	   private ServerSocket socketserver;
	   private Socket socket;
	   private int nbrclient = 1;
		public Accepter_clients(ServerSocket s){
			socketserver = s;
		}
		
		public void run() {

	        try {
	        	while(true){
			  socket = socketserver.accept(); // Un client se connecte on l'accepte
	                  System.out.println(socket.getOutputStream()+ " vient de se connecter !");
	                  
	                  socket.close();
	        	}
	        
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
class Accepter_connexion implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;

	public Thread t1;
	public Accepter_connexion(ServerSocket ss){
	 socketserver = ss;
	}
	
	public void run() {
		
		try {
			while(true){
				
			socket = socketserver.accept();
			System.out.println("Un zéro veut se connecter  ");
			
			t1 = new Thread(new Authentification(socket));
			t1.start();
			
			}
		} catch (IOException e) {
			
			System.err.println("Erreur serveur");
		}
		
	}
}

 class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String login = "zero", pass =  null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
			
			login = "manon";
			
			

			pass = "manon";

			
				
				out.println("connecte");
				System.out.println(login +" vient de se connecter ");
				out.flush();
				authentifier = true;	
			
		 }
			t2 = new Thread(new Chat_ClientServeur(socket,login));
			t2.start();
			
		} catch (IOException e) {
			
			System.err.println(login+" ne répond pas !");
		}
	}
	
	

 }

 class Chat_ClientServeur implements Runnable {

		private Socket socket = null;
		private BufferedReader in = null;
		private PrintWriter out = null;
		private String login = "zero";
		private Thread t3, t4;
		
		
		public Chat_ClientServeur(Socket s, String log){
			
			socket = s;
			login = log;
		}
		public void run() {
			
			try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			Thread t3 = new Thread(new Reception(in,login));
			t3.start();
			Thread t4 = new Thread(new Emission(out));
			t4.start();
			
			} catch (IOException e) {
				System.err.println(login +"s'est déconnecté ");
			}
	}
	}

 class Emission implements Runnable {

		private PrintWriter out;
		private String message = null;
		private Scanner sc = null;
		
		public Emission(PrintWriter out) {
			this.out = out;
		}

		
		public void run() {
			
			  sc = new Scanner(System.in);
			  
			  while(true){
				    System.out.println("Votre message :");
					message = sc.nextLine();
					out.println(message);
				    out.flush();
				  }
		}
	}

 class Reception implements Runnable {

		private BufferedReader in;
		private String message = null, login = null;
		
		public Reception(BufferedReader in, String login){
			
			this.in = in;
			this.login = login;
		}
		
		public void run() {
			
			while(true){
		        try {
		        	
				message = in.readLine();
				System.out.println(login+" : "+message);
				
			    } catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

	}
*/
