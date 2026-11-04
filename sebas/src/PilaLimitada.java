// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class PilaLimitada {
    Nodo primeroDeLaPila;
    int capacidadMaxima;
    int cantidadActual;

    public PilaLimitada(int var1) {
        this.capacidadMaxima = var1;
        this.cantidadActual = 0;
    }

    public void apilar(Object var1) {
        if (this.cantidadActual >= this.capacidadMaxima) {
            System.out.println("ERROR: cartucho lleno (" + this.capacidadMaxima + " baterías). ¡El cañón explotaría!");
        } else {
            Nodo var2 = new Nodo(var1);
            var2.siguiente = this.primeroDeLaPila;
            this.primeroDeLaPila = var2;
            ++this.cantidadActual;
            System.out.println("Batería apilada: " + String.valueOf(var1));
        }
    }

    public Object sacar() {
        if (this.primeroDeLaPila == null) {
            return null;
        } else {
            Object var1 = this.primeroDeLaPila.contenido;
            this.primeroDeLaPila = this.primeroDeLaPila.siguiente;
            --this.cantidadActual;
            return var1;
        }
    }

    public Object verTope() {
        return this.primeroDeLaPila == null ? null : this.primeroDeLaPila.contenido;
    }

    public void mostrar() {
        if (this.primeroDeLaPila == null) {
            System.out.println("El cartucho está vacío.");
        } else {
            System.out.println("--- Cartucho (tope arriba) ---");

            for(Nodo var1 = this.primeroDeLaPila; var1 != null; var1 = var1.siguiente) {
                System.out.println("| " + String.valueOf(var1.contenido) + " |");
            }

            System.out.println("------------------------------");
            System.out.println("Ocupación: " + this.cantidadActual + "/" + this.capacidadMaxima);
        }
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        PilaLimitada var2 = new PilaLimitada(5);
        int var3 = 1;
        int var4 = 0;

        do {
            System.out.println("\n===== CAÑÓN DE PLASMA =====");
            System.out.println("1. Apilar batería");
            System.out.println("2. Sacar batería");
            System.out.println("3. Ver batería del tope");
            System.out.println("4. Mostrar cartucho");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                var4 = Integer.parseInt(var1.nextLine().trim());
            } catch (NumberFormatException var7) {
                var4 = 0;
            }

            switch (var4) {
                case 1:
                    if (var2.cantidadActual < var2.capacidadMaxima) {
                        var2.apilar("Batería " + var3);
                        ++var3;
                    } else {
                        var2.apilar("Batería " + var3);
                    }
                    break;
                case 2:
                    Object var5 = var2.sacar();
                    if (var5 == null) {
                        System.out.println("No hay baterías para sacar.");
                    } else {
                        System.out.println("Batería sacada: " + String.valueOf(var5));
                    }
                    break;
                case 3:
                    Object var6 = var2.verTope();
                    System.out.println(var6 == null ? "El cartucho está vacío." : "Tope: " + String.valueOf(var6));
                    break;
                case 4:
                    var2.mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Elige de 1 a 5.");
            }
        } while(var4 != 5);

        var1.close();
    }
}
