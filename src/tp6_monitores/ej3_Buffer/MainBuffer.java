import tp6_monitores.ej3_Buffer.Buffer;
import tp6_monitores.ej3_Buffer.Consumidor;
import tp6_monitores.ej3_Buffer.Productor;

public static void main() {
    Buffer buffer = new Buffer(10);
    Productor p = new Productor(buffer);
    Consumidor c = new Consumidor(buffer);
    c.start();
    p.start();
}