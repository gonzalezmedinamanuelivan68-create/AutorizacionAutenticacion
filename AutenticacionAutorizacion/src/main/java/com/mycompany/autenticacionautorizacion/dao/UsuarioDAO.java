package com.mycompany.autenticacionautorizacion.dao;

import com.mycompany.autenticacionautorizacion.basededatos.ConexionDB;
import com.mycompany.autenticacionautorizacion.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public Usuario validarLogin(String credencial, String password) {
        Usuario usuarioValidado = null;
        String query = "SELECT * FROM Usuarios WHERE (correo = ? OR id_usuario = ?) AND password = ? AND estatus = 'Activo'";
        
        try (Connection con = ConexionDB.getConnection(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, credencial);
            ps.setString(2, credencial); 
            ps.setString(3, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuarioValidado = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("correo"),
                        rs.getString("password"),
                        rs.getString("rol"),
                        rs.getString("estatus")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar login: " + e.getMessage());
        }
        return usuarioValidado;
    }
}