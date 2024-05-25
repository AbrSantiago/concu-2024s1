import tp7_mensajes.Channel;
import tp7_mensajes.ej7a.Cliente7a;
import tp7_mensajes.ej7a.ServerP7a;
import tp7_mensajes.ej7a.ServerS7a;

public static void main() {
    Channel ch1 = new Channel();
    Channel ch2 = new Channel();
    Channel ch3 = new Channel();
    Channel ch4 = new Channel();
    Cliente7a c = new Cliente7a(ch3, ch4);
    ServerP7a p = new ServerP7a(ch1, ch2, ch3, ch4);
    ServerS7a s = new ServerS7a(ch1, ch2);
    c.start();
    p.start();
    s.start();
}
