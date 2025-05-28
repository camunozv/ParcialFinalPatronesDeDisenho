package creacion;

import encriptacion.InterfaceEncriptar;
import encriptacion.ProcesoEncriptarOther;

public class CreadorOther implements Creador {
    @Override
    public InterfaceEncriptar crearProcesoEncriptacion() {
        return new ProcesoEncriptarOther();
    }
}
