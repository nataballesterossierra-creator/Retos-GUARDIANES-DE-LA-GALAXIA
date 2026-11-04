import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opc;

        do {
            System.out.println("\n==========================================");
            System.out.println("     GUARDIANES DE LA GALAXIA - NOVA        ");
            System.out.println("==========================================");
            System.out.println("1. Nivel 1: Recluta Nova (Ejercicios 1 y 2)");
            System.out.println("2. Nivel 2: Guardián Experimentado (Ejercicios 3 y 4)");
            System.out.println("3. Nivel 3: Héroe de la Galaxia (Ejercicios 5, 6 y 7)");
            System.out.println("4. Ejecutar todos los niveles");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opc = sc.nextInt();



            switch (opc) {
                case 1: Nivel_1.ejecutar(); break;
                case 2: Nivel_2.ejecutar(); break;
                case 3: Nivel_3.ejecutar(); break;
                case 4:
                    Nivel_1.ejecutar();
                    Nivel_2.ejecutar();
                    Nivel_3.ejecutar();
                    break;
                case 0: System.out.println("¡Hasta la próxima, Guardián!"); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opc != 0);

        sc.close();
    }
}