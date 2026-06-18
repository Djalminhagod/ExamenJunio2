package DepartamentoIT;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Gestor {
    private final int RAM_MAXIMA_CLUSTER = 512;
    private ArrayList<NodoServidor> nodos = new ArrayList();

    public void darAltaControlador() throws CapacidadExcedidaException {
        Scanner sc = new Scanner(System.in);
        int ramTotal = 0;
        System.out.println("dime hostname");
        String hostname = sc.nextLine();
        System.out.println("dime la RAM");
        int ram = sc.nextInt();
        if (ram > RAM_MAXIMA_CLUSTER) {
            throw new CapacidadExcedidaException("Demasiada ram");
        }
        System.out.println("Num estimado de usuarios");
        int numEstimadoUsuarios = sc.nextInt();
        ControladorDominio controladorDominio = new ControladorDominio(hostname, ram, numEstimadoUsuarios);
        nodos.add(controladorDominio);
        for (NodoServidor nodo : nodos) {
            ramTotal = ramTotal + nodo.getRamAsignada();
        }
        if (ramTotal > RAM_MAXIMA_CLUSTER) {
            throw new CapacidadExcedidaException("Te pasaste de ram");
        }
    }

    public void darAltaServidorVirtual() throws CapacidadExcedidaException {
        Scanner sc = new Scanner(System.in);
        int ramTotal = 0;
        System.out.println("dime hostname");
        String hostname = sc.nextLine();
        System.out.println("dime la RAM");
        int ram = sc.nextInt();
        if (ram > RAM_MAXIMA_CLUSTER) {
            throw new CapacidadExcedidaException("Demasiada ram");
        }
        sc.nextLine();
        System.out.println("que sistema operativo(Windows o ubuntu)");
        String sistemaOperativo = sc.nextLine();
        if (sistemaOperativo.equals("windows")||sistemaOperativo.equals("ubuntu")) {
            ServidorVirtual servidorVirtual = new ServidorVirtual(hostname, ram, sistemaOperativo);
            nodos.add(servidorVirtual);
            for (NodoServidor nodo : nodos) {
                ramTotal = ramTotal + nodo.getRamAsignada();
            }
            if (ramTotal > RAM_MAXIMA_CLUSTER) {
                throw new CapacidadExcedidaException("Te pasaste de ram");
            }
            return;
        }
        System.err.println("que sistema operativo(Windows o ubuntu)");

    }
    public void apagarNodo() {
        Scanner sc = new Scanner(System.in);
        if (nodos.isEmpty() || nodos==null) {
            throw new ServidorApagadoException("No existe ningun servidor");
        }
        System.out.println("dime hostname");
        String hostname = sc.nextLine();
        for (NodoServidor nodo : nodos) {
            if (nodo.getHostname().equals(hostname)) {
                nodos.remove(nodo);
                System.out.println("nodo apagado");
                return;
            }
        }

        throw  new ServidorApagadoException("No existe ese servidor");
    }
    public void verDashboard() {
        int ramTotal = 0;
        double cargaTotal = 0;
        for (NodoServidor nodo : nodos){
            ramTotal=ramTotal+nodo.getRamAsignada();
            System.out.println(nodo.toString());

        }

        for (NodoServidor nodo : nodos){
            System.out.println("carga adicional: "+nodo.cargaAdicional());
            cargaTotal=cargaTotal+nodo.cargaAdicional();

        }
        System.out.println("Carga adcional total: "+cargaTotal);
        System.out.println("toda ram ocupada es: "+ramTotal);
    }

}

