package parcial.museoB;

public class PersonajesB extends Thread {
    MuseoB museo;

    public PersonajesB(MuseoB museo) {
        this.museo = museo;
    }

    @Override
    public void run() {
        while (true) {
            museo.permisoBailar.acquireUninterruptibly();
            museo.permisoPausar.acquireUninterruptibly();
            System.out.println("Animatronics bailan");
            museo.permisoPausar.release();
        }
    }
}