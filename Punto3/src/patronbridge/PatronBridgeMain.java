/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Main()
 */

package patronbridge;
import encriptacion.ProcesoEncriptarAES;
import encriptacion.ProcesoEncriptarDES;
import encriptacion.ProcesoEncriptarOther;
import encriptacion.ProcesoSinEncriptar;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronBridgeMain {

    public static void main(String[] args) {

        InterfaceMensajeEncriptacion formatoLeido = new PuenteMensajeEncriptacion();

        try {
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";

            String messageEncrypted = formatoLeido.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Formato Leido > " + messageEncrypted + "\n");

//            String messageAES = formatoLeido.EncryptarMensaje(message, "HG58YZ3CR9123456");
//            System.out.println("Formato AES > " + messageAES + "\n");
//
//            String messageDES = formatoLeido.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
//            System.out.println("Formato DES > " + messageDES + "\n");
//
//            String messageNO = formatoLeido.EncryptarMensaje(message, null);
//            System.out.println("Sin Formato > " + messageNO + "\n");
//
//            String messageOther = formatoLeido.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
//            System.out.println("Formato Other > " + messageOther + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

// aqLxbNOOuHKYdGeqjJ3wHZ/POi9nITVtlt7jkqMJez2J4jRyJW87e3OLaGAYnXgIIvwlF5y08mPcaaCgNYldsg
}