package tp5_esquemas.ej4a;

public class Persona extends Thread {
    int id;
    Sexo sexo;
    Boliche boliche;

    public Persona(int id, Sexo sexo, Boliche boliche) {
        this.id = id;
        this.sexo = sexo;
        this.boliche = boliche;
    }

    @Override
    public void run(){
        System.out.println("Llega " + sexo + " " + id);
        if (sexo == Sexo.HOMBRE) {
            boliche.permisoEntrarHombre.acquireUninterruptibly();
            boliche.permisoEntrarMujer.release();
        } else {
            boliche.permisoEntrarMujer.acquireUninterruptibly();
            boliche.permisoEntrarHombre.release();
        }
        System.out.println(sexo + " " + id + " entra y baila");
    }
}