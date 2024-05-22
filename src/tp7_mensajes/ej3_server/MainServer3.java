import tp7_mensajes.Channel;
import tp7_mensajes.ej3_server.Cliente3;
import tp7_mensajes.ej3_server.Server3;

public static void main() {
    Channel chServer = new Channel();
    Server3 server = new Server3(chServer);
    for (int i = 0; i < 5; i++) {
        Cliente3 c = new Cliente3(i, chServer);
        c.start();
    }
    server.start();
}