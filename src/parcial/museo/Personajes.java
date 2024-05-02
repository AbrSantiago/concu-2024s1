package parcial.museo;

public class Personajes extends Thread {
    Museo museo;

    public Personajes(Museo museo) {
        this.museo = museo;
    }

    @Override
    public void run() {
        while (true) {
            museo.permisoBailar.acquireUninterruptibly();
            System.out.println("Animatronics bailan");
        }
    }
}
