import tp7_mensajes.Channel;
import tp7_mensajes.ej6a.Cliente6a;
import tp7_mensajes.ej6a.ServerR6a;
import tp7_mensajes.ej6a.ServerT6a;

public static void main() {
    Channel chCT = new Channel();
    Channel chTR = new Channel();
    Cliente6a c = new Cliente6a(chCT);
    ServerT6a t = new ServerT6a(chCT, chTR);
    ServerR6a r = new ServerR6a(chTR);
    c.start();
    t.start();
    r.start();
}