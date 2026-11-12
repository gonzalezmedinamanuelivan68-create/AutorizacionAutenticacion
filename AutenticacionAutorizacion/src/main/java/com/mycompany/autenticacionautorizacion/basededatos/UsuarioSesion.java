package com.mycompany.autenticacionautorizacion.basededatos;

import com.mycompany.autenticacionautorizacion.modelo.Usuario;

public class UsuarioSesion {
    private static UsuarioSesion instancia;
    private Usuario usuarioActivo;

    private UsuarioSesion() {}

    public static UsuarioSesion getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioSesion();
        }
        return instancia;
    }

    public Usuario getUsuarioActivo() { return usuarioActivo; }
    public void setUsuarioActivo(Usuario usuarioActivo) { this.usuarioActivo = usuarioActivo; }
    public void cerrarSesion() { this.usuarioActivo = null; }
}