package tp7_mensajes.ej3_server;

import tp7_mensajes.Channel;

public class Req3 {
    String operation;
    Object value;
    Channel channel;

    public Req3(String op, Channel ch){
        this.operation = op;
        this.channel = ch;
    }

    public Req3(String op, Object value){
        this.operation = op;
        this.value = value;
    }
}