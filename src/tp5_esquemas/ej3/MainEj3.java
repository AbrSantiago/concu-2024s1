import tp5_esquemas.ej3.Cliente;
import tp5_esquemas.ej3.Ejercicio;
import tp5_esquemas.ej3.Gym;

import java.util.List;

public static void main() {
    Gym gym = new Gym();
    Ejercicio ejercicio1 = new Ejercicio(1,5);
    Ejercicio ejercicio2 = new Ejercicio(2,10);
    List<Ejercicio> rutina1 = List.of(ejercicio1);
    List<Ejercicio> rutina2 = List.of(ejercicio2);
    List<List<Ejercicio>> rutinas = List.of(rutina1,rutina2,rutina2,rutina1);

    int i = 0;
    for (List<Ejercicio> rutina : rutinas) {
        Cliente cliente = new Cliente(i, rutina, gym);
        i++;
        cliente.start();
    }
}