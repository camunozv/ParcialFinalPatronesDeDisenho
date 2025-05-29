/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Main()
 */

package patronproxy;

import implementacion.InterfaceProcesos;
import implementacion.FabricaServicios;

import java.util.Scanner;

/**
 * @author Fabrizio Bolaño
 */
public class PatronProxyMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String usuario = "fbolanol";
        String password = "pds";
        int proceso = 1;
        InterfaceProcesos ProcesoActivo = FabricaServicios.CrearEjecucionProceso("No auditable");

        int menu;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------- M E N U -----------");
            System.out.println("Pulse el número de la opción para continuar");
            System.out.println("1. Ejecutar proceso");
            System.out.println("Cualquier otro número para finalizar:");

            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                try {
                    ProcesoActivo.EjecutarProcesos(proceso, usuario, password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (menu == 1);

        scanner.close();

    }

}