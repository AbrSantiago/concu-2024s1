import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public static void main() throws InterruptedException {
    // Agregar semáforos para que simultáneamente:
    // La cantidad de `F' es menor o igual a la cantidad de `A'.
    // La cantidad de `H' es menor o igual a la cantidad de `E'.
    // La cantidad de `C' es menor o igual a la cantidad de `G'.
    Semaphore permisoF = new Semaphore(0);
    Semaphore permisoH = new Semaphore(0);
    Semaphore permisoC = new Semaphore(0);
    Semaphore permisoPrint = new Semaphore(0);
    ArrayList<Character> bichos = new ArrayList<>();
    Thread T1 = new Thread(() -> {
        for (int i = 0; i < 20; i++) {
            System.out.print("A");
            bichos.add('A');
            permisoF.release();
            System.out.print("B");
            bichos.add('B');
            try {
                permisoC.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("C");
            bichos.add('C');
            System.out.print("D");
            bichos.add('D');
            permisoPrint.release();
        }
    });
    Thread T2 = new Thread(() -> {
        for (int i = 0; i < 20; i++) {
            System.out.print("E");
            bichos.add('E');
            permisoH.release();
            try {
                permisoF.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("F");
            bichos.add('F');
            System.out.print("G");
            bichos.add('G');
            permisoC.release();
            permisoPrint.release();
        }
    });
    Thread T3 = new Thread(() -> {
        for (int i = 0; i < 20; i++) {
            try {
                permisoH.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("H");
            bichos.add('H');
            System.out.print("I");
            bichos.add('I');
            permisoPrint.release();
        }
    });

    T1.start();
    T2.start();
    T3.start();

    for (int i = 0; i < 60; i++) {
        permisoPrint.acquire();
    }
    System.out.println(" ");
    System.out.println("Cantidad de 'F': " + contarLetras(bichos, 'F'));
    System.out.println("Cantidad de 'A': " + contarLetras(bichos, 'A'));
    System.out.println("Cantidad de 'H': " + contarLetras(bichos, 'H'));
    System.out.println("Cantidad de 'E': " + contarLetras(bichos, 'E'));
    System.out.println("Cantidad de 'C': " + contarLetras(bichos, 'C'));
    System.out.println("Cantidad de 'G': " + contarLetras(bichos, 'G'));
}

public static int contarLetras(ArrayList<Character> letras, char letra) {
    int contador = 0;
    for (char l : letras) {
        if (l == letra) {
            contador++;
        }
    }
    return contador;
}
