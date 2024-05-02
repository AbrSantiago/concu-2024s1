import parcial.museoB.EquipoRenovacionB;
import parcial.museoB.MuseoB;
import parcial.museoB.PersonajesB;
import parcial.museoB.VisitanteB;

public static void main() {
    MuseoB museo = new MuseoB();
    PersonajesB personajes = new PersonajesB(museo);
    EquipoRenovacionB equipo = new EquipoRenovacionB(museo);
    for (int i = 0; i < 3; i++) {
        VisitanteB visitante = new VisitanteB(i, i+1 ,museo);
        visitante.start();
    }
    equipo.start();
    personajes.start();
}