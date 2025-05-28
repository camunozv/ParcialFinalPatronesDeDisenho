package creacion;

import encriptacion.InterfaceEncriptar;
import encriptacion.ProcesoSinEncriptar;

public class CreadorSinEncriptar implements Creador {
    @Override
    public InterfaceEncriptar crearProcesoEncriptacion() {
        return new ProcesoSinEncriptar();
    }
}
