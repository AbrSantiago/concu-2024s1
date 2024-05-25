import tp7_mensajes.Channel;
import tp7_mensajes.ej6b.Cliente6b;
import tp7_mensajes.ej6b.ServerR6b;
import tp7_mensajes.ej6b.ServerT6b;
import java.util.ArrayList;

public static void main() {
    int SERVERS = 5;
    Channel chCT = new Channel();
    ArrayList<Channel> channels = new ArrayList<>();
    for (int i = 0; i < SERVERS; i++) {
        Channel chTR = new Channel();
        channels.add(chTR);
        ServerR6b r = new ServerR6b(i, chTR);
        r.start();
    }
    Cliente6b c = new Cliente6b(chCT, channels);
    ServerT6b t = new ServerT6b(chCT);
    c.start();
    t.start();
}