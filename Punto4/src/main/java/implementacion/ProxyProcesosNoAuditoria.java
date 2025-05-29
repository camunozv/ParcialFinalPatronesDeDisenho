package implementacion;

import servicios.SeguridadBD;

public class ProxyProcesosNoAuditoria implements InterfaceProcesos{

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

        numeroEjecucionesDiarias++;

        ProcesoNoAuditoria ejecutorProcess = new ProcesoNoAuditoria();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);

        // No debe haber auditoría aqui.
        System.out.println("Proceso Ejecutado sin auditoria");
        System.out.println();

    }
}
