import tp6_monitores.ej7_RW.RW;
import tp6_monitores.ej7_RW.Reader;
import tp6_monitores.ej7_RW.Writer;

public static void main() {
    RW rw = new RW();
    for (int i = 0; i < 2; i++) {
        Writer w = new Writer(i, rw);
        w.start();
    }
    for (int i = 0; i < 4; i++) {
        Reader r = new Reader(i, rw);
        r.start();
    }
}