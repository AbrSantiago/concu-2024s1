package parcial.museo;

public class Visitante extends Thread {
    int id;
    int billetes;
    Museo museo;

    // Lectores
    public Visitante(int id, int billetes, Museo museo) {
        this.id = id;
        this.billetes = billetes;
        this.museo = museo;
    }

    @Override
    public void run() {
        museo.mutexL.acquireUninterruptibly();
        museo.visitantes++;
        System.out.println("Visitante "+id+" llega al museo");
        if (museo.visitantes == 1) {
            museo.permisoRenovar.acquireUninterruptibly(); // Robo
        }
        museo.mutexL.release();

        for (int i = 0; i < billetes; i++) {
            System.out.println("Visitante "+id+" inserta billete");
            museo.permisoBailar.release(); // Show ready
        }

        museo.mutexL.acquireUninterruptibly();
        museo.visitantes--;
        System.out.println("Visitante "+id+" se va del museo");
        if (museo.visitantes == 0) {
            museo.permisoRenovar.release(); // Devolución
        }
        museo.mutexL.release();
    }
}