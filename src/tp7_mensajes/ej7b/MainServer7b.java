import tp7_mensajes.Channel;
import tp7_mensajes.ej7b.Cliente7b;
import tp7_mensajes.ej7b.ServerP7b;
import tp7_mensajes.ej7b.ServerS7b;

public static void main() {
    int limit = 10;
    Channel ch1 = new Channel();
    Channel ch3 = new Channel();
    Channel ch4 = new Channel();
    Cliente7b c = new Cliente7b(ch3, ch4);
    ServerP7b p = new ServerP7b(ch1, ch3, ch4, limit);
    ServerS7b s = new ServerS7b(ch1);
    c.start();
    p.start();
    s.start();
}