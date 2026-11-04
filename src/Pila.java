public class Pila {

    /** Eslabón básico de Pilas y Colas. */
    static class Nodo {
        Object contenido;
        Nodo siguiente;

        Nodo(Object contenido) {
            this.contenido = contenido;
        }
    }

    Nodo primeroDeLaPila;
    private long cantidad = 0;

    public boolean estaVacia() {
        return primeroDeLaPila == null;
    }

    public void vaciar() {
        primeroDeLaPila = null;
        cantidad = 0;
    }

    public long largo() {
        return cantidad;
    }

    public Object verPrimero() {
        return estaVacia() ? null : primeroDeLaPila.contenido;
    }

    // Apilar (Push)
    public void apilar(Object nuevoObjeto) {
        Nodo nuevoNodo = new Nodo(nuevoObjeto);
        nuevoNodo.siguiente = primeroDeLaPila;
        primeroDeLaPila = nuevoNodo;
        cantidad++;
    }

    // Sacar (Pop)
    public Object sacar() {
        if (estaVacia()) return null;
        Object dato = primeroDeLaPila.contenido;
        primeroDeLaPila = primeroDeLaPila.siguiente;
        cantidad--;
        return dato;
    }

    @Override
    public String toString() {
        if (estaVacia()) return "[vacía]";
        StringBuilder sb = new StringBuilder("cima -> ");
        Nodo actual = primeroDeLaPila;
        while (actual != null) {
            sb.append(actual.contenido);
            if (actual.siguiente != null) sb.append(" | ");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}
