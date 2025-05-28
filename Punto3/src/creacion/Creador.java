package creacion;

import encriptacion.InterfaceEncriptar;

public interface Creador {
    // This should contain the base method of encryption
    InterfaceEncriptar crearProcesoEncriptacion();
}
