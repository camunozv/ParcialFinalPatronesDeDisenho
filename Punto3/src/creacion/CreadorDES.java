package creacion;

import encriptacion.InterfaceEncriptar;
import encriptacion.ProcesoEncriptarDES;

public class CreadorDES implements Creador{
    @Override
    public InterfaceEncriptar crearProcesoEncriptacion() {
        return new ProcesoEncriptarDES();
    }
}
