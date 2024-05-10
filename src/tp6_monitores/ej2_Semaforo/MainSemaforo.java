import tp6_monitores.ej2_Semaforo.Chino;
import tp6_monitores.ej2_Semaforo.Semaforo;
import tp6_monitores.ej2_Semaforo.Sushiman;

public static void main() {
    Semaforo permisoComer = new Semaforo(0);
    Semaforo permisoServir = new Semaforo(1);
    Sushiman sushiman = new Sushiman(permisoComer, permisoServir);
    Chino chino = new Chino(permisoComer, permisoServir);
    chino.start();
    sushiman.start();
}