import parcial.lavaderoB.LavaderoB;
import parcial.lavaderoB.MaquinaB;
import parcial.lavaderoB.Robot;
import parcial.lavaderoB.VehiculoB;

public static void main() {
    int autosATestear = 10;

    LavaderoB lavadero = new LavaderoB();
    for (int i = 0; i < 6; i++) {
        Robot robot = new Robot(i, lavadero);
        robot.start();
        lavadero.bufferRobots.add(robot);
    }
    for (int i = 0; i < 7; i++) {
        MaquinaB maquina = new MaquinaB(i, lavadero);
        maquina.start();
        lavadero.estaciones.add(maquina);
    }
    for (int i = 0; i < autosATestear; i++) {
        VehiculoB vehiculo = new VehiculoB(i, lavadero);
        vehiculo.start();
        lavadero.autos.add(vehiculo);
    }
}