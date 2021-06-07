package Practica4.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Server {
	
	@Bean
	public String toString() {
		String txt="";
		System.out.println("Holas");
		try {
			ServerSocket server  = new ServerSocket(8080);
            
            while(true) {
                txt="Esperando cliente...";
                Socket socket = server.accept();
                txt= "Cliente conectado...";
                new ManejaCliente(socket).start();
            }
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return txt;
	}
}
