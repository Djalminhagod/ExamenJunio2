package DepartamentoIT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestor gestor = new Gestor();
        boolean salir = true;
        while (salir) {
            mostrarMenu();
            System.out.println("Elige una opcion ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    try {
                        gestor.darAltaControlador();
                    } catch (CapacidadExcedidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        gestor.darAltaServidorVirtual();
                    } catch (CapacidadExcedidaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        gestor.apagarNodo();
                    } catch (ServidorApagadoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    gestor.verDashboard();
                    break;
                case 5:
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;


            }
        }


    }

    public static void mostrarMenu() {
        System.out.println("---Menu---");
        System.out.println("1: Dar de alta controlador");
        System.out.println("2: Dar de alta servidor virtual");
        System.out.println("3: apagar nodo");
        System.out.println("4: Ver Dashboard de Telemetria");
        System.out.println("5: Salir");
    }
}
