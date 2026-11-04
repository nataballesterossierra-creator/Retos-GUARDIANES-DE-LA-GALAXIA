public class Nivel_3 {
    // =====================================================================
    // CLASES DE APOYO
    // =====================================================================

    /** Ejercicio 5: Cola implementada SOLO con dos Pilas. */
    public static class ColaNebula {
        private Pila pilaEntrada = new Pila();
        private Pila pilaSalida = new Pila();

        public boolean estaVacia() {
            return pilaEntrada.estaVacia() && pilaSalida.estaVacia();
        }

        // O(1)
        public void enfilar(Object obj) {
            pilaEntrada.apilar(obj);
        }

        public Object sacar() {
            // Solo se traspasa cuando la de salida está vacía: al invertirse queda orden FIFO
            if (pilaSalida.estaVacia()) {
                while (!pilaEntrada.estaVacia()) {
                    pilaSalida.apilar(pilaEntrada.sacar());
                }
            }
            return pilaSalida.sacar();
        }
    }

   // ---------- Ejercicio 5: El Cerebro Cibernético (cola con 2 pilas) ----------
    public static void ejercicio5() {
        System.out.println("\n--- Ejercicio 5: Cerebro Cibernético de Nebula (Cola con 2 Pilas) ---");
        ColaNebula cola = new ColaNebula();
        cola.enfilar("A");
        cola.enfilar("B");
        cola.enfilar("C");
        System.out.println("Enfilados: A, B, C");
        System.out.println("Sale: " + cola.sacar());
        cola.enfilar("D");
        System.out.println("Enfilado: D");
        while (!cola.estaVacia()) {
            System.out.println("Sale: " + cola.sacar());
        }
    }

    // ---------- Ejercicio 6: La Bóveda del Coleccionista (ordenar pila) ----------
    public static void ordenarPila(Pila gemas) {
        Pila auxiliar = new Pila();

        while (!gemas.estaVacia()) {
            int temp = (int) gemas.sacar();

            // Mientras la cima de la auxiliar sea menor que temp, se devuelve a 'gemas'
            while (!auxiliar.estaVacia() && (int) auxiliar.verPrimero() < temp) {
                gemas.apilar(auxiliar.sacar());
            }
            auxiliar.apilar(temp);
        }
        // Se regresa todo: se invierte el orden y la gema de mayor poder queda arriba
        while (!auxiliar.estaVacia()) {
            gemas.apilar(auxiliar.sacar());
        }
    }

    public static void ejercicio6() {
        System.out.println("\n--- Ejercicio 6: La Bóveda del Coleccionista (Ordenar Pila) ---");
        Pila gemas = new Pila();
        gemas.apilar(5);
        gemas.apilar(2);
        gemas.apilar(9);
        gemas.apilar(1);
        gemas.apilar(7);
        gemas.apilar(3);
        System.out.println("Antes:   " + gemas);
        ordenarPila(gemas);
        System.out.println("Después: " + gemas + "   (mayor arriba)");
    }


    /** Ejercicio 7: Sector de escudos de la Milano. */
    public static class Sector {
        private String nombre;
        private int energiaFaltante;

        public Sector(String nombre, int energiaFaltante) {
            this.nombre = nombre;
            this.energiaFaltante = energiaFaltante;
        }

        public String getNombre() { return nombre; }

        public int getEnergiaFaltante() { return energiaFaltante; }

        public void cargar(int unidades) {
            energiaFaltante = Math.max(0, energiaFaltante - unidades);
        }

        @Override
        public String toString() {
            return nombre + "(" + energiaFaltante + ")";
        }
    }

    // ---------- Ejercicio 7: Deflectores de la Milano (Round-Robin) ----------
    public static void roundRobin(Nivel_1.Cola sectores, int energiaPorCiclo) {
        while (!sectores.estaVacia()) {
            Sector s = (Sector) sectores.sacar();
            s.cargar(energiaPorCiclo);
            if (s.getEnergiaFaltante() > 0) {
                System.out.println("Cargando " + s.getNombre() + "... Restan "
                        + s.getEnergiaFaltante() + " para el 100%.");
                sectores.enfilar(s);
            } else {
                System.out.println("Cargando " + s.getNombre() + "... ¡100%! Sale de la cola.");
            }
        }
    }

    public static void ejercicio7() {
        System.out.println("\n--- Ejercicio 7: Deflectores de la Milano (Round-Robin) ---");
        Nivel_1.Cola sectores = new Nivel_1.Cola();
        sectores.enfilar(new Sector("Frontal", 25));
        sectores.enfilar(new Sector("Trasero", 10));
        sectores.enfilar(new Sector("Izquierdo", 40));
        sectores.enfilar(new Sector("Derecho", 5));
        System.out.println("Cola inicial: " + sectores + "\n");
        roundRobin(sectores, 10);
        System.out.println("\nTodos los escudos al 100%.");
    }
    // =====================================================================
    // EJECUCIÓN DEL NIVEL
    // =====================================================================

    public static void ejecutar() {
        System.out.println("\n########## NIVEL 3: HÉROE DE LA GALAXIA ##########");
        ejercicio5();
        ejercicio6();
        ejercicio7();
    }
}

