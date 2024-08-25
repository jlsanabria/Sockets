package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AtencionCliente implements Runnable {
    private Socket client;

    public AtencionCliente(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Nueva conexión");
        // Flujo de comunicación para enviar mensaje al cliente
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(client.getOutputStream());
            // Flujo de comunicación para recibir respuestas del cliente
            DataInputStream in = new DataInputStream(client.getInputStream());
            // Lector de datos por teclado
            Scanner teclado = new Scanner(System.in);
            out.writeUTF("Bienvenido(a), ¿cuál es tu nombre?");
            String nombre = in.readUTF();
            System.out.println("Cliente conectado: " + nombre);

            String mensaje;
            while ((mensaje = teclado.nextLine()) != null) {
                out.writeUTF("Servidor: " + mensaje);
                System.out.println(nombre + ": " + in.readUTF());
            }

        } catch (IOException e) {
            System.out.println("Error en el envio/recibo de mensajes");
            throw new RuntimeException(e);
        }
    }

    private String horaActual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
