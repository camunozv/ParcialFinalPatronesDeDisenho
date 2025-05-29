package servicios;

import utilidades.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeguridadBD {

    private static final String DB_URL = "jdbc:postgresql://mainline.proxy.rlwy.net:18567/railway";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "GRFlTcTWumUZrZtmXFJvgiJkvyLVyxHS";

    private static final String JDBC_DRIVER = "org.postgresql.Driver"; // For PostgreSQL

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public boolean autenticarUsuario(String nombreUsuario1, String contrasenha) throws Exception {

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            statement = connection.createStatement();

            String sql = "SELECT * FROM Usuario WHERE nombreUsuario = " + "\'" + nombreUsuario1 + "\'";

            resultSet = statement.executeQuery(sql);

            int columnCount = resultSet.getMetaData().getColumnCount();

            int id = 0;
            String nombreUsuarioBd = "";
            String contrasenhaBd = "";

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object columnValue = resultSet.getObject(i);
                    System.out.println(columnValue.toString());
                    if (i == 1) {
                       id = Integer.parseInt(columnValue.toString());
                    } else if (i == 2) {
                        nombreUsuarioBd = columnValue.toString();
                    } else {
                        contrasenhaBd = columnValue.toString();
                    }
                }
            }

            System.out.println("------- Successfully connected to data base --------");
            System.out.println();

            return nombreUsuario1.equals(nombreUsuarioBd) && contrasenha.equals(contrasenhaBd);

        } catch (Exception e) {
            connection.close();
            throw new RuntimeException(e);
        }

    }
}
