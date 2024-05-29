package tp7_mensajes.ej7b;

import tp7_mensajes.Channel;
import java.util.ArrayList;

public class ServerP7b extends Thread {
    Channel ch1, ch3, ch4;
    int limit;
    int index = 0;
    ArrayList<Channel> threads = new ArrayList<>();

    public ServerP7b(Channel ch1, Channel ch3, Channel ch4, int limit) {
        this.ch1 = ch1;
        this.ch3 = ch3;
        this.ch4 = ch4;
        this.limit = limit;
    }

    @Override
    public void run() {
        startThreads();
        while (true) {
            int i = (int) ch3.receive();
            threads.get(index++).send(i);
            index = index % limit;
        }
    }

    private void startThreads() {
        for (int i = 0; i < limit; i++) {
            Channel chPW = new Channel();
            Worker7b w = new Worker7b(i, chPW, ch1, ch4);
            w.start();
            threads.add(chPW);
        }
        System.out.println("Todos los threads han sido credos");
    }
}