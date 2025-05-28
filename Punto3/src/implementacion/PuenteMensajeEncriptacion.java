/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Java
 * Clase que representa al bridge o puente..
 * La clase implementa InterfaceMensajeEncriptacion y delega la responsabilidad al método de encriptamiento asignado durante la creación del objeto.
 */
package implementacion;

import creacion.Creador;
import encriptacion.InterfaceEncriptar;
import utilidades.UtilidadesAcceso;

import java.util.Properties;

import static utilidades.UtilidadesAcceso.obtenerClaseCreador;

/**
 * @author Fabrizio Bolaño
 */
public class PuenteMensajeEncriptacion implements InterfaceMensajeEncriptacion {
    private InterfaceEncriptar ProcesoEncryptacion;

    public PuenteMensajeEncriptacion() {
        Creador ICreador = obtenerClaseCreador();
        this.ProcesoEncryptacion = ICreador.crearProcesoEncriptacion();
    }

    @Override
    public String EncryptarMensaje(String message, String password) throws Exception {
        return ProcesoEncryptacion.encryptar(message, password);
    }

}