package tp6_monitores.ej4_Barrera;

public class Barrera {
    int size;
    int counter = 0;
    boolean barreraArriba = false;

    public Barrera(int size) {
        this.size = size;
    }

    synchronized void esperar() throws InterruptedException {
        counter++;
        if (counter == size) {
            barreraArriba = true;
            System.out.println("Se levanta la barrera");
            notifyAll();
        }
        while (!barreraArriba) {
            wait();
        }
    }
}