package tp6_monitores.ej4_Barrera;

public class BarreraUser extends Thread {
    Barrera barrera;

    public BarreraUser(Barrera barrera) {
        this.barrera = barrera;
    }

    @Override
    public void run() {
        System.out.println("Llegué");
        try {
            barrera.esperar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Me fuí");
    }
}