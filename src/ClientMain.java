import client.Cliente;

public class ClientMain {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 5555);
        cliente.conectar();
    }
}
