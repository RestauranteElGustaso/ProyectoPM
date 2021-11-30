package com.example.entregadecomida;

public class Usuario {
int id;
String Nombres, Apellidos, Usuario, password;

    public boolean isNull(){
        if(Nombres.equals("") && Apellidos.equals("") && Usuario.equals("") && password.equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuarios='" + Usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Usuario() {

    }

    public Usuario(String nombres, String apellidos, String usuarios, String password) {
        Nombres = nombres;
        Apellidos = apellidos;
        Usuario = usuarios;
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
