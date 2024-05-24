import tp7_mensajes.Channel;
import tp7_mensajes.ej5.Cliente5;
import tp7_mensajes.ej5.Server5;

public static void main() {
    Channel chServer = new Channel();
    Server5 server = new Server5(chServer);
    for (int i = 0; i < 5; i++) {
        Cliente5 c = new Cliente5(i, chServer);
        c.start();
    }
    server.start();
}