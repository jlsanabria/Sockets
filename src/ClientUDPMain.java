import client.ClienteUDP;

import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDPMain {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        ClienteUDP clientUDP = new ClienteUDP();
        clientUDP.sendDatagram();
    }
}
