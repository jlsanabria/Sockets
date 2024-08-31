package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
    private final int PORT = 5001;
    private DatagramSocket socket;
    private byte[] buffer;

    public ServidorUDP() {
        buffer = new byte[64];
    }

    public void iniciar() {
        try {
            socket = new DatagramSocket(PORT);
            System.out.println("Servidor UDP escuchando en el puerto " + PORT);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // InetAddress
                InetAddress ip = packet.getAddress();
                int port = packet.getPort();

                String mensaje = "Hola soy el servidor UDP";
                DatagramPacket packetOut = new DatagramPacket(mensaje.getBytes(), mensaje.length(), ip, port);
                socket.send(packetOut);


                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String recibido = new String(packet.getData(), 0, packet.getLength());
                System.out.println(recibido);
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
