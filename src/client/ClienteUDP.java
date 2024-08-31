package client;

import java.io.IOException;
import java.net.*;

public class ClienteUDP {
    private DatagramSocket socket;
    private InetAddress ip;
    private byte[] buffer;

    public ClienteUDP()
            throws UnknownHostException, SocketException {
        socket = new DatagramSocket();
        ip = InetAddress.getByName("localhost");
        buffer = new byte[128];
    }

    public void sendDatagram() {
        // Creación del Datagram
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
        // Enviar el datagram
        try {
            socket.send(packet);

            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String recibido = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Recibido: " + recibido);

            String mensaje = "Gracias por recibir mi Datagram Gracias por recibir mi Datagram Gracias por recibir mi Datagram aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
            socket.send(packet);

            mensaje = "Jose Sanabria SSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
            socket.send(packet);

            mensaje = "Java FullStack JAvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 345555555555446666666666666666666666666666666666666666666666666666666666666666jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj";
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
            socket.send(packet);

            mensaje = "Clase 2 Java";
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
            socket.send(packet);

            mensaje = "Duke es la mascota de Java";
            buffer = mensaje.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, ip, 5001);
            socket.send(packet);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
