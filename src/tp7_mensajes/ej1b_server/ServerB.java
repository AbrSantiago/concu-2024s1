package tp7_mensajes.ej1b_server;

import tp7_mensajes.Channel;

public class ServerB extends Thread {
    Channel chClienteServer;
    Channel chServerCliente;
    int counter = 0;

    public ServerB(Channel chClienteServer, Channel chServerCliente) {
        this.chClienteServer = chClienteServer;
        this.chServerCliente = chServerCliente;
    }

    @Override
    public void run() {
        while (true) {
            Object msj = chClienteServer.receive();
            System.out.println("Server recibe: "+msj);
            if (msj == "Cuenta") {
                chServerCliente.send(counter);
                counter = 0;
            } else if (msj == "Sigue"){
                counter++;
            }
        }
    }
}