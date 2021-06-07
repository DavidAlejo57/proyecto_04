package Practica4.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejaCliente extends Thread {
    private Socket client;
    private Scanner in;
    private PrintWriter out;    
    
    public ManejaCliente(Socket client) {
        try {
            this.client = client;
            this.in = new Scanner(client.getInputStream());
            this.out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(ManejaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    @Override
    public void run() {
        String msg;
        int x=(int)Math.floor(Math.random()*(100-1)+1);
        System.out.println(x);
        try {
            out.println("Conectado al Server");
            while(in.hasNextLine()) {
                msg = in.nextLine();
                System.out.println("Mensaje recibido: " + msg);
                if(msg.contains("EXIT")) {
                    out.println("CLOSE:");
                    break;
                } else {
                    int num = Integer.parseInt(msg);
                    if(num > x) {
                        out.println("El numero es muy alto");
                    }else {
			if(num < x) {
                            out.println("El numero es muy pequeño");
			}else {
                            out.println("El numero es correcto");
			}
                    }
                }
            }
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(ManejaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
