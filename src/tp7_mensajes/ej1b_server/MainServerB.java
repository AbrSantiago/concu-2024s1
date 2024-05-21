import tp7_mensajes.Channel;
import tp7_mensajes.ej1b_server.ClienteB;
import tp7_mensajes.ej1b_server.ServerB;

public static void main() {
    Channel chClienteServer = new Channel();
    Channel chServerCliente = new Channel();
    ServerB server = new ServerB(chClienteServer, chServerCliente);
    ClienteB cliente = new ClienteB(chClienteServer, chServerCliente);
    server.start();
    cliente.start();
}