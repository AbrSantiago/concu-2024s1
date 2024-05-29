package tp7_mensajes.ej7b;

import tp7_mensajes.Channel;

public class ServerS7b extends Thread {
    Channel ch1;

    public ServerS7b(Channel ch1) {
        this.ch1 = ch1;
    }

    @Override
    public void run() {
        while (true) {
            Req7b req = (Req7b) ch1.receive();
            int coplexCalc = doComplexCalc(req.value);
            req.chSW.send(coplexCalc);
        }
    }

    private static int doComplexCalc(int i) {
        sleep500();
        return 10 * i;
    }

    private static void sleep500() {
        try { Thread.sleep(500); }
        catch (InterruptedException _) { }
    }
}