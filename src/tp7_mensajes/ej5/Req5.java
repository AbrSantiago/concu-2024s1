package tp7_mensajes.ej5;

import tp7_mensajes.Channel;

public class Req5 {
    Channel chClientToThread;
    Channel chThreadToClient;

    public Req5(Channel chClientToThread, Channel chThreadToClient) {
        this.chClientToThread = chClientToThread;
        this.chThreadToClient = chThreadToClient;
    }
}