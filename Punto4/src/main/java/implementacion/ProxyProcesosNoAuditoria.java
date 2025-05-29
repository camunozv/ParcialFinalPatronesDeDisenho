package implementacion;

import servicios.SeguridadBD;

public class ProxyProcesosNoAuditoria implements InterfaceProcesos{

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        SeguridadBD securityService = new SeguridadBD();
        boolean permissions = securityService.autenticarUsuario(Usuario, Password);
        if(!permissions) {
            throw new Exception("El usuario '"+Usuario
                    +"' no tiene privilegios para ejecutar el proceso");
        }

        ProcesoNoAuditoria ejecutorProcess = new ProcesoNoAuditoria();
        ejecutorProcess.EjecutarProcesos(IdProceso, Usuario, Password);

        // No debe haber auditoría aqui.
        System.out.println("Proceso Ejecutado sin auditoria");

    }
}
