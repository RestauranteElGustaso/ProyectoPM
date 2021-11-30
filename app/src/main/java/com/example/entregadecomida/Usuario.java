package com.example.entregadecomida;

public class Usuario {
int id;
String Nombres, Apellidos, Usuarios, password;

    public boolean isNull(){
        if(Nombres.equals("") && Apellidos.equals("") && Usuarios.equals("") && password.equals("")){
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
                ", Usuarios='" + Usuarios + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Usuario(int id, String nombres, String apellidos, String usuarios, String password) {
        this.id = id;
        Nombres = nombres;
        Apellidos = apellidos;
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

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
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
