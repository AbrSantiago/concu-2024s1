package tp7_mensajes.ej3_server;

import tp7_mensajes.Channel;

public class Server3 extends Thread {
    Channel channel;
    Object data;

    public Server3(Channel ch) {
        this.channel = ch;
    }

    @Override
    public void run() {
        while (true) {
            Req3 req = (Req3) channel.receive();
            if (req.operation == "Write") {
                data = req.value;
                System.out.println("Data: "+data);
            } else if (req.operation == "Read") {
                req.channel.send(data);
            }
        }
    }
}