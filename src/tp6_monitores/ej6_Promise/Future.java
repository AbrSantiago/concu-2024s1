package tp6_monitores.ej6_Promise;

public interface Future {
    Object get() throws InterruptedException;
}