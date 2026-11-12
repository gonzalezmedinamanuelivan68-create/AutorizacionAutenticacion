/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autenticacionautorizacion.modelo;

/**
 *
 * @author Usuario
 */
public class Usuario {
 private int idUsuario;
    private String correo;
    private String password;
    private String rol;
    private String estatus;

    public Usuario(int idUsuario, String correo, String password, String rol, String estatus) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.estatus = estatus;
    }

    // Getters
    public int getIdUsuario() { return idUsuario; }
    public String getCorreo() { return correo; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }
    public String getEstatus() { return estatus; }

    // Setters
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setPassword(String password) { this.password = password; }
    public void setRol(String rol) { this.rol = rol; }
    public void setEstatus(String estatus) { this.estatus = estatus; }
  
}
