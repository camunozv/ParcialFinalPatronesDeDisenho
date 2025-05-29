/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Java
 */
package implementacion;
import servicios.Auditoria;
import servicios.Seguridad;
import servicios.SeguridadBD;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ProxyProcesos implements InterfaceProcesos {

    private int numeroEjecucionesDiarias = 1;

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        SeguridadBD securityService = new SeguridadBD();
        boolean permissions = securityService.autenticarUsuario(Usuario, Password);
        if(!permissions) {
            throw new Exception("El usuario '"+Usuario
                    +"' no tiene privilegios para ejecutar el proceso");
        }

        if (numeroEjecucionesDiarias > 3) {
            throw new Exception("El proceso no puede ejecutarse más de 3 veces al día");
        }

        ProcesoDefecto ejecutorProcess = new ProcesoDefecto();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);

        numeroEjecucionesDiarias++;

        Auditoria audit = new Auditoria();
        audit.AuditoriaServicioUsado(Usuario, ProcesoDefecto.class.getName());
    }

}