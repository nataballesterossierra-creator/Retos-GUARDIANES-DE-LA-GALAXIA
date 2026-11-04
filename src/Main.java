import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc, subOpc;

        do {
            System.out.println("\n===== GUARDIANES DE LA GALAXIA =====");
            System.out.println("1. Nivel 1");
            System.out.println("2. Nivel 2");
            System.out.println("3. Nivel 3");
            System.out.println("4. Ejecutar todos los niveles");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opc = sc.nextInt();

            switch (opc) {

                case 1:
                    do {
                        System.out.println("\n===== NIVEL 1 =====");
                        System.out.println("1. Reto 1");
                        System.out.println("2. Reto 2");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione un reto: ");

                        subOpc = sc.nextInt();

                        switch (subOpc) {
                            case 1:
                                Nivel_1.ejercicio1();
                                break;
                            case 2:
                                Nivel_1.ejercicio2();
                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal...");
                                break;
                            default:
                                System.out.println("Error.");
                        }

                    } while (subOpc != 0);
                    break;

                case 2:
                    do {
                        System.out.println("\n===== NIVEL 2 =====");
                        System.out.println("1. Reto 3");
                        System.out.println("2. Reto 4");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione un reto: ");

                        subOpc = sc.nextInt();

                        switch (subOpc) {
                            case 1:
                                Nivel_2.ejercicio3();
                                break;
                            case 2:
                                Nivel_2.ejercicio4();
                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal..");
                                break;
                            default:
                                System.out.println("Error.");
                        }

                    } while (subOpc != 0);
                    break;

                case 3:
                    do {
                        System.out.println("\n===== NIVEL 3 =====");
                        System.out.println("1. Reto 5");
                        System.out.println("2. Reto 6");
                        System.out.println("3. Reto 7");
                        System.out.println("0. Regresar al menú principal");
                        System.out.print("Seleccione un reto: ");

                        subOpc = sc.nextInt();

                        switch (subOpc) {
                            case 1:
                                Nivel_3.ejercicio5();
                                break;
                            case 2:
                                Nivel_3.ejercicio6();
                                break;
                            case 3:
                                Nivel_3.ejercicio7();
                                break;
                            case 0:
                                System.out.println("Redirigiendo al menú principal...");
                                break;
                            default:
                                System.out.println("Error.");
                        }

                    } while (subOpc != 0);
                    break;

                case 4:
                    Nivel_1.ejecutar();
                    Nivel_2.ejecutar();
                    Nivel_3.ejecutar();
                    break;

                case 0:
                        System.out.println("Nos vemos,, hasta la proxima....... *-* ");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opc != 0);


        sc.close();
    }
}