package server;

import util.DateUtil;

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

            String respuesta;
            out.writeUTF(mostrarMenu());
            boolean seguir = true;
            do {
                // Ejecutar las opciones de menú
                respuesta = in.readUTF();
                String resultado = ejecutarOpcion(respuesta);
                if (!resultado.isEmpty()) {
                    out.writeUTF(resultado);
                } else {
                    out.writeUTF("Bye!");
                    seguir = false;
                }
            } while (seguir);

            System.out.println("Cliente desconectado: " + nombre);

        } catch (IOException e) {
            System.out.println("Error en el envio/recibo de mensajes");
            throw new RuntimeException(e);
        }
    }

    private String mostrarMenu() {
        //String menu = "";
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append("\n -----   MENÚ  ----- ");
        menuBuilder.append("\n 1. Fecha (dd/MM/aaaa)");
        menuBuilder.append("\n 2. Hora (HH:mm:ss)");
        menuBuilder.append("\n 3. Salir");
        //menu = menuBuilder.toString();
        return menuBuilder.toString();
    }

    private String ejecutarOpcion(String opcion) {
        String response = "\n" + mostrarMenu();
        switch (opcion) {
            case "1":
                response = "Fecha actual: " + DateUtil.fechaActual() + response;
                break;
            case "2":
                response = "Hora actual: " + DateUtil.horaActual() + response;
                break;
            case "3":
                return "";
        }
        return response;
    }

}
