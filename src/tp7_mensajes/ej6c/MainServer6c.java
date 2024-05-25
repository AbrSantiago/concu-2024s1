import tp7_mensajes.Channel;
import tp7_mensajes.ej6c.Cliente6c;
import tp7_mensajes.ej6c.ServerK6c;
import tp7_mensajes.ej6c.ServerR6c;
import tp7_mensajes.ej6c.ServerT6c;

import java.util.ArrayList;

public static void main() {
    int SERVERS = 5;
    Channel chCT = new Channel();
    Channel chKT = new Channel();
    ArrayList<Channel> channels = new ArrayList<>();
    for (int i = 0; i < SERVERS; i++) {
        Channel chTR = new Channel();
        channels.add(chTR);
        ServerR6c r = new ServerR6c(i, chTR);
        r.start();
    }
    Cliente6c c = new Cliente6c(chCT, channels);
    ServerK6c k = new ServerK6c(chKT);
    ServerT6c t = new ServerT6c(chCT, chKT);
    c.start();
    k.start();
    t.start();
}