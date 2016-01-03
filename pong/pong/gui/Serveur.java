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
		int fileAttente = 100;
		
		try {
		
			socketserver = new ServerSocket(2009, fileAttente, InetAddress.getLocalHost()); //creer une socket qui va écouter le port 2009	
			System.out.println("Le serveur est à l'écoute du port : "+socketserver.getLocalPort()+" à l'adresse ip : "+InetAddress.getLocalHost());
			
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
