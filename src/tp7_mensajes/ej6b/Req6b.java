package tp7_mensajes.ej6b;

import tp7_mensajes.Channel;

public class Req6b {
    Channel channel;
    String msg;

    public Req6b(String msg) {
        this.msg = msg;
    }

    public Req6b(Channel channel, String msg) {
        this.channel = channel;
        this.msg = msg;
    }
}