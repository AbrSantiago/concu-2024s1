import parcial.museo.EquipoRenovacion;
import parcial.museo.Museo;
import parcial.museo.Personajes;
import parcial.museo.Visitante;

public static void main() {
    Museo museo = new Museo();
    Personajes personajes = new Personajes(museo);
    EquipoRenovacion equipo = new EquipoRenovacion(museo);
    equipo.start();
    for (int i = 0; i < 3; i++) {
        Visitante visitante = new Visitante(i, i+1 ,museo);
        visitante.start();
    }
    personajes.start();
}