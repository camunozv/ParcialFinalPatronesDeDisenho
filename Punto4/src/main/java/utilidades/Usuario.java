package utilidades;

public class Usuario {

    private int id;
    private String nombreUsuario;
    private String contrasenha;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contrasenha) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
}
