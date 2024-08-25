import client.Cliente;

public class ThirdCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("localhost", 5555);
        cliente.conectar();
    }
}
