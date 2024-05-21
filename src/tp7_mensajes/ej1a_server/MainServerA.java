import tp7_mensajes.Channel;
import tp7_mensajes.ej1a_server.ClienteA;
import tp7_mensajes.ej1a_server.ServerA;

public static void main() {
    Channel channel = new Channel();
    ServerA server = new ServerA(channel);
    ClienteA cliente = new ClienteA(channel);
    server.start();
    cliente.start();
}