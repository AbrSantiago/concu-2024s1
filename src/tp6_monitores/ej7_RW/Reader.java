package tp6_monitores.ej7_RW;

public class Reader extends Thread {
    int id;
    RW rw;

    public Reader(int id, RW rw) {
        this.id = id;
        this.rw = rw;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            biginRead();
            System.out.println("Lector "+id+" leyendo: "+rw.deserialize());
            rw.endRead();
        }
    }

    private void biginRead() {
        try { rw.beginRead(); }
        catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}