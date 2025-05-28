package creacion;

import encriptacion.InterfaceEncriptar;
import encriptacion.ProcesoEncriptarAES;

public class CreadorAES implements Creador {
    @Override
    public InterfaceEncriptar crearProcesoEncriptacion() {
        return new ProcesoEncriptarAES();
    }
}
