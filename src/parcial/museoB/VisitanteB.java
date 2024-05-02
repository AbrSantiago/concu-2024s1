package parcial.museoB;

public class VisitanteB extends Thread {
    int id;
    int billetes;
    MuseoB museo;

    // Lectores
    public VisitanteB(int id, int billetes, MuseoB museo) {
        this.id = id;
        this.billetes = billetes;
        this.museo = museo;
    }

    @Override
    public void run() {
        // Robo de permiso
        museo.mutexP.acquireUninterruptibly();
        museo.permisoVisitar.acquireUninterruptibly();
        museo.mutexL.acquireUninterruptibly();
        museo.visitantes++;
        System.out.println("Visitante "+id+" llega al museo");
        if (museo.visitantes == 1) {
            museo.permisoRenovar.acquireUninterruptibly();
        }
        museo.mutexL.release();
        museo.permisoVisitar.release();
        museo.mutexP.release();

        // Show
        for (int i = 0; i < billetes; i++) {
            System.out.println("Visitante "+id+" inserta billete");
            museo.permisoBailar.release();
        }

        // Devolución de permiso
        museo.mutexL.acquireUninterruptibly();
        museo.visitantes--;
        System.out.println("Visitante "+id+" se va del museo");
        if (museo.visitantes == 0) {
            museo.permisoRenovar.release();
        }
        museo.mutexL.release();
    }
}