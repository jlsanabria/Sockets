package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    private final int PORT = 5555; // Variable constante del puerto

    //private int puerto;
    private ServerSocket server;

//    public Servidor(int puerto) {
//        this.puerto = puerto;
//    }

    public void iniciar() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Servidor escuchando en el puerto " + PORT);
            while (true) {
                Socket client = server.accept(); // Cuando se conecta el cliente
                new Thread(new AtencionCliente(client)).start();
            }
        } catch (IOException errorIO) {
            if(errorIO instanceof BindException) {
                System.out.println("El host y el puerto ya estan siendo utilizados.");
            }
            //throw new RuntimeException(e);
        }
    }

}
