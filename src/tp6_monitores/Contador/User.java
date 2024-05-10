package tp6_monitores.Contador;

public class User extends Thread {
    Contador contador;
    int i;

    public User(Contador contador, int i) {
        this.contador = contador;
        this.i = i;
    }

    @Override
    public void run() {
        while (i>0) {
            contador.add();
            i--;
        }
        System.out.println("Contador: "+contador.get());
    }
}