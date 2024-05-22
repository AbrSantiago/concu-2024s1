import tp7_mensajes.Channel;
import tp7_mensajes.ej4.Cliente4;
import tp7_mensajes.ej4.Server4;

public static void main() {
    Channel chServer = new Channel();
    Server4 server = new Server4(chServer);
    for (int i = 0; i < 5; i++) {
        Cliente4 c = new Cliente4(i, chServer);
        c.start();
    }
    server.start();
}