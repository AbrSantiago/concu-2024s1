package tp6_monitores.ej2_Semaforo;

public class Chino extends Thread {
    Semaforo permisoComer;
    Semaforo permisoServir;

    public Chino(Semaforo permisoComer, Semaforo permisoServir) {
        this.permisoComer = permisoComer;
        this.permisoServir = permisoServir;
    }

    @Override
    public void run() {
        try {
            permisoComer.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Comiendo");
        permisoServir.release();
    }
}
