import tp7_mensajes.Channel;
import tp7_mensajes.ej2_server.Cliente2;
import tp7_mensajes.ej2_server.Server2;

public static void main() {
    Channel ch1 = new Channel();
    Channel ch2 = new Channel();
    Server2 server = new Server2(ch1, ch2);
    Cliente2 cl1 = new Cliente2(1, ch1);
    Cliente2 cl2 = new Cliente2(2, ch2);
    server.start();
    cl1.start();
    cl2.start();
}