package tp6_monitores.ej7_RW;

public class Writer extends Thread {
    int id;
    RW rw;

    public Writer(int id, RW rw) {
        this.id = id;
        this.rw = rw;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            biginWrite();
            rw.serialize("DATA DATA DATA - By writer " + id);
            rw.endWrite();
        }
    }

    private void biginWrite() {
        try { rw.beginWrite(); }
        catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}