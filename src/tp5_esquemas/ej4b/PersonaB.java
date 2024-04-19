package tp5_esquemas.ej4b;

public class PersonaB extends Thread {
    int id;
    SexoB sexo;
    BolicheB boliche;

    public PersonaB(int id, SexoB sexo, BolicheB boliche) {
        this.id = id;
        this.sexo = sexo;
        this.boliche = boliche;
    }

    @Override
    public void run(){
        System.out.println("Llega " + sexo + " " + id);
        if (sexo == SexoB.HOMBRE) {
            boliche.mutexHombres.acquireUninterruptibly();
            if (boliche.hombres < 25) {
                boliche.hombres++;
                boliche.permisoEntrarHombre.acquireUninterruptibly();
                System.out.println(sexo + " " + id + " entra y baila");
                System.out.println("Hombres: " + boliche.hombres + "  Mujeres: " + boliche.mujeres);
                boliche.permisoEntrarMujer.release();
            } else {
                System.out.println(sexo + " " + id + " se va por falta de espacio");
            }
            boliche.mutexHombres.release();
        } else {
            boliche.mutexMujeres.acquireUninterruptibly();
            if (boliche.mujeres < 25) {
                boliche.mujeres++;
                boliche.permisoEntrarMujer.acquireUninterruptibly();
                System.out.println(sexo + " " + id + " entra y baila");
                System.out.println("Hombres: " + boliche.hombres + "  Mujeres: " + boliche.mujeres);
                boliche.permisoEntrarHombre.release();
            } else {
                System.out.println(sexo + " " + id + " se va por falta de espacio");
            }
            boliche.mutexMujeres.release();
        }
    }
}