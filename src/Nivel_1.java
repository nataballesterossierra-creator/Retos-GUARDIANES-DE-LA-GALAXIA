public class Nivel_1 {


    // =====================================================================
    // CLASES DE APOYO
    // =====================================================================
    // /** Ejercicio 1: Pila con capacidad máxima. */


    public static class PilaLimitada extends Pila {
        private int capacidadMaxima;
        private int cantidadActual;

        public PilaLimitada(int max) {
            this.capacidadMaxima = max;
            this.cantidadActual = 0;
        }

        @Override
        public void apilar(Object nuevoObjeto) {
            if (cantidadActual >= capacidadMaxima) {
                System.out.println("  [!] La pila ha alcanzado su límite (" + capacidadMaxima + ").");
                return;
            }
            super.apilar(nuevoObjeto);
            cantidadActual++;
        }

        @Override
        public Object sacar() {
            if (cantidadActual == 0) {
                System.out.println("  [!] La pila está vacía.");
                return null;
            }
            cantidadActual--;
            return super.sacar();
        }

        @Override
        public void vaciar() {
            super.vaciar();
            cantidadActual = 0;
        }
    }
    /*         Funcionamiento en consola     */

    public static void ejercicio1() {
        System.out.println("\n--- Ejercicio 1: El Cargador de Rocket (Pila Limitada) ---");
        PilaLimitada cargador = new PilaLimitada(5);

        for (int i = 1; i <= 6; i++) {
            System.out.println("Apilando batería " + i);
            cargador.apilar("Batería " + i);
        }
        System.out.println("Cargador: " + cargador);
        System.out.println("Disparo, sale: " + cargador.sacar());
        System.out.println("Cargador: " + cargador);
    }


    /** Cola (FIFO) con nodos. Se reutiliza en los niveles 2 y 3. */
    public static class Cola {
        private Pila.Nodo primeroEnLaCola;
        private Pila.Nodo ultimoEnLaCola;
        private long cantidad = 0;

        public boolean estaVacia() { return primeroEnLaCola == null; }

        public void vaciar() {
            primeroEnLaCola = null;
            ultimoEnLaCola = null;
            cantidad = 0;
        }

        public long largo() { return cantidad; }

        public Object verPrimero() { return estaVacia() ? null : primeroEnLaCola.contenido; }

        public Object verUltimo() { return estaVacia() ? null : ultimoEnLaCola.contenido; }

        // Enfilar: insertar al final
        public void enfilar(Object nuevoObjeto) {
            Pila.Nodo nuevoNodo = new Pila.Nodo(nuevoObjeto);
            if (estaVacia()) {
                primeroEnLaCola = nuevoNodo;
            } else {
                ultimoEnLaCola.siguiente = nuevoNodo;
            }
            ultimoEnLaCola = nuevoNodo;
            cantidad++;
        }

        // Sacar: eliminar del principio
        public Object sacar() {
            if (estaVacia()) return null;
            Object dato = primeroEnLaCola.contenido;
            primeroEnLaCola = primeroEnLaCola.siguiente;
            if (primeroEnLaCola == null) ultimoEnLaCola = null;
            cantidad--;
            return dato;
        }

        @Override
        public String toString() {
            if (estaVacia()) return "[vacía]";
            StringBuilder sb = new StringBuilder("salida -> ");
            Pila.Nodo actual = primeroEnLaCola;
            while (actual != null) {
                sb.append(actual.contenido);
                if (actual.siguiente != null) sb.append(" | ");
                actual = actual.siguiente;
            }
            return sb.append(" <- entrada").toString();
        }
    }


    /* Ejercicio 2: El Walkman de Star-Lord*/

    public static void reproducirSiguiente(Cola playlist) {
        Object cancion = playlist.sacar();
        if (cancion == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        System.out.println("Reproduciendo: " + cancion);
        playlist.enfilar(cancion);   // vuelve al final: bucle infinito
    }

    public static void ejercicio2() {
        System.out.println("\n--- Ejercicio 2: El Walkman de Star-Lord (Cola Cíclica) ---");
        Cola playlist = new Cola();
        playlist.enfilar(" Tonight ");
        playlist.enfilar(" After You ");
        playlist.enfilar(" Outro: Tear ");

        for (int i = 0; i < 5; i++) {
            reproducirSiguiente(playlist);
        }
        System.out.println("Estado final: " + playlist);
    }

    // =====================================================================
    // EJECUCIÓN DEL NIVEL
    // =====================================================================

    public static void ejecutar() {
        System.out.println("\n########## NIVEL 1: RECLUTA NOVA ##########");
        ejercicio1();
        ejercicio2();
    }




}
