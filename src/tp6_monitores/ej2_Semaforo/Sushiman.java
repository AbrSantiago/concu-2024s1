package tp6_monitores.ej2_Semaforo;

public class Sushiman extends Thread {
    Semaforo permisoComer;
    Semaforo permisoServir;

    public Sushiman(Semaforo permisoComer, Semaforo permisoServir) {
        this.permisoComer = permisoComer;
        this.permisoServir = permisoServir;
    }

    @Override
    public void run() {
        try {
            permisoServir.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Comida servida");
        permisoComer.release();
    }
}