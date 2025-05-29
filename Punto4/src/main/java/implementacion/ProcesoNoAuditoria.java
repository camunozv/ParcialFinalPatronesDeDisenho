package implementacion;

public class ProcesoNoAuditoria implements InterfaceProcesos{

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {
        System.out.println("proceso sin auditoria: " + IdProceso + " en acciòn");
        System.out.println("proceso sin auditoria: " + IdProceso + " finalizado");
        System.out.println();
    }
}
