public class Usuario {
    int id;
    String Nombres, Apelliodos, Usuarios, password;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombres='" + Nombres + '\'' +
                ", Apelliodos='" + Apelliodos + '\'' +
                ", Usuarios='" + Usuarios + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean isNull(){
        if(Nombres.equals("") && Apelliodos.equals("") && Usuarios.equals("") && password.equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    public Usuario(int id, String nombres, String apelliodos, String usuarios, String password) {
        this.id = id;
        Nombres = nombres;
        Apelliodos = apelliodos;
        Usuarios = usuarios;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApelliodos() {
        return Apelliodos;
    }

    public void setApelliodos(String apelliodos) {
        Apelliodos = apelliodos;
    }

    public String getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(String usuarios) {
        Usuarios = usuarios;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
