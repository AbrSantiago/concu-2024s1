package tp7_mensajes.ej6c;

import tp7_mensajes.Channel;

public class Req6c {
    Channel channel;
    String msg;

    public Req6c(String msg) {
        this.msg = msg;
    }

    public Req6c(Channel channel, String msg) {
        this.channel = channel;
        this.msg = msg;
    }
}