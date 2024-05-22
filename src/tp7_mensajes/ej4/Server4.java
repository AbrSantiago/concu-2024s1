package tp7_mensajes.ej4;

import tp7_mensajes.Channel;

public class Server4 extends Thread {
    Channel chServer;

    public Server4(Channel ch) {
        this.chServer = ch;
    }

    @Override
    public void run() {
        while (true) {
            Req4 req = (Req4) chServer.receive();
            String res = trim(req.data);
            req.channel.send(res);
        }
    }

    private String trim(String data) {
        if (data == null) {
            return null;
        }
        return data.replaceAll("\\s", "");
    }
}