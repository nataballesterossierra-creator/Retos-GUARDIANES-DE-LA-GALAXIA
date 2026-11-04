public class Nivel_2 {

    /* ---------- Ejercicio 3: El Enredo de Groot (invertir cola con una pila) ----------*/

    public static void invertirCola(Nivel_1.Cola cola) {
        Pila temp = new Pila();
        while (!cola.estaVacia()) {
            temp.apilar(cola.sacar());
        }
        while (!temp.estaVacia()) {
            cola.enfilar(temp.sacar());
        }
    }

    public static void ejercicio3() {
        System.out.println("\n--- Ejercicio 3: El Enredo de Groot (Invertir Cola) ---");
        Nivel_1.Cola coordenadas = new Nivel_1.Cola();
        for (int i = 1; i <= 5; i++) {
            coordenadas.enfilar("C" + i);
        }
        System.out.println("Antes:   " + coordenadas);
        invertirCola(coordenadas);
        System.out.println("Después: " + coordenadas);
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------
    ----------------------------------------------------------------------------------------------------------------------------------------------- */


    /* ---------- Ejercicio 4: El Arsenal de Drax (búsqueda segura) ----------*/
    public static String buscarYExtraer(Pila armas, String objetivo) {
        Pila auxiliar = new Pila();
        String resultado = null;   // null = todavía no encontrada

        while (!armas.estaVacia()) {
            Object arma = armas.sacar();
            if (arma.equals(objetivo)) {
                resultado = (String) arma;
                break;
            }
            auxiliar.apilar(arma);
        }
        while (!auxiliar.estaVacia()) {
            armas.apilar(auxiliar.sacar());
        }
        return resultado;
    }

    public static void ejercicio4() {
        System.out.println("\n--- Ejercicio 4: El Arsenal de Drax (Búsqueda Segura) ---");
        Pila armas = new Pila();
        armas.apilar("Hacha");
        armas.apilar("Pistola");
        armas.apilar("Dagas ");
        armas.apilar("Espada");
        armas.apilar("Escudo");
        System.out.println("Arsenal inicial: " + armas);

        String r = buscarYExtraer(armas, "Dagas ");
        System.out.println(r != null ? "Arma encontrada: " + r : "Arma no encontrada");
        System.out.println("Arsenal (resto en orden): " + armas);

        r = buscarYExtraer(armas, "Lanza");
        System.out.println(r != null ? "Arma encontrada: " + r : "Arma no encontrada: Lanza");
    }

    public static void ejecutar() {

        System.out.println("\n  NIVEL 2: GUARDIÁN EXPERIMENTADO  ");
        ejercicio3();
        ejercicio4();
    }

}
