/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Java
 */
package implementacion;

/**
 * @author Fabrizio Bolaño
 */
public class FabricaServicios {
    public static InterfaceProcesos CrearEjecucionProceso(String tipoProceso) {
        if (tipoProceso.equals("Auditable")) {
            return new ProxyProcesos();
        } else if (tipoProceso.equals("No auditable")) {
            return new ProxyProcesosNoAuditoria();
        } else {
            return null;
        }

    }
}
