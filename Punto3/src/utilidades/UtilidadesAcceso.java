package utilidades;

import creacion.Creador;

import java.io.InputStream;
import java.util.Properties;

public class UtilidadesAcceso {

    public static Properties loadProperty(String propertiesURL){
        try {
            Properties properties = new Properties();
            InputStream inputStream = UtilidadesAcceso.class.getClassLoader().getResourceAsStream(propertiesURL);
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Creador obtenerClaseCreador() {
        Properties props = UtilidadesAcceso.loadProperty(
                "propiedades/bridge.properties");
        String factoryClass =
                props.getProperty("tipoEncriptacion");
        try {
            return (Creador)
                    Class.forName(factoryClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
