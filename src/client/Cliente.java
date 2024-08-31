package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {
    private String host;
    private int port;
    private Socket socket;

    public Cliente(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void conectar() {
        try  {
            socket = new Socket(host, port);
            // Recibir mensajes del servidor
            DataInputStream recibirMensaje = new DataInputStream(socket.getInputStream());
            // Enviar mensajes al servidor
            DataOutputStream enviarMensaje = new DataOutputStream(socket.getOutputStream());

            Scanner teclado = new Scanner(System.in);

            System.out.println(recibirMensaje.readUTF()); // Mostrando el mensaje de bienvenida del servidor

            String respuesta;
            while((respuesta = teclado.nextLine()) != null) {
                enviarMensaje.writeUTF(respuesta);
                System.out.println(recibirMensaje.readUTF());
            }

        } catch (IOException e) {
            if(e instanceof ConnectException) {
                System.out.println("No se puede conectar al servidor :(");
            }
            //throw new RuntimeException(e);
        }
    }
}
