package tp7_mensajes.ej6c;

import tp7_mensajes.Channel;

public class ServerK6c extends Thread {
    Channel chKT;

    public ServerK6c(Channel chKT) {
        this.chKT = chKT;
    }

    @Override
    public void run() {
        while (true) {
            chKT.send("key");
            sleep400();
        }
    }

    private void sleep400() {
        try { Thread.sleep(400); }
        catch (InterruptedException _) { }
    }
}